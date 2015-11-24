/**
 * Copyright (C) 2012-2015 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.iceland.config.json;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.n52.iceland.exception.ConfigurationError;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.lifecycle.Destroyable;
import org.n52.iceland.service.ConfigLocationProvider;
import org.n52.iceland.util.Debouncer;
import org.n52.iceland.util.JSONUtils;
import org.n52.iceland.util.Producer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Class to encapsulate writes and reads to a JSON file.
 *
 * @since 1.0.0
 *
 * @author Christian Autermann
 */
public class JsonConfiguration implements Constructable,
                                          Destroyable,
                                          Producer<ObjectNode> {

    private static final Logger LOG = LoggerFactory
            .getLogger(JsonConfiguration.class);

    public static final String DEFAULT_FILE_NAME = "configuration.json";
    public static final int DEFAULT_WRITE_TIMEOUT = 1000;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final JsonNodeFactory nodeFactory = JSONUtils.nodeFactory();
    private String fileName = DEFAULT_FILE_NAME;
    private int writeTimeout = DEFAULT_WRITE_TIMEOUT;
    private ObjectNode configuration;
    private File file;
    private ConfigLocationProvider configLocationProvider;
    private Debouncer debouncer;

    /**
     * Initializes this configuration by initializing a {@link Debouncer} for
     * writes and reading the configuration file.
     */
    @Override
    public void init() {
        writeLock().lock();
        try {
            this.debouncer = new Debouncer(this.writeTimeout, this::persist);
            File directory = new File(this.configLocationProvider.get());
            this.file = new File(directory, this.fileName);
            this.refresh();
        } finally {
            writeLock().unlock();
        }
    }

    /**
     * Refreshes the configuration from disk.
     */
    public void refresh() {
        writeLock().lock();
        try {
            this.configuration = readConfiguration(this.file)
                    .orElseGet(nodeFactory::objectNode);
        } finally {
            writeLock().unlock();
        }
    }

    /**
     * Destroys this configuration by executing any pending write.
     *
     * @see Debouncer#finish()
     */
    @Override
    public void destroy() {
        LOG.info("Destroying {}", System.identityHashCode(this));
        this.debouncer.finish();
    }

    /**
     * Deletes the configuration file if it exists.
     */
    public void delete() {

        writeLock().lock();
        try {
            if (this.file.exists() && this.file.isFile()) {
                if (!this.file.delete()) {
                    throw new ConfigurationError("Can not delete configuration file %s", file
                                                 .getAbsolutePath());
                }
            }
        } finally {
            writeLock().unlock();
        }
    }

    /**
     * Gets the (possibly empty) configuration JSON node.
     *
     * @return the node (never {@code null})
     */
    @Override
    public ObjectNode get() {
        return this.configuration;
    }

    /**
     * Sets the time to wait for additional changes before the configuration is
     * persisted.
     *
     * @param writeTimeout the time out in milliseconds
     */
    public void setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    /**
     * Sets the file name of this configuration.
     *
     * @param fileName the file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Sets the configuration location provider.
     *
     * @param configLocationProvider the provider
     */
    @Inject
    public void setConfigLocationProvider(
            ConfigLocationProvider configLocationProvider) {
        this.configLocationProvider = configLocationProvider;
    }

    /**
     * Gets the read lock for this configuration.
     *
     * @return the (reentrant) read lock
     */
    public Lock readLock() {
        return this.lock.readLock();
    }

    /**
     * Gets the write lock for this configuration.
     *
     * @return the (reentrant) write lock
     */
    public Lock writeLock() {
        return this.lock.writeLock();
    }

    /**
     * Schedule a write. This will be executed after the configured
     * {@link #setWriteTimeout timeout} if no further writes are scheduled, else
     * it will postponed until their are no further requests for {@code timeout}
     * milliseconds.
     *
     * @see Debouncer#call()
     */
    public void scheduleWrite() {
//        LOG.debug("Scheduling write");
        this.debouncer.call();
    }
    /**
     * Do not wait, but persist the settings right now.
     */
    public void writeNow() {
        this.persist();
    }

    /**
     * Actually persists the configuration.
     */
    private synchronized void persist() {
        readLock().lock();
        try {
            LOG.debug("Writing configuration file");
            try (FileOutputStream fos = new FileOutputStream(this.file)) {
                JSONUtils.print(fos, this.configuration);
            }
        } catch (IOException e) {
            throw new ConfigurationError("Could not persist configuration", e);
        } finally {
            readLock().unlock();
        }
    }

    /**
     * Reads the configuration, if the file exists.
     *
     * @param file the file holding the configuration
     *
     * @return the decoded JSON object
     */
    private Optional<ObjectNode> readConfiguration(File file) {
        if (!file.exists()) {
            return Optional.empty();
        }
        if (!file.isFile()) {
            throw new ConfigurationError("%s is not a file", file
                                         .getAbsolutePath());
        }
        if (!file.canRead()) {
            throw new ConfigurationError("%s is not a readable file", file
                                         .getAbsolutePath());
        }
        try {
            JsonNode node = JSONUtils.loadFile(file);
            if (!node.isObject()) {
                throw new ConfigurationError("%s does not contain a JSON object", file
                                             .getAbsolutePath());
            }
            return Optional.of((ObjectNode) node);
        } catch (IOException ex) {
            throw new ConfigurationError("Could not read " + file
                                         .getAbsolutePath(), ex);
        }
    }
}

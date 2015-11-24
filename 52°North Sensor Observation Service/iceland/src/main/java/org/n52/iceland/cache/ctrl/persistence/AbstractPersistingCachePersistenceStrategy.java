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
package org.n52.iceland.cache.ctrl.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.n52.iceland.cache.ContentCache;
import org.n52.iceland.cache.ContentCachePersistenceStrategy;
import org.n52.iceland.cache.WritableContentCache;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.service.ConfigLocationProvider;

public abstract class AbstractPersistingCachePersistenceStrategy
        implements ContentCachePersistenceStrategy, Constructable {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AbstractPersistingCachePersistenceStrategy.class);
    public static final String CACHE_FILE = "cache.tmp";
    private String cacheFile;

    private ConfigLocationProvider configLocationProvider;

    @Inject
    public void setConfigLocationProvider(
            ConfigLocationProvider configLocationProvider) {
        this.configLocationProvider = configLocationProvider;
    }

    @Override
    public void init() {
        this.cacheFile = new File(configLocationProvider.get(), CACHE_FILE)
                .getAbsolutePath();
    }

    protected File getCacheFile() {
        return new File(this.cacheFile);
    }

    @Override
    public Optional<WritableContentCache> load() {
        File file = getCacheFile();
        if (file.exists() && file.canRead()) {
            LOGGER.debug("Reading cache from temp file '{}'",
                         file.getAbsolutePath());

            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                return Optional.of((WritableContentCache) ois.readObject());
            } catch (IOException | ClassNotFoundException ex) {
                LOGGER.error(String.format("Error reading cache file '%s'", file
                                           .getAbsolutePath()), ex);
            }
            file.delete();
        } else {
            LOGGER.debug("No cache temp file found at '{}'",
                         file.getAbsolutePath());
        }
        return Optional.empty();
    }

    protected void persistCache(ContentCache cache) {
        File file = getCacheFile();
        if (!file.exists() || file.delete()) {
            if (cache == null) {
                return;
            }

            try {
                if (!file.createNewFile()) {
                    LOGGER.error("Can not create writable file {}", file.getAbsolutePath());
                    return;
                }
            } catch (IOException ex) {
                LOGGER.error(String.format("Error serializing cache to '%s'", file.getAbsolutePath()), ex);
            }

            try (FileOutputStream fos = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                LOGGER.debug("Serializing cache to {}", file.getAbsolutePath());
                oos.writeObject(cache);
            } catch (IOException t) {
                LOGGER.error(String.format("Error serializing cache to '%s'", file.getAbsolutePath()), t);
            }
        }
    }

    @Override
    public void remove() {
        File f = getCacheFile();
        if (f != null && f.exists()) {
            f.delete();
        }
    }
}

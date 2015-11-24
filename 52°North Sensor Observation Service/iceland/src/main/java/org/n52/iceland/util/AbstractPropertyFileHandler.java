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
package org.n52.iceland.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.n52.iceland.exception.ConfigurationError;

/**
 * @since 4.0.0
 *
 */
public class AbstractPropertyFileHandler {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractPropertyFileHandler.class);

    private final File propertiesFile;

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private Properties cache;

    public File getFile(boolean create) throws IOException {
        if (propertiesFile.exists() || (create && propertiesFile.createNewFile())) {
            return propertiesFile;
        }
        return null;
    }

    protected AbstractPropertyFileHandler(String name) {
        this.propertiesFile = new File(name);
    }

    private Properties load() throws IOException {
        if (this.cache == null) {
            File f = getFile(false);
            if (f == null) {
                return new Properties();
            }
            try (InputStream is = new FileInputStream(getFile(true))) {
                Properties p = new Properties();
                p.load(is);
                cache = p;
            }
        }
        return cache;
    }

    private void save(Properties p) throws IOException {
        try (OutputStream os = new FileOutputStream(getFile(true))) {
            p.store(os, null);
            this.cache = p;
        }
    }

    public String get(String m) throws ConfigurationError {
        lock.readLock().lock();
        try {
            return load().getProperty(m);
        } catch (IOException e) {
            throw new ConfigurationError("Error reading properties", e);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void delete(String m) throws ConfigurationError {
        lock.writeLock().lock();
        try {
            Properties p = load();
            p.remove(m);
            save(p);
        } catch (IOException e) {
            throw new ConfigurationError("Error writing properties", e);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void save(String m, String value) throws ConfigurationError {
        lock.writeLock().lock();
        try {
            Properties p = load();
            p.setProperty(m, value);
            save(p);
        } catch (IOException e) {
            throw new ConfigurationError("Error writing properties", e);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void saveAll(Properties properties) throws ConfigurationError {
        lock.writeLock().lock();
        try {
            Properties p = load();
            for (String key : properties.stringPropertyNames()) {
                p.setProperty(key, properties.getProperty(key));
            }
            save(p);
        } catch (IOException e) {
            throw new ConfigurationError("Error writing properties", e);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Properties getAll() throws ConfigurationError {
        lock.readLock().lock();
        try {
            return copyOf(load());
        } catch (IOException e) {
            throw new ConfigurationError("Error reading properties", e);
        } finally {
            lock.readLock().unlock();
        }
    }

    private static Properties copyOf(Properties p) {
        Properties np = new Properties();
        for (String s : p.stringPropertyNames()) {
            np.put(s, p.get(s));
        }
        return np;
    }

    public String getPath() {
        return this.propertiesFile.getAbsolutePath();
    }

    public boolean exists() {
        try {
            return getFile(false) != null;
        } catch (IOException ex) {
            /* won't be thrown */
            throw new RuntimeException(ex);
        }
    }

    public boolean delete() {
        try {
            cache = null;
            LOG.debug("Removing properties file: {}.", getFile(false));
            return exists() ? getFile(false).delete() : true;
        } catch (IOException ex) {
            return false;
        }
    }
}

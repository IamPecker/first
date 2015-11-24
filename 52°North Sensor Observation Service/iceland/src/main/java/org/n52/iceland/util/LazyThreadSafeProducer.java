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

import java.util.Locale;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.n52.iceland.exception.ConfigurationError;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.UncheckedExecutionException;

public abstract class LazyThreadSafeProducer<T> implements LocalizedProducer<T> {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final LoadingCache<Locale, T> cache = CacheBuilder.newBuilder()
            .build(new CacheLoader<Locale, T>() {
                @Override
                public T load(Locale key) {
                    return create(key);
                }
            });

    private T nullLocale = null;

    protected void setRecreate() {
        this.lock.writeLock().lock();
        try {
            this.nullLocale = null;
        } finally {
            this.lock.writeLock().unlock();
        }
        this.cache.invalidateAll();
    }

    @Override
    public T get() throws ConfigurationError {
        this.lock.readLock().lock();
        try {
            if (this.nullLocale != null) {
                return this.nullLocale;
            }
        } finally {
            this.lock.readLock().unlock();
        }

        // default value is null, create it
        this.lock.writeLock().lock();
        try {
            // check if someone was faster
            if (this.nullLocale == null) {
                // create it
                this.nullLocale = create(null);
            }
            // downgrade to read lock
            this.lock.readLock().lock();
        } finally {
            this.lock.writeLock().unlock();
        }

        try {
            return this.nullLocale;
        } finally {
            this.lock.readLock().unlock();
        }

    }

    @Override
    public T get(Locale language)
            throws ConfigurationError {
        if (language == null) {
            return get();
        } else {
            try {
                return this.cache.getUnchecked(language);
            } catch (UncheckedExecutionException ex) {
                if (ex.getCause() instanceof ConfigurationError) {
                    throw (ConfigurationError) ex.getCause();
                } else {
                    throw ex;
                }
            }
        }
    }

    protected abstract T create(Locale language)
            throws ConfigurationError;

}

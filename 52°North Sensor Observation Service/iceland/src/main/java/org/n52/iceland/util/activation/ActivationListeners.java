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
package org.n52.iceland.util.activation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public class ActivationListeners<K> implements ActivationManager<K> {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<K, Boolean> actives;
    private final List<ActivationListener<K>> listeners;
    private final boolean stateForMissingKey;

    public ActivationListeners(boolean stateForMissingKey) {
        this.listeners = new ArrayList<>();
        this.actives = Collections.synchronizedMap(new HashMap<K, Boolean>());
        this.stateForMissingKey = stateForMissingKey;
    }

    public Set<K> getKeys() {
        synchronized (this.actives) {
            // contructor iterates over actives...
            return new HashSet<>(this.actives.keySet());
        }
    }

    @Override
    public boolean isActive(K key) {
        Boolean active = this.actives.get(key);
        return active == null ? this.stateForMissingKey : active;
    }

    private boolean setState(K key, boolean value) {
        Boolean old = this.actives.put(key, value);
        return old == null ? this.stateForMissingKey != value : old != value;
    }

    @Override
    public void setActive(K key, boolean value) {
        if (value) {
            activate(key);
        } else {
            deactivate(key);
        }
    }

    @Override
    public void activate(K key) {
        if (setState(key, true)) {
            this.lock.readLock().lock();
            try {
                this.listeners.forEach(l -> l.activated(key));
            } finally {
                this.lock.readLock().unlock();
            }
        }
    }

    @Override
    public void deactivate(K key) {
        if (setState(key, false)) {
            this.lock.readLock().lock();
            try {
                this.listeners.forEach(l -> l.deactivated(key));
            } finally {
                this.lock.readLock().unlock();
            }
        }
    }

    @Override
    public void registerListener(ActivationListener<K> listener) {
        this.lock.writeLock().lock();
        try {
            this.listeners.add(listener);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @Override
    public void deregisterListener(ActivationListener<K> listener) {
        this.lock.writeLock().lock();
        try {
            this.listeners.remove(listener);
        } finally {
            this.lock.writeLock().unlock();
        }
    }
}

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
package org.n52.iceland.component;

import static java.util.stream.Collectors.toSet;

import java.util.Set;

/**
 * Interface for {@link Component} factories.
 *
 * @param <C> the component type
 * @param <K> the key type
 *
 * @since 1.0.0
 *
 * @author Christian Autermann
 */
public interface ComponentFactory<K, C extends Component<K>> extends Keyed<K> {

    /**
     * Checks if this factory supports the supplied {@code key}.
     *
     * @param key the key
     *
     * @return if this factory supports the key.
     */
    default boolean has(K key) {
        return getKeys().contains(key);
    }

    /**
     * Creates all {@link Component}s supported by this factory.
     *
     * @return the components
     */
    default Set<C> createAll() {
        return getKeys().stream()
                .map(this::create)
                .collect(toSet());
    }

    /**
     * Get all keys that are supported by this factory.
     *
     * @return the keys
     */
    @Override
    Set<K> getKeys();

    /**
     * Creates the {@link Component} associated with the supplied {@code key}.
     * Whether this method will always return the same instance or a fresh
     * instance for each call is implementation dependent.
     *
     * @param key the key
     *
     * @return the {@code Component}
     */
    C create(K key);
}

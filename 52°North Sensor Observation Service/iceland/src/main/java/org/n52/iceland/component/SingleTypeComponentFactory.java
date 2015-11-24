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

import java.util.Collections;
import java.util.Set;

/**
 * Convenience interface for a {@link ComponentFactory} that supports only a
 * single key.
 *
 * @param <K> the component key
 * @param <C> the component type
 *
 * @since 1.0.0
 *
 * @author Christian Autermann
 */
public interface SingleTypeComponentFactory<K, C extends Component<K>>
        extends ComponentFactory<K, C> {

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if {@code key} does not equal the
     *                                  {@linkplain #getKey() key of this factory}.
     */
    @Override
    default C create(K key) {
        if (!has(key)) {
            throw new IllegalArgumentException("Key " + key + " not supported");
        }
        return create();
    }

    /**
     * Creates a singleton set of the {@link Component} supported by this
     * factory.
     *
     * @return the component
     */
    @Override
    default Set<C> createAll() {
        return Collections.singleton(create());
    }

    /**
     * Creates a singleton set of the key supported by this factory.
     *
     * @return the key
     */
    @Override
    default Set<K> getKeys() {
        return Collections.singleton(getKey());
    }

    /**
     * Checks if the {@code key} is the key supported by this factory.
     *
     * @param key the key
     *
     * @return if the {@code key} is the key supported
     */
    @Override
    default boolean has(K key) {
        return key != null && key.equals(getKey());
    }

    /**
     * Gets the single key supported by this factory.
     *
     * @return the key
     */
    K getKey();

    /**
     * Creates the single {@link Component} supported by this factory. Whether
     * this method will always return the same instance or a fresh instance for
     * each call is implementation dependent.
     *
     * @return the component
     */
    C create();
}

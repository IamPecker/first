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

import java.util.Objects;

import com.google.common.base.MoreObjects;

/**
 * Generic {@link Component} key that is based on a single {@link Class}.
 *
 * @param <T> the type the class of this key has to be a subtype of
 *
 * @since 1.0.0
 *
 * @author Christian Autermann
 */
public class ClassBasedComponentKey<T> {

    private final Class<? extends T> type;

    /**
     * Creates a new key.
     *
     * @param type the type associated with this key
     */
    public ClassBasedComponentKey(Class<? extends T> type) {
        this.type = type;
    }

    /**
     * Gets the type associated with this key.
     *
     * @return the type
     */
    public Class<? extends T> getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        ClassBasedComponentKey<?> that = (ClassBasedComponentKey<?>) other;
        return Objects.equals(this.getType(), that.getType());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", getType())
                .toString();
    }

}

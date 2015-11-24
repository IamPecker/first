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
package org.n52.iceland.coding.decode;

import com.google.common.base.Objects;

/**
 * Abstract {@link DecoderKey} class for namespace decoder
 * 
 * @author Christian Autermann <c.autermann@52north.org>
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * 
 * @since 1.0.0
 */
public abstract class NamespaceDecoderKey<T> implements DecoderKey {
    private final String namespace;

    public NamespaceDecoderKey(String namespace, T type) {
        this.namespace = namespace;
        setType(type);
    }

    /**
     * Set the tpye
     * 
     * @param type
     */
    protected abstract void setType(T type);

    /**
     * Get the type
     * 
     * @return the type
     */
    public abstract T getType();

    /**
     * Get {@link String} representation of the type.
     * 
     * @return {@link String} representation of the type.
     */
    protected abstract String getTypeName();

    /**
     * Check for similarity
     * 
     * @param key
     *            {@link DecoderKey} to check
     * @param type
     *            Type to check
     * @return 0 for equality, -1 for non equality
     */
    protected abstract int getSimilarity(DecoderKey key, T type);

    public String getNamespace() {
        return namespace;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(3, 79, getNamespace(), getType());
    }

    @Override
    public String toString() {
        return String.format("%s[namespace=%s, type=%s]", getTypeName(), getNamespace(), getTypeName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            final NamespaceDecoderKey<?> o = (NamespaceDecoderKey<?>) obj;
            return Objects.equal(getType(), o.getType()) && Objects.equal(getNamespace(), o.getNamespace());
        }
        return false;
    }
}

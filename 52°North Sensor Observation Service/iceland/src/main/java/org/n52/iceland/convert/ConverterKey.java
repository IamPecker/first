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
package org.n52.iceland.convert;

import java.util.Comparator;
import java.util.Objects;

/**
 * Key class for {@link Converter}
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public class ConverterKey implements Comparable<ConverterKey> {
    private static final Comparator<ConverterKey> COMPARATOR
            = Comparator.nullsFirst(Comparator.comparing(ConverterKey::getFromNamespace, Comparator.nullsFirst(String::compareTo))
                            .thenComparing(Comparator.comparing(ConverterKey::getToNamespace, Comparator.nullsFirst(String::compareTo))));

    private final String fromNamespace;
    private final String toNamespace;

    /**
     * Constructor
     *
     * @param fromNamespace
     *            The source namespace
     * @param toNamespace
     *            The target namespace
     */
    public ConverterKey(String fromNamespace, String toNamespace) {
        this.fromNamespace = fromNamespace;
        this.toNamespace = toNamespace;
    }

    /**
     * @return the source namespace
     */
    public String getFromNamespace() {
        return fromNamespace;
    }

    /**
     * @return the target namespace
     */
    public String getToNamespace() {
        return toNamespace;
    }

    @Override
    public int compareTo(ConverterKey o) {
        return compare(this, o);
    }

    @Override
    public boolean equals(Object paramObject) {
        if (paramObject instanceof ConverterKey) {
            ConverterKey toCheck = (ConverterKey) paramObject;
            return Objects.equals(getFromNamespace(), toCheck.getFromNamespace()) &&
                   Objects.equals(getToNamespace(), toCheck.getToNamespace());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFromNamespace(), getToNamespace());
    }

    @Override
    public String toString() {
        return String.format("%s[from=%s, to=%s]", getClass().getSimpleName(), fromNamespace, toNamespace);
    }

    public static int compare(ConverterKey o1, ConverterKey o2) {
        return COMPARATOR.compare(o1, o2);
    }

}

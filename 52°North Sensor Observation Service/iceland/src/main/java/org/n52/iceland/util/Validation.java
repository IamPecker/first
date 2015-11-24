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

import org.n52.iceland.exception.ConfigurationError;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 * @since 4.0.0
 *
 */
public final class Validation {

    private  Validation() {
    }

    public static <T> T notNull(String name, T val) throws ConfigurationError {
        if (val == null) {
            throw new ConfigurationError(String.format("%s can not be null!", name));
        }
        return val;
    }

    public static int greaterZero(String name, int i) throws ConfigurationError {
        if (i <= 0) {
            throw new ConfigurationError(String.format("%s can not be smaller or equal zero (was %d)!", name, i));
        }
        return i;
    }

    public static int greaterEqualZero(String name, int i) throws ConfigurationError {
        if (i < 0) {
            throw new ConfigurationError(String.format("%s can not be smaller than zero (was %d)!", name, i));
        }
        return i;
    }

    public static String notNullOrEmpty(String name, String val) throws ConfigurationError {
        notNull(name, val);
        if (val.isEmpty()) {
            throw new ConfigurationError(String.format("%s can not be empty!", name));
        }
        return val;
    }
}

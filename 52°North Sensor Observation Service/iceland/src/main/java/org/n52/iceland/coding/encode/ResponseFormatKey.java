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
package org.n52.iceland.coding.encode;

import org.n52.iceland.service.operator.ServiceOperatorKey;

import com.google.common.base.Objects;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 4.0.0
 */
public class ResponseFormatKey {
    private ServiceOperatorKey serviceOperatorKey;

    private String responseFormat;

    public ResponseFormatKey(ServiceOperatorKey serviceOperatorKey, String responseFormat) {
        this.serviceOperatorKey = serviceOperatorKey;
        this.responseFormat = responseFormat;
    }

    public ResponseFormatKey() {
        this(null, null);
    }

    @Deprecated
    public ServiceOperatorKey getServiceOperatorKeyType() {
        return getServiceOperatorKey();
    }

    @Deprecated
    public void setServiceOperatorKeyType(ServiceOperatorKey serviceOperatorKeyType) {
        setServiceOperatorKey(serviceOperatorKeyType);
    }

    public ServiceOperatorKey getServiceOperatorKey() {
        return this.serviceOperatorKey;
    }

    public void setServiceOperatorKey(ServiceOperatorKey serviceOperatorKey) {
        this.serviceOperatorKey = serviceOperatorKey;
    }

    public String getResponseFormat() {
        return responseFormat;
    }

    public void setResponseFormat(String responseFormat) {
        this.responseFormat = responseFormat;
    }

    public String getService() {
        return getServiceOperatorKey() != null ? getServiceOperatorKey().getService() : null;
    }

    public String getVersion() {
        return getServiceOperatorKey() != null ? getServiceOperatorKey().getVersion() : null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getServiceOperatorKey(), getResponseFormat());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ResponseFormatKey) {
            ResponseFormatKey o = (ResponseFormatKey) obj;
            return Objects.equal(getServiceOperatorKey(), o.getServiceOperatorKey())
                    && Objects.equal(getResponseFormat(), o.getResponseFormat());
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s[serviceOperatorKeyType=%s, responseFormat=%s]", getClass().getSimpleName(),
                getServiceOperatorKey(), getResponseFormat());
    }
}

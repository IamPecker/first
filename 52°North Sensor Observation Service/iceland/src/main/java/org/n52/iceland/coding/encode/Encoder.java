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

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.n52.iceland.component.Component;
import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.exception.ows.concrete.UnsupportedEncoderInputException;
import org.n52.iceland.ogc.ows.OWSConstants.HelperValues;
import org.n52.iceland.service.ConformanceClass;
import org.n52.iceland.service.ServiceConstants.SupportedType;
import org.n52.iceland.util.http.MediaType;
import org.n52.iceland.w3c.SchemaLocation;

/**
 * Generic interface for Encoders.
 *
 * @param <T>
 *            the resulting type, the "Target"
 * @param <S>
 *            the input type, the "Source"
 *
 * @since 4.0.0
 */
public interface Encoder<T, S> extends ConformanceClass, Component<EncoderKey> {

    /**
     * Encodes the specified object.
     *
     * @param objectToEncode
     *            the object to encode
     *
     * @return the encoded object
     *
     * @throws OwsExceptionReport
     *             if an error occurs
     * @throws UnsupportedEncoderInputException
     *             if the supplied object (or any of it's contents) is not
     *             supported by this encoder
     */
    T encode(S objectToEncode) throws OwsExceptionReport, UnsupportedEncoderInputException;

    /**
     * Encodes the specified object with the specified {@linkplain HelperValues}
     * .
     *
     * @param objectToEncode
     *            the object to encode
     * @param additionalValues
     *            the helper values
     *
     * @return the encoded object
     *
     * @throws OwsExceptionReport
     *             if an error occurs
     * @throws UnsupportedEncoderInputException
     *             if the supplied object (or any of it's contents) is not
     *             supported by this encoder
     */
    T encode(S objectToEncode, Map<HelperValues, String> additionalValues) throws OwsExceptionReport,
            UnsupportedEncoderInputException;

    /**
     * Get the {@link SupportedType}
     *
     * @return the supported key types
     */
    default Set<SupportedType> getSupportedTypes() {
        return Collections.emptySet();
    }

    /**
     * Add the namespace prefix of this {@linkplain Encoder} instance to the
     * given {@linkplain Map}.
     *
     * @param nameSpacePrefixMap
     */
    default void addNamespacePrefixToMap(Map<String, String> nameSpacePrefixMap) {
        // do nothing
    }

    /**
     * @return the content type of the encoded response.
     */
    MediaType getContentType();

    default Set<SchemaLocation> getSchemaLocations() {
        return Collections.emptySet();
    }
}

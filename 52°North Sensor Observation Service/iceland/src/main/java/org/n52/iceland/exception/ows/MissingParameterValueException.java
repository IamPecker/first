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
package org.n52.iceland.exception.ows;

import static org.n52.iceland.util.http.HTTPStatus.BAD_REQUEST;

/**
 * Implementation of {@link CodedOwsException} to be used if </br> <i>Operation
 * request does not include a parameter value, and this server did not declare a
 * default value for that parameter.</i>
 *
 * @see <a href="http://portal.opengeospatial.org/files/?artifact_id=20040">OGC
 *      Web Service Common Specification 1.1.0, Table 25 — Standard exception codes and
 *      meanings</a>
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 1.0.0
 */
public class MissingParameterValueException extends CodedOwsException {
    private static final long serialVersionUID = 236478803986562631L;

    public MissingParameterValueException(final String parameter) {
        super(OwsExceptionCode.MissingParameterValue);
        at(parameter).withMessage("The value for the parameter '%s' is missing in the request!", parameter);
        setStatus(BAD_REQUEST);
    }

    public MissingParameterValueException(final Enum<?> parameter) {
        this(parameter.name());
    }
}

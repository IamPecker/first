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
package org.n52.iceland.ds;

import org.n52.iceland.component.Component;
import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.ogc.ows.OwsOperation;
import org.n52.iceland.service.ConformanceClass;

/**
 * Interface for all operation Handlers.
 *
 * In 52N SOS version 4.x called OperationDAO
 *
 * @since 1.0.0
 */
public interface OperationHandler extends ConformanceClass, Component<OperationHandlerKey> {

    /**
     * TODO check if necessary in feature
     *
     * Get the operation name this Handler supports
     *
     * @return The supported operation name
     */
    String getOperationName();

    /**
     * Get the OperationsMetadata of the supported SOS operation for the
     * capabilities
     *
     * @param service
     *            OGC service identifier
     * @param version
     *            Service version
     * @return OperationsMetadata for the operation
     *
     * @throws OwsExceptionReport
     *             If an error occurs.
     */
    OwsOperation getOperationsMetadata(String service, String version) throws OwsExceptionReport;

    // /**
    // * @return the operation specific extension information (&larr; should be
    // available from cache or from code)
    // *
    // * @throws OwsExceptionReport
    // */
    // // SosCapabilitiesExtension getExtension() throws OwsExceptionReport;

}

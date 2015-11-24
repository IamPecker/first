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
package org.n52.iceland.service;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 4.0.0
 */
public interface ServiceSettings {

    String SERVICE_URL = "service.sosUrl";

    @Deprecated
    //  String SUPPORTS_QUALITY = "service.supportsQuality";
    String SENSOR_DIRECTORY = "service.sensorDirectory";

    @Deprecated
    String USE_DEFAULT_PREFIXES = "service.useDefaultPrefixes";

    @Deprecated
    String ENCODE_FULL_CHILDREN_IN_DESCRIBE_SENSOR
            = "service.encodeFullChildrenInDescribeSensor";

    @Deprecated
    String MAX_GET_OBSERVATION_RESULTS = "service.maxGetObservationResults";

    @Deprecated
    String DEREGISTER_JDBC_DRIVER = "service.jdbc.deregister";

    @Deprecated
    String ADD_OUTPUTS_TO_SENSOR_ML = "service.addOutputsToSensorML";

    @Deprecated
    String STRICT_SPATIAL_FILTERING_PROFILE
            = "service.strictSpatialFilteringProfile";

    String VALIDATE_RESPONSE = "service.response.validate";

}

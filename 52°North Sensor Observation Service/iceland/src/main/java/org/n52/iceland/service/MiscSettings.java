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
 * TODO JavaDoc
 *
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 4.0.0
 */
public interface MiscSettings {
    String TOKEN_SEPARATOR = "misc.tokenSeparator";

    String TUPLE_SEPARATOR = "misc.tupleSeparator";

    String DECIMAL_SEPARATOR = "misc.decimalSeparator";

    String CHARACTER_ENCODING = "misc.characterEncoding";

    String SRS_NAME_PREFIX_SOS_V1 = "misc.srsNamePrefixSosV1";

    String SRS_NAME_PREFIX_SOS_V2 = "misc.srsNamePrefixSosV2";

    String DEFAULT_OFFERING_PREFIX = "misc.defaultOfferingPrefix";

    String DEFAULT_PROCEDURE_PREFIX = "misc.defaultProcedurePrefix";

    String DEFAULT_OBSERVABLEPROPERTY_PREFIX
            = "misc.defaultObservablePropertyPrefix";

    String DEFAULT_FEATURE_PREFIX = "misc.defaultFeaturePrefix";

    String HTTP_STATUS_CODE_USE_IN_KVP_POX_BINDING
            = "misc.httpResponseCodeUseInKvpAndPoxBinding";

    String RELATED_SAMPLING_FEATURE_ROLE_FOR_CHILD_FEATURES
            = "misc.relatedSamplingFeatureRoleForChildFeatures";

    String HYDRO_MAX_NUMBER_OF_RETURNED_VALUES
            = "profile.hydrology.maxReturnedValue";

    String HYDRO_MAX_NUMBER_OF_RETURNED_TIME_SERIES
            = "profile.hydrology.maxReturnedTimeSeries";

    String RETURN_OVERALL_EXTREMA_FOR_FIRST_LATEST
            = "profile.hydrology.overallExtrema";

}

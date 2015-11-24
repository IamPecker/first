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
package org.n52.iceland.converter;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import org.n52.iceland.convert.RequestResponseModifierKey;
import org.n52.iceland.request.AbstractServiceRequest;
import org.n52.iceland.request.TestRequest;
import org.n52.iceland.response.AbstractServiceResponse;
import org.n52.iceland.response.TestResponse;

public class RequestResponseModifierKeyTypeTest {
    private static final String service = "SOS";
    private static final String version = "2.0.0";
    private final AbstractServiceRequest<?> request = new TestRequest();
    private final AbstractServiceResponse response = new TestResponse();

    @Rule
    public final ErrorCollector errors = new ErrorCollector();

    @Test
    public void testHashCode() {
        errors.checkThat(new RequestResponseModifierKey(service, version, request).hashCode(), is(equalTo(new RequestResponseModifierKey(service, version, request).hashCode())));
        errors.checkThat(new RequestResponseModifierKey(service, version, request, response).hashCode(), is(equalTo(new RequestResponseModifierKey(service, version, request, response).hashCode())));
        errors.checkThat(new RequestResponseModifierKey(service, version, request).hashCode(), is(equalTo(new RequestResponseModifierKey(service, version, getModifiedRequest()).hashCode())));
        errors.checkThat(new RequestResponseModifierKey(service, version, request, response).hashCode(), is(equalTo(new RequestResponseModifierKey(service, version, getModifiedRequest(), getModifiedResponse()).hashCode())));

    }

    @Test
    @Ignore("sounds like this would offend the equals contract...")
    public void testEquals() {
        errors.checkThat(new RequestResponseModifierKey(service, version, request), is(equalTo(new RequestResponseModifierKey(service, version, request))));
        errors.checkThat(new RequestResponseModifierKey(service, version, request, response), is(equalTo(new RequestResponseModifierKey(service, version, request, response))));
        // for production
        errors.checkThat(new RequestResponseModifierKey(service, version, request, response), is(equalTo(new RequestResponseModifierKey(service, version, request))));
        errors.checkThat(new RequestResponseModifierKey(service, version, request, response), is(equalTo(new RequestResponseModifierKey(service, version, request, response))));
    }

    private AbstractServiceRequest<?> getModifiedRequest() {
        TestRequest request = new TestRequest();
        request.setService(service).setVersion(version);
        return request;
    }

    private AbstractServiceResponse getModifiedResponse() {
        TestResponse response = new TestResponse();
        response.setService(service).setVersion(version);
        return response;
    }

}

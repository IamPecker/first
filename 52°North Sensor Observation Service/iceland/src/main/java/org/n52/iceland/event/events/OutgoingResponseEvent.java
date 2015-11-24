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
package org.n52.iceland.event.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.n52.iceland.event.ServiceEvent;

import com.google.common.base.MoreObjects;

/**
 * Event is thrown if a {@link HttpServletResponse} was sent back.
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public class OutgoingResponseEvent implements ServiceEvent {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final long requestNumber;
    private final long elapsedTime;

    public OutgoingResponseEvent(HttpServletRequest request,
                                 HttpServletResponse response,
                                 long requestNumber,
                                 long elapsedTime) {
        this.request = request;
        this.response = response;
        this.requestNumber = requestNumber;
        this.elapsedTime = elapsedTime;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public long getRequestNumber() {
        return requestNumber;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    @Override
    public String toString() {
        return MoreObjects
                .toStringHelper(this)
                .add("request", this.request)
                .add("response", this.response)
                .add("requestNumber", this.requestNumber)
                .add("elapsedTime", this.elapsedTime)
                .toString();
    }

}

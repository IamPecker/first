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
import java.util.Optional;

import org.n52.iceland.request.AbstractServiceRequest;
import org.n52.iceland.response.AbstractServiceResponse;
import org.n52.iceland.util.Comparables;
import org.n52.iceland.util.Constants;
import org.n52.iceland.util.StringHelper;


/**
 * Key class to identify {@link RequestResponseModifier}
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public class RequestResponseModifierKey implements Comparable<RequestResponseModifierKey> {
    private final String service;
    private final String version;
    private Optional<Class<? extends AbstractServiceRequest>> request;
    private Optional<Class<? extends AbstractServiceResponse>> response;

    /**
     * Creates a new {@code RequestResponseModifierKey}.
     *
     * @param service The service name
     * @param version The service version
     * @param request The {@link AbstractServiceRequest}
     */
    public RequestResponseModifierKey(String service, String version,
                                      AbstractServiceRequest<?> request) {
        this(service, version, request, null);
    }

    /**
     * Creates a new {@code RequestResponseModifierKey}.
     *
     * @param service  The service name
     * @param version  The service version
     * @param request  The {@link AbstractServiceRequest}
     * @param response The {@link AbstractServiceResponse}
     */
    public RequestResponseModifierKey(String service, String version,
                                      AbstractServiceRequest<?> request,
                                      AbstractServiceResponse response) {
        this(service, version, getClass(request), getClass(response));
    }

    /**
     * Creates a new {@code RequestResponseModifierKey}.
     *
     * @param service The service name
     * @param version The service version
     * @param request The {@link AbstractServiceRequest}
     */
    public RequestResponseModifierKey(String service, String version,
                                      Class<? extends AbstractServiceRequest<?>> request) {
        this(service, version, request, null);
    }

    /**
     * Creates a new {@code RequestResponseModifierKey}.
     *
     * @param service  The service name
     * @param version  The service version
     * @param request  The {@link AbstractServiceRequest}
     * @param response The {@link AbstractServiceResponse}
     */
    public RequestResponseModifierKey(String service, String version,
                                      Class<? extends AbstractServiceRequest<?>> request,
                                      Class<? extends AbstractServiceResponse> response) {
        this(service, version, Optional.ofNullable(request), Optional
             .ofNullable(response));
    }

    /**
     * Creates a new {@code RequestResponseModifierKey}.
     *
     * @param service  The service name
     * @param version  The service version
     * @param request  The {@link AbstractServiceRequest}
     * @param response The {@link AbstractServiceResponse}
     */
    public RequestResponseModifierKey(String service, String version,
                                      Optional<Class<? extends AbstractServiceRequest>> request,
                                      Optional<Class<? extends AbstractServiceResponse>> response) {
        this.service = Optional.ofNullable(service)
                .orElse(Constants.EMPTY_STRING);
        this.version = Optional.ofNullable(version)
                .orElse(Constants.EMPTY_STRING);
        this.request = Objects.requireNonNull(request);
        this.response = Objects.requireNonNull(response);
    }

    /**
     * @return the service
     */
    public String getService() {
        return this.service;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return this.version;
    }

    public boolean isSetService() {
        return StringHelper.isNotEmpty(getService());
    }

    public boolean isSetVersion() {
        return StringHelper.isNotEmpty(getVersion());
    }

    /**
     * @return the request
     */
    public Class<? extends AbstractServiceRequest> getRequest() {
        return this.request.orElse(null);
    }

    public boolean isSetRequest() {
        return this.request.isPresent();
    }

    /**
     * @return the response
     */
    public Class<? extends AbstractServiceResponse> getResponse() {
        return this.response.orElse(null);
    }

    public boolean isSetResponse() {
        return this.response.isPresent();
    }

    @Override
    public String toString() {
        return String.format("%s[service=%s, service=%s, request=%s, response=%s]", getClass().getSimpleName(),
                getService(), getVersion(), isSetRequest() ? getRequest().getClass().getSimpleName()
                        : Constants.EMPTY_STRING, isSetResponse() ? getResponse().getClass().getSimpleName()
                        : Constants.EMPTY_STRING);
    }

    @Override
    public int compareTo(RequestResponseModifierKey o) {
        Comparator<String> stringComparator = Comparables.allowNull(String::compareTo);
        Comparator<Class<?>> classComparator = Comparables.allowNull((a,b) -> {
            return a == b ? 0 : a.getName().compareTo(b.getName());
        });
        return Comparator
                .comparing(RequestResponseModifierKey::getService, stringComparator)
                .thenComparing(RequestResponseModifierKey::getVersion, stringComparator)
                .thenComparing(RequestResponseModifierKey::getRequest, classComparator)
                .thenComparing(RequestResponseModifierKey::getResponse, classComparator)
                .compare(this, o);
    }


    @Override
    public boolean equals(Object o) {
        if (o != null && o.getClass() == getClass()) {
            RequestResponseModifierKey other = (RequestResponseModifierKey) o;
            return Objects.equals(getService(), other.getService()) &&
                   Objects.equals(getVersion(), other.getVersion()) &&
                   Objects.equals(getRequest(), other.getRequest()) &&
                   Objects.equals(getResponse(), other.getResponse());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = Objects.hash(getService(), getVersion(), getRequest().getClass());
        if (isSetResponse()) {
            return Objects.hash(hashCode, getResponse().getClass());
        }
        return hashCode;
    }


    @SuppressWarnings("unchecked")
    private static <T> Optional<Class<? extends T>> getClass(T t) {
        return Optional.ofNullable(t).map(x -> {
            return (Class<? extends T>) x.getClass();
        });
    }

}

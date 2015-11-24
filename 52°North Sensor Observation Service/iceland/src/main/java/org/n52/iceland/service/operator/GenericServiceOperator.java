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
package org.n52.iceland.service.operator;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import javax.inject.Inject;

import org.n52.iceland.exception.ows.OperationNotSupportedException;
import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.request.AbstractServiceRequest;
import org.n52.iceland.request.operator.RequestOperator;
import org.n52.iceland.request.operator.RequestOperatorRepository;
import org.n52.iceland.response.AbstractServiceResponse;

import com.google.common.base.MoreObjects;

/**
 * Generic service operator implementation that just delegates to a matching
 * {@link RequestOperator}.
 *
 * @since 1.0.0
 *
 * @author Christian Autermann
 */
public class GenericServiceOperator implements ServiceOperator, Constructable {
    private RequestOperatorRepository requestOperatorRepository;
    private ServiceOperatorKey key;
    private String service;
    private String version;

    /**
     * Sets the version of this OWS Service.
     *
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Sets the name of this OWS service.
     *
     * @param service
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * Gets the {@code ServiceOperatorKey} for this service.
     *
     * @return the key
     */
    public ServiceOperatorKey getKey() {
        return this.key;
    }

    /**
     * Sets the {@code RequestOperatorRepository} to get matching
     * {@link RequestOperator}s.
     *
     * @param repo the repository
     */
    @Inject
    public void setRequestOperatorRepository(RequestOperatorRepository repo) {
        this.requestOperatorRepository = repo;
    }

    @Override
    public void init() {
        this.key = new ServiceOperatorKey(Objects.requireNonNull(this.service),
                                          Objects.requireNonNull(this.version));
    }

    @Override
    public Set<ServiceOperatorKey> getKeys() {
        return Collections.singleton(this.key);
    }

    /**
     * {@inheritDoc}
     *
     * @throws OperationNotSupportedException if no matching
     *                                        {@link RequestOperator} could be
     *                                        found or if the operator returned
     *                                        a {@code null}-response.
     */
    @Override
    public AbstractServiceResponse receiveRequest(
            AbstractServiceRequest<?> request)
            throws OwsExceptionReport {
        String operationName = request.getOperationName();
        RequestOperator operator = this.requestOperatorRepository
                .getRequestOperator(this.key, operationName);

        if (operator == null) {
            throw new OperationNotSupportedException(operationName);
        }

        AbstractServiceResponse response = operator.receiveRequest(request);

        if (response == null) {
            throw new OperationNotSupportedException(operationName);
        }

        return response;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GenericServiceOperator)) {
            return false;
        }
        GenericServiceOperator that = (GenericServiceOperator) obj;
        return Objects.equals(this.getKey(), that.getKey());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("service", this.service)
                .add("version", this.version)
                .toString();
    }

}

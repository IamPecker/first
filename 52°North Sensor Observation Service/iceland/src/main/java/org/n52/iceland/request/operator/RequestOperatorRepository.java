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
package org.n52.iceland.request.operator;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.service.operator.ServiceOperatorKey;
import org.n52.iceland.util.Producer;
import org.n52.iceland.util.activation.Activatables;
import org.n52.iceland.util.activation.ActivationListener;
import org.n52.iceland.util.activation.ActivationListeners;
import org.n52.iceland.util.activation.ActivationManager;
import org.n52.iceland.util.activation.ActivationSource;

import com.google.common.collect.Maps;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 4.0.0
 */
public class RequestOperatorRepository extends AbstractComponentRepository<RequestOperatorKey, RequestOperator, RequestOperatorFactory>
        implements ActivationManager<RequestOperatorKey>,
                   ActivationSource<RequestOperatorKey>,
                   Constructable {
    @Deprecated
    private static RequestOperatorRepository instance;

    private final Map<RequestOperatorKey, Producer<RequestOperator>> requestOperators = Maps.newHashMap();

    private final ActivationListeners<RequestOperatorKey> activation = new ActivationListeners<>(true);

    @Autowired(required = false)
    private Collection<RequestOperator> components;
    @Autowired(required = false)
    private Collection<RequestOperatorFactory> componentFactories;

    @Override
    public void init() {
        RequestOperatorRepository.instance = this;
        Map<RequestOperatorKey, Producer<RequestOperator>> implementations
                = getUniqueProviders(this.components, this.componentFactories);
        this.requestOperators.clear();
        this.requestOperators.putAll(implementations);
    }

    public RequestOperator getRequestOperator(RequestOperatorKey key) {
        if (isActive(key)) {
            Producer<RequestOperator> producer = this.requestOperators.get(key);
            return producer == null ? null : producer.get();
        } else {
            return null;
        }
    }

    public RequestOperator getRequestOperator(ServiceOperatorKey sok, String operationName) {
        return getRequestOperator(new RequestOperatorKey(sok, operationName));
    }

    @Override
    public void setActive(RequestOperatorKey rokt, boolean active) {
        this.activation.setActive(rokt, active);
    }

    public Set<RequestOperatorKey> getActiveRequestOperatorKeys() {
        return Activatables.activatedKeys(this.requestOperators, this.activation);
    }

    @Deprecated
    public Set<RequestOperatorKey> getAllRequestOperatorKeys() {
        return getKeys();
    }

    @Override
    public boolean isActive(RequestOperatorKey rok) {
        return this.activation.isActive(rok);
    }

    @Override
    public void registerListener(ActivationListener<RequestOperatorKey> listener) {
        this.activation.registerListener(listener);
    }

    @Override
    public void deregisterListener(ActivationListener<RequestOperatorKey> listener) {
        this.activation.deregisterListener(listener);
    }

    @Override
    public void activate(RequestOperatorKey key) {
        this.activation.activate(key);
    }

    @Override
    public void deactivate(RequestOperatorKey key) {
        this.activation.deactivate(key);
    }

    @Override
    public Set<RequestOperatorKey> getKeys() {
        return Collections.unmodifiableSet(this.requestOperators.keySet());
    }

    @Deprecated
    public static RequestOperatorRepository getInstance() {
        return RequestOperatorRepository.instance;
    }
}

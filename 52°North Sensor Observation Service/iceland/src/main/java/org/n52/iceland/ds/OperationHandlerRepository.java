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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.util.Producer;
import org.n52.iceland.util.Producers;


/**
 * In 52N SOS version 4.x called OperationDAORepository
 *
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 1.0.0
 */
public class OperationHandlerRepository extends AbstractComponentRepository<OperationHandlerKey, OperationHandler, OperationHandlerFactory> implements Constructable {
    @Deprecated
    private static OperationHandlerRepository instance;
    private final Map<OperationHandlerKey, Producer<OperationHandler>> operationHandlers = new HashMap<>();
    private Collection<OperationHandler> components;
    private Collection<OperationHandlerFactory> componentFactories;

    @Autowired(required = false)
    public void setComponents(Collection<OperationHandler> components) {
        this.components = components;
    }

    @Autowired(required = false)
    public void setComponentFactories(Collection<OperationHandlerFactory> componentFactories) {
        this.componentFactories = componentFactories;
    }

    @Override
    public void init() {
        OperationHandlerRepository.instance = this;
        Map<OperationHandlerKey, Producer<OperationHandler>> implementations
                = getUniqueProviders(this.components, this.componentFactories);
        this.operationHandlers.clear();
        this.operationHandlers.putAll(implementations);
    }

    public Map<OperationHandlerKey, OperationHandler> getOperationHandlers() {
        return Producers.produce(this.operationHandlers);
    }

    public OperationHandler getOperationHandler(String service, String operationName) {
        return getOperationHandler(new OperationHandlerKey(service, operationName));
    }

    public OperationHandler getOperationHandler(OperationHandlerKey key) {
        return Producers.produce(operationHandlers.get(key));
    }

    @Deprecated
    public OperationHandler getOperationDAO(OperationHandlerKey key) {
        return getOperationHandler(key);
    }

    @Deprecated
    public Map<OperationHandlerKey, OperationHandler> getOperationDAOs() {
        return getOperationHandlers();
    }

    @Deprecated
    public OperationHandler getOperationDAO(String service, String operationName) {
        return getOperationHandler(service, operationName);
    }

    @Deprecated
    public static OperationHandlerRepository getInstance() {
        return OperationHandlerRepository.instance;
    }
}

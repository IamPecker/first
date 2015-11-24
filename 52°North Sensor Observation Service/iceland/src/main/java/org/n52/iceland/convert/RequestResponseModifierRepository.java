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

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.request.AbstractServiceRequest;
import org.n52.iceland.response.AbstractServiceResponse;
import org.n52.iceland.util.Producer;
import org.n52.iceland.util.Producers;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.SetMultimap;

@SuppressWarnings("rawtypes")
public class RequestResponseModifierRepository extends
		      AbstractComponentRepository<RequestResponseModifierKey, RequestResponseModifier, RequestResponseModifierFactory> implements Constructable {

    @Deprecated
	private static RequestResponseModifierRepository instance;

	private final ListMultimap<RequestResponseModifierKey, Producer<RequestResponseModifier>> requestResponseModifier
            = LinkedListMultimap.create();

    @Autowired(required = false)
    private Collection<RequestResponseModifier> components;

    @Autowired(required = false)
    private Collection<RequestResponseModifierFactory> componentFactories;

    @Override
    public void init() {
        RequestResponseModifierRepository.instance = this;
        SetMultimap<RequestResponseModifierKey, Producer<RequestResponseModifier>> implementations
                = getProviders(this.components, this.componentFactories);
        this.requestResponseModifier.clear();
        for (RequestResponseModifierKey key : implementations.keySet()) {
            requestResponseModifier.putAll(key, implementations.get(key));
        }
    }

    public List<RequestResponseModifier> getRequestResponseModifier(AbstractServiceRequest request) {
        RequestResponseModifierKey key = new RequestResponseModifierKey(request.getService(), request.getVersion(), request);
        return getRequestResponseModifier(key);
    }

    public List<RequestResponseModifier> getRequestResponseModifier(AbstractServiceRequest request, AbstractServiceResponse response) {
        RequestResponseModifierKey key = new RequestResponseModifierKey(response.getService(), response.getVersion(), request, response);
        return getRequestResponseModifier(key);
	}

    public List<RequestResponseModifier> getRequestResponseModifier(RequestResponseModifierKey key) {
        List<Producer<RequestResponseModifier>> producers
                = this.requestResponseModifier.get(key);
        if (producers == null) {
            return null;
        } else {
            return Producers.produce(producers);
        }
	}

    public  boolean hasRequestResponseModifier(AbstractServiceRequest request) {
        return hasRequestResponseModifier(new RequestResponseModifierKey(
                request.getService(), request.getVersion(), request));
    }

    public boolean hasRequestResponseModifier(AbstractServiceRequest request, AbstractServiceResponse response) {
        return hasRequestResponseModifier(new RequestResponseModifierKey(
                request.getService(), request.getVersion(), request, response))
               && hasRequestResponseModifier(new RequestResponseModifierKey(
                       response.getService(), response.getVersion(), request,
						response));
	}

	public boolean hasRequestResponseModifier(RequestResponseModifierKey key) {
		return requestResponseModifier.containsKey(key);
	}

    @Deprecated
	public static RequestResponseModifierRepository getInstance() {
		return RequestResponseModifierRepository.instance;
	}

}

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
package org.n52.iceland.ogc.sos;

import static org.n52.iceland.util.Producers.produce;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.request.operator.RequestOperatorKey;
import org.n52.iceland.request.operator.RequestOperatorRepository;
import org.n52.iceland.util.Producer;
import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.lifecycle.Constructable;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;

/**
 * Repository for {@link CapabilitiesExtension} implementations
 *
 * @since 4.0.0
 *
 */
public class CapabilitiesExtensionRepository extends
        AbstractComponentRepository<CapabilitiesExtensionKey, CapabilitiesExtensionProvider, CapabilitiesExtensionProviderFactory> implements Constructable{
    @Deprecated
    private static CapabilitiesExtensionRepository instance;
    @Inject
    private RequestOperatorRepository requestOperatorRepository;

    /**
     * Implemented {@link CapabilitiesExtensionProvider}
     */
    private final ListMultimap<CapabilitiesExtensionKey, Producer<CapabilitiesExtensionProvider>> providers
            = LinkedListMultimap.create();

    @Autowired(required = false)
    private Collection<CapabilitiesExtensionProvider> components;
    @Autowired(required = false)
    private Collection<CapabilitiesExtensionProviderFactory> componentFactories;

    @Override
    public void init() {
        CapabilitiesExtensionRepository.instance = this;

        SetMultimap<CapabilitiesExtensionKey, Producer<CapabilitiesExtensionProvider>> implementations
                = getProviders(this.components, this.componentFactories);
        this.providers.clear();
        for (Entry<CapabilitiesExtensionKey, Producer<CapabilitiesExtensionProvider>> entry: implementations.entries()) {
            CapabilitiesExtensionKey key = entry.getKey();
            Producer<CapabilitiesExtensionProvider> value = entry.getValue();
            CapabilitiesExtensionProvider provider = value.get();
            if (!provider.hasRelatedOperation() ||
                checkIfRelatedOperationIsActivated(key, provider
                                                   .getRelatedOperation())) {
                this.providers.put(key, value);
            }
        }
    }

    public List<CapabilitiesExtensionProvider> getCapabilitiesExtensionProvider(CapabilitiesExtensionKey key) throws OwsExceptionReport {
        return getAllValidCapabilitiesExtensionProvider(key, providers.get(key));
    }

    /**
     * Get the implemented {@link CapabilitiesExtensionProvider} for service and
     * version
     *
     * @param service
     *                Specific service
     * @param version
     *                Specific version
     *
     * @return the implemented Capabilities extension provider
     *
     * @throws OwsExceptionReport
     */
    public List<CapabilitiesExtensionProvider> getCapabilitiesExtensionProvider(
            String service, String version)
            throws OwsExceptionReport {
        return getCapabilitiesExtensionProvider(new CapabilitiesExtensionKey(service, version));
    }

    /**
     * Get all valid {@link CapabilitiesExtensionProvider}
     *
     * @param key  the key
     * @param list
     *             Loaded CapabilitiesExtensionProvider
     *
     * @return Valid CapabilitiesExtensionProvider
     */
    private List<CapabilitiesExtensionProvider> getAllValidCapabilitiesExtensionProvider(
            CapabilitiesExtensionKey key, List<Producer<CapabilitiesExtensionProvider>> list) {
        List<CapabilitiesExtensionProvider> activated = Lists.newLinkedList();
        for (CapabilitiesExtensionProvider provider : produce(list)) {
            if (!provider.hasRelatedOperation() ||
                checkIfRelatedOperationIsActivated(key, provider.getRelatedOperation())) {
                activated.add(provider);
            }
        }
        return activated;
    }

    /**
     * Check if the related operation for the loaded
     * {@link CapabilitiesExtensionProvider} is active
     *
     * @param key              the key
     * @param relatedOperation the operation
     *
     * @return <code>true</code>, if related operation is active
     */
    private boolean checkIfRelatedOperationIsActivated(
            CapabilitiesExtensionKey key, String relatedOperation) {
        RequestOperatorKey rok = new RequestOperatorKey(key.getService(),
                key.getVersion(),
                relatedOperation);
        return this.requestOperatorRepository.isActive(rok);
    }

    @Deprecated
    public static CapabilitiesExtensionRepository getInstance(
    ) {
        return CapabilitiesExtensionRepository.instance;
    }

}

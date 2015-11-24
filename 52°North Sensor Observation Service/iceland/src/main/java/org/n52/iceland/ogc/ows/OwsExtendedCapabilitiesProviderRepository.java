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
package org.n52.iceland.ogc.ows;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.service.AbstractServiceCommunicationObject;
import org.n52.iceland.service.operator.ServiceOperatorKey;
import org.n52.iceland.util.CollectionHelper;
import org.n52.iceland.util.Producer;
import org.n52.iceland.util.Producers;
import org.n52.iceland.util.activation.Activatables;
import org.n52.iceland.util.activation.ActivationListener;
import org.n52.iceland.util.activation.ActivationListeners;
import org.n52.iceland.util.activation.ActivationManager;
import org.n52.iceland.util.activation.ActivationSource;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * Repository for {@link OwsExtendedCapabilities}. Loads all implemented
 * {@link OwsExtendedCapabilitiesProvider} and adds to this repository.
 *
 * @since 4.0.0
 *
 */
public class OwsExtendedCapabilitiesProviderRepository
        extends AbstractComponentRepository<OwsExtendedCapabilitiesProviderKey, OwsExtendedCapabilitiesProvider, OwsExtendedCapabilitiesProviderFactory>
        implements ActivationManager<OwsExtendedCapabilitiesProviderKey>,
                   ActivationSource<OwsExtendedCapabilitiesProviderKey>,
                   Constructable {
    @Deprecated
    private static OwsExtendedCapabilitiesProviderRepository instance;

    private final Map<OwsExtendedCapabilitiesProviderKey, Producer<OwsExtendedCapabilitiesProvider>> extendedCapabilitiesProvider = new HashMap<>();

    @Autowired(required = false)
    private Collection<OwsExtendedCapabilitiesProvider> components;

    @Autowired(required = false)
    private Collection<OwsExtendedCapabilitiesProviderFactory> componentFactories;

    private final ActivationListeners<OwsExtendedCapabilitiesProviderKey> activations = new ActivationListeners<>(true);

    @Override
    public void init() {
        OwsExtendedCapabilitiesProviderRepository.instance = this;
        Map<OwsExtendedCapabilitiesProviderKey, Producer<OwsExtendedCapabilitiesProvider>> implemtations
                = getUniqueProviders(this.components, this.componentFactories);
        this.extendedCapabilitiesProvider.clear();
        this.extendedCapabilitiesProvider.putAll(implemtations);
    }

    @Override
    public Set<OwsExtendedCapabilitiesProviderKey> getKeys() {
        return Collections.unmodifiableSet(this.extendedCapabilitiesProvider.keySet());
    }

    @Override
    public void registerListener(ActivationListener<OwsExtendedCapabilitiesProviderKey> listener) {
        this.activations.registerListener(listener);
    }

    @Override
    public void deregisterListener(ActivationListener<OwsExtendedCapabilitiesProviderKey> listener) {
        this.activations.deregisterListener(listener);
    }

    @Override
    public boolean isActive(OwsExtendedCapabilitiesProviderKey key) {
        return this.activations.isActive(key);
    }

    @Override
    public void activate(OwsExtendedCapabilitiesProviderKey key) {
        this.activations.activate(key);
    }

    @Override
    public void deactivate(OwsExtendedCapabilitiesProviderKey key) {
        this.activations.deactivate(key);
    }

    /**
     * Get map of all, active and inactive,
     * {@link OwsExtendedCapabilitiesProvider}s
     *
     * @return the map with all {@link OwsExtendedCapabilitiesProvider}s
     */
    public Map<OwsExtendedCapabilitiesProviderKey, OwsExtendedCapabilitiesProvider> getAllExtendedCapabilitiesProviders() {
        return Producers.produce(this.extendedCapabilitiesProvider);
    }

    /**
     * Get map of all active {@link OwsExtendedCapabilitiesProvider}s
     *
     * @return the map with all active {@link OwsExtendedCapabilitiesProvider}s
     */
    public Map<OwsExtendedCapabilitiesProviderKey, OwsExtendedCapabilitiesProvider> getExtendedCapabilitiesProviders() {
        return Producers.produce(Activatables.activatedMap(this.extendedCapabilitiesProvider, this.activations));
    }

    /**
     * Get the loaded {@link OwsExtendedCapabilitiesProvider} implementation for
     * the specific service and version
     *
     * @param serviceCommunicationObject
     *            The {@link AbstractServiceCommunicationObject} with service
     *            and version
     * @return loaded {@link OwsExtendedCapabilitiesProvider} implementation
     */
    public OwsExtendedCapabilitiesProvider getExtendedCapabilitiesProvider(AbstractServiceCommunicationObject serviceCommunicationObject) {
        for (String name : getDomains()) {
            OwsExtendedCapabilitiesProvider provider =
                    getExtendedCapabilitiesProvider(new OwsExtendedCapabilitiesProviderKey(
                            serviceCommunicationObject.getService(), serviceCommunicationObject.getVersion(), name));
            if (provider != null) {
                return provider;
            }
        }
        return null;
    }

    /**
     * Get the loaded {@link OwsExtendedCapabilitiesProvider} implementation for
     * the specific {@link OwsExtendedCapabilitiesProviderKey}
     *
     * @param key
     *            The related {@link OwsExtendedCapabilitiesProviderKey}
     * @return loaded {@link OwsExtendedCapabilitiesProvider} implementation
     */
    public OwsExtendedCapabilitiesProvider getExtendedCapabilitiesProvider(
            OwsExtendedCapabilitiesProviderKey key) {
        return getExtendedCapabilitiesProviders().get(key);
    }

    /**
     * Check if a {@link OwsExtendedCapabilitiesProvider} implementation is
     * loaded for the specific {@link AbstractServiceCommunicationObject}
     *
     * @param serviceCommunicationObject
     *            The {@link AbstractServiceCommunicationObject} with service
     *            and version
     * @return <code>true</code>, if a {@link OwsExtendedCapabilitiesProvider}
     *         implementation is loaded for the specific
     *         {@link AbstractServiceCommunicationObject}
     */
    public boolean hasExtendedCapabilitiesProvider(AbstractServiceCommunicationObject serviceCommunicationObject) {
        boolean hasProvider;
        for (String name : getDomains()) {
            hasProvider = hasExtendedCapabilitiesProvider(new OwsExtendedCapabilitiesProviderKey(
                    serviceCommunicationObject.getService(), serviceCommunicationObject.getVersion(), name));
            if (hasProvider) {
                return hasProvider;
            }
        }
        return false;
    }

    /**
     * Check if a {@link OwsExtendedCapabilitiesProvider} implementation is
     * loaded for the specific {@link OwsExtendedCapabilitiesProviderKey}
     *
     * @param key
     *            The related {@link OwsExtendedCapabilitiesProviderKey} to check for
     * @return <code>true</code>, if a {@link OwsExtendedCapabilitiesProvider}
     *         implementation is loaded for the specific
     *         {@link OwsExtendedCapabilitiesProviderKey}
     */
    public boolean hasExtendedCapabilitiesProvider(OwsExtendedCapabilitiesProviderKey key) {
        return getExtendedCapabilitiesProviders().containsKey(key);
    }

    /**
     * Change the status of the {@link OwsExtendedCapabilitiesProvider} which
     * relates to the requested {@link OwsExtendedCapabilitiesProviderKey}
     *
     * @param oeckt
     *            the {@link OwsExtendedCapabilitiesProviderKey} to change the status
     *            for
     * @param active
     *            the new status
     */
    public void setActive(OwsExtendedCapabilitiesProviderKey oeckt, boolean active) {
        if (this.extendedCapabilitiesProvider.containsKey(oeckt)) {
            this.activations.activate(oeckt);
            if (active) {
                for (OwsExtendedCapabilitiesProviderKey key : this.extendedCapabilitiesProvider.keySet()) {
                    if (key.getService().equals(oeckt.getService()) &&
                        key.getVersion().equals(oeckt.getVersion())) {
                        this.activations.deactivate(key);
                    }
                }
            } else {
                this.activations.deactivate(oeckt);
            }
        }
    }

    /**
     * Get map with {@link ServiceOperatorKey} and linked domain values
     *
     * @return the map with {@link ServiceOperatorKey} and linked domain values
     */
    public Map<ServiceOperatorKey, Collection<String>> getAllDomains() {
        Map<ServiceOperatorKey, Collection<String>> domains = Maps.newHashMap();
        for (OwsExtendedCapabilitiesProviderKey key : getAllExtendedCapabilitiesProviders().keySet()) {
            CollectionHelper.addToCollectionMap(key.getServiceOperatorKey(), key.getDomain(), domains);
        }
        return domains;
    }

    /**
     * Get all domain values from {@link OwsExtendedCapabilitiesProviderKey}
     *
     * @return the domain values
     */
    private Set<String> getDomains() {
        Set<String> domains = Sets.newHashSet();
        for (OwsExtendedCapabilitiesProviderKey key : getExtendedCapabilitiesProviders().keySet()) {
            domains.add(key.getDomain());
        }
        return domains;
    }

    /**
     * For singleton use
     *
     * @return The single instance
     */
    @Deprecated
    public static OwsExtendedCapabilitiesProviderRepository getInstance() {
        return OwsExtendedCapabilitiesProviderRepository.instance;
    }

}

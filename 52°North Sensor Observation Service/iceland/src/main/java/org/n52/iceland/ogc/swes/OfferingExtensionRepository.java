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
package org.n52.iceland.ogc.swes;

import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.service.AbstractServiceCommunicationObject;
import org.n52.iceland.service.operator.ServiceOperatorKey;
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
 * Repository for {@link OfferingExtensionProvider} implementations
 *
 * @since 4.1.0
 *
 */
public class OfferingExtensionRepository extends AbstractComponentRepository<OfferingExtensionKey, OfferingExtensionProvider, OfferingExtensionProviderFactory>
        implements ActivationManager<OfferingExtensionKey>,
                   ActivationSource<OfferingExtensionKey>,
                   Constructable {
    @Deprecated
    private static OfferingExtensionRepository instance;
    private final Map<OfferingExtensionKey, Producer<OfferingExtensionProvider>> offeringExtensionProviders = new HashMap<>(0);
    private final ActivationListeners<OfferingExtensionKey> activation = new ActivationListeners<>(true);

    @Autowired(required = false)
    private Collection<OfferingExtensionProvider> components;
    @Autowired(required = false)
    private Collection<OfferingExtensionProviderFactory> componentFactories;

    @Override
    public void init() {
        OfferingExtensionRepository.instance = this;
        Map<OfferingExtensionKey, Producer<OfferingExtensionProvider>> implementations
                = getUniqueProviders(this.components, this.componentFactories);
        this.offeringExtensionProviders.clear();
        this.offeringExtensionProviders.putAll(implementations);
    }

    @Override
    public void registerListener(ActivationListener<OfferingExtensionKey> listener) {
        this.activation.registerListener(listener);
    }

    @Override
    public void deregisterListener(ActivationListener<OfferingExtensionKey> listener) {
        this.activation.deregisterListener(listener);
    }

    @Override
    public boolean isActive(OfferingExtensionKey key) {
        return this.activation.isActive(key);
    }

    @Override
    public void activate(OfferingExtensionKey key) {
        this.activation.activate(key);
    }

    @Override
    public void deactivate(OfferingExtensionKey key) {
        this.activation.deactivate(key);
    }

    @Override
    public Set<OfferingExtensionKey> getKeys() {
        return Collections.unmodifiableSet(this.offeringExtensionProviders.keySet());
    }

    /**
     * Get map of all, active and inactive, {@link OfferingExtensionProvider}s
     *
     * @return the map with all {@link OfferingExtensionProvider}s
     */
    public Map<OfferingExtensionKey, OfferingExtensionProvider> getAllOfferingExtensionProviders() {
        return Producers.produce(this.offeringExtensionProviders);
    }

    /**
     * Get map of all active {@link OfferingExtensionProvider}s
     *
     * @return the map with all active {@link OfferingExtensionProvider}s
     */
    public Map<OfferingExtensionKey, OfferingExtensionProvider> getOfferingExtensionProviders() {
        return Producers.produce(Activatables.activatedMap(offeringExtensionProviders, this.activation));
    }

    /**
     * Get the loaded {@link OfferingExtensionProvider} implementation for the
     * specific service and version
     *
     * @param message
     *            The {@link AbstractServiceCommunicationObject} with service
     *            and version
     * @return loaded {@link OfferingExtensionProvider} implementation
     */
    public Set<OfferingExtensionProvider> getOfferingExtensionProvider(AbstractServiceCommunicationObject message) {
        Set<OfferingExtensionProvider> providers = Sets.newHashSet();
        for (String name : getDomains()) {
            OfferingExtensionKey key = new OfferingExtensionKey(message.getService(), message.getVersion(), name);
            OfferingExtensionProvider provider = getOfferingExtensionProvider(key);
            if (provider != null) {
                providers.add(provider);
            }
        }
        return providers;
    }

    /**
     * Get the loaded {@link OfferingExtensionProvider} implementation for the
     * specific {@link OfferingExtensionKey}
     *
     * @param key
     *            The related {@link OfferingExtensionKey}
     * @return loaded {@link OfferingExtensionProvider} implementation
     */
    public OfferingExtensionProvider getOfferingExtensionProvider(
            OfferingExtensionKey key) {
        return getOfferingExtensionProviders().get(key);
    }

    /**
     * Check if a {@link OfferingExtensionProvider} implementation is loaded for
     * the specific {@link OfferingExtensionKey}
     *
     * @param key
     *            The related {@link OfferingExtensionKey} to check for
     * @return <code>true</code>, if a {@link OfferingExtensionProvider}
     *         implementation is loaded for the specific service
     */
    public boolean hasOfferingExtensionProviderFor(OfferingExtensionKey key) {
        return getOfferingExtensionProviders().containsKey(key);
    }

    /**
     * Check if a provider is available for the requested service and version
     *
     * @param message
     *            request object with service and version
     * @return <code>true</code>, if a {@link OfferingExtensionProvider} is
     *         available
     */
    public boolean hasOfferingExtensionProviderFor(AbstractServiceCommunicationObject message) {
        boolean hasProvider;
        for (String name : getDomains()) {
            OfferingExtensionKey key
                    = new OfferingExtensionKey(message.getService(), message.getVersion(), name);
            hasProvider = hasOfferingExtensionProviderFor(key);
            if (hasProvider) {
                return activation.isActive(key);
            }
        }
        return false;
    }

    /**
     * Change the status of the {@link OfferingExtensionProvider} which relates
     * to the requested {@link OfferingExtensionKey}
     *
     * @param oekt
     *            the {@link OfferingExtensionKey} to change the status for
     * @param active
     *            the new status
     */
    @Override
    public void setActive(final OfferingExtensionKey oekt, final boolean active) {
        this.activation.setActive(oekt, active);
    }

    /**
     * Get map with {@link ServiceOperatorKey} and linked domain values
     *
     * @return the map with {@link ServiceOperatorKey} and linked domain values
     */
    public Map<ServiceOperatorKey, Collection<String>> getAllDomains() {
        Map<ServiceOperatorKey, Collection<String>> domains = Maps.newHashMap();
        Activatables.activatedKeys(this.offeringExtensionProviders, this.activation).stream().forEach(key -> {
            domains.computeIfAbsent(key.getServiceOperatorKey(), sok -> new LinkedList<>()).add(key.getDomain());
        });
        return domains;
    }

    /**
     * Get all domain values from {@link OfferingExtensionKey}
     *
     * @return the domain values
     */
    private Set<String> getDomains() {
        return Activatables.activatedKeys(this.offeringExtensionProviders, this.activation)
                .stream().map(OfferingExtensionKey::getDomain).collect(toSet());
    }

    /**
     * For singleton use
     *
     * @return The single instance
     * @deprecated use injection
     */
    @Deprecated
    public static OfferingExtensionRepository getInstance() {
        return OfferingExtensionRepository.instance;
    }
}

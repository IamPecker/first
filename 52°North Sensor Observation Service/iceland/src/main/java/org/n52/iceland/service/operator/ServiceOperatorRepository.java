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

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.util.CollectionHelper;
import org.n52.iceland.util.Producer;
import org.n52.iceland.util.collections.MultiMaps;
import org.n52.iceland.util.collections.SetMultiMap;

import com.google.common.collect.Maps;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 4.0.0
 */
public class ServiceOperatorRepository extends AbstractComponentRepository<ServiceOperatorKey, ServiceOperator, ServiceOperatorFactory> implements Constructable{
    @Deprecated
    private static ServiceOperatorRepository instance;
    /**
     * Implemented ServiceOperator
     */
    private final Map<ServiceOperatorKey, Producer<ServiceOperator>> serviceOperators = Maps.newHashMap();

    /** supported SOS versions */
    private final SetMultiMap<String, String> supportedVersions = MultiMaps.newSetMultiMap();


    @Autowired(required = false)
    private Collection<ServiceOperator> components;
    @Autowired(required = false)
    private Collection<ServiceOperatorFactory> componentFactories;

    @Override
    public void init() {
        ServiceOperatorRepository.instance = this;
        Map<ServiceOperatorKey, Producer<ServiceOperator>> implementations
                = getUniqueProviders(this.components, this.componentFactories);

        this.serviceOperators.clear();
        this.supportedVersions.clear();

        for (Entry<ServiceOperatorKey, Producer<ServiceOperator>> entry: implementations.entrySet()) {
            ServiceOperatorKey key = entry.getKey();
            Producer<ServiceOperator> producer = entry.getValue();
            this.serviceOperators.put(key, producer);
            this.supportedVersions.add(key.getService(), key.getVersion());
        }
    }

    /**
     * @return the implemented request listener
     */
    public Map<ServiceOperatorKey, ServiceOperator> getServiceOperators() {
        Map<ServiceOperatorKey, ServiceOperator> result = Maps.newHashMap();
        for (Entry<ServiceOperatorKey, Producer<ServiceOperator>> entrySet : this.serviceOperators.entrySet()) {
            ServiceOperatorKey key = entrySet.getKey();
            Producer<ServiceOperator> value = entrySet.getValue();
            result.put(key, value.get());
        }
        return result;
    }

    @Deprecated
    public Set<ServiceOperatorKey> getServiceOperatorKeyTypes() {
        return getServiceOperatorKeys();
    }

    public Set<ServiceOperatorKey> getServiceOperatorKeys() {
        return getServiceOperators().keySet();
    }

    public ServiceOperator getServiceOperator(ServiceOperatorKey sok) {
        Producer<ServiceOperator> producer = serviceOperators.get(sok);
        return producer == null ? null : producer.get();
    }

    /**
     * @param service
     *            the service
     * @param version
     *            the version
     * @return the implemented request listener
     *
     *
     * @throws OwsExceptionReport
     */
    public ServiceOperator getServiceOperator(final String service, final String version) throws OwsExceptionReport {
        return getServiceOperator(new ServiceOperatorKey(service, version));
    }

    public Set<String> getAllSupportedVersions() {
        return this.supportedVersions.values().stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    /**
     * @param service
     *            the service
     * @return the supportedVersions
     *
     */
    public Set<String> getSupportedVersions(String service) {
        return Collections.unmodifiableSet(this.supportedVersions.getOrDefault(service, Collections.emptySet()));
    }

    /**
     * @param service
     *            the service
     * @param version
     *            the version
     * @return the supportedVersions
     *
     */
    public boolean isVersionSupported(String service, String version) {
        return getSupportedVersions(service).contains(version);
    }

    /**
     * @return the supportedVersions
     */
    public Set<String> getSupportedServices() {
        return Collections.unmodifiableSet(this.supportedVersions.keySet());
    }

    public boolean isServiceSupported(String service) {
        return this.supportedVersions.containsKey(service);
    }

    @Deprecated
    public static ServiceOperatorRepository getInstance() {
        return ServiceOperatorRepository.instance;
    }

}

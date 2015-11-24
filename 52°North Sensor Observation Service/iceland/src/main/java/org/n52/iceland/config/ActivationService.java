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
package org.n52.iceland.config;

import java.util.Set;

import javax.inject.Inject;

import org.n52.iceland.binding.BindingKey;
import org.n52.iceland.ogc.ows.OwsExtendedCapabilitiesProviderKey;
import org.n52.iceland.ogc.swes.OfferingExtensionKey;
import org.n52.iceland.request.operator.RequestOperatorKey;
import org.n52.iceland.util.activation.ActivationInitializer;
import org.n52.iceland.util.activation.ActivationSource;
import org.n52.iceland.util.activation.DefaultActivationInitializer;
import org.n52.iceland.util.activation.FunctionalActivationListener;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public class ActivationService {

    private ActivationDao dao;

    @Inject
    public void setPersistingActivationManagerDao(ActivationDao dao) {
        this.dao = dao;
    }

    /**
     * Checks if the binding is active.
     *
     * @param key
     *            the binding
     *
     * @return if the binding is active
     */
    public boolean isBindingActive(BindingKey key) {
        return this.dao.isBindingActive(key);
    }

    /**
     * Checks if the extended capabilities is active.
     *
     * @param key
     *            the extended capabilities key
     *
     * @return if the extended capabilities is active
     *
     */
    public boolean isOwsExtendedCapabilitiesProviderActive(
            OwsExtendedCapabilitiesProviderKey key) {
        return this.dao.isOwsExtendedCapabilitiesProviderActive(key);
    }

    /**
     * Returns if a operation is active and should be offered by this SOS.
     *
     * @param key
     *            the key identifying the operation
     *
     * @return {@code true} if the operation is active in this SOS
     */
    public boolean isRequestOperatorActive(RequestOperatorKey key) {
        return this.dao.isRequestOperatorActive(key);
    }

    public FunctionalActivationListener<RequestOperatorKey> getRequestOperatorListener() {
        return this.dao::setOperationStatus;
    }

    public ActivationSource<RequestOperatorKey> getRequestOperatorSource() {
        return ActivationSource.create(this::isRequestOperatorActive,
                                       this::getRequestOperatorKeys);
    }

    public Set<RequestOperatorKey> getRequestOperatorKeys() {
        return this.dao.getRequestOperatorKeys();
    }

    public ActivationInitializer<RequestOperatorKey> getRequestOperatorInitializer() {
        return new DefaultActivationInitializer<>(getRequestOperatorSource());
    }

    public FunctionalActivationListener<BindingKey> getBindingListener() {
        return this.dao::setBindingStatus;
    }

    public ActivationSource<BindingKey> getBindingSource() {
        return ActivationSource.create(this::isBindingActive,
                                       this::getBindingKeys);
    }

    public Set<BindingKey> getBindingKeys() {
        return this.dao.getBindingKeys();
    }

    public ActivationInitializer<BindingKey> getBindingInitializer() {
        return new DefaultActivationInitializer<>(getBindingSource());
    }

    public FunctionalActivationListener<OwsExtendedCapabilitiesProviderKey> getOwsExtendedCapabiltiesListener() {
        return this.dao::setOwsExtendedCapabilitiesStatus;
    }

    public ActivationSource<OwsExtendedCapabilitiesProviderKey> getOwsExtendedCapabiltiesSource() {
        return ActivationSource
                .create(this::isOwsExtendedCapabilitiesProviderActive,
                        this::getOwsExtendedCapabilitiesProviderKeys);
    }

    public Set<OwsExtendedCapabilitiesProviderKey> getOwsExtendedCapabilitiesProviderKeys() {
        return this.dao.getOwsExtendedCapabilitiesProviderKeys();
    }

    public ActivationInitializer<OwsExtendedCapabilitiesProviderKey> getOwsExtendedCapabiltiesInitializer() {
        return new DefaultActivationInitializer<>(getOwsExtendedCapabiltiesSource());
    }

    /**
     * Checks if the offering extension is active.
     *
     * @param key
     *            the offering extension key
     *
     * @return if the offering extension is active
     */
    public boolean isOfferingExtensionActive(OfferingExtensionKey key) {
        return this.dao.isOfferingExtensionActive(key);
    }

    public FunctionalActivationListener<OfferingExtensionKey> getOfferingExtensionListener() {
        return this.dao::setOfferingExtensionStatus;
    }

    public ActivationSource<OfferingExtensionKey> getOfferingExtensionSource() {
        return ActivationSource.create(this::isOfferingExtensionActive,
                                       this::getOfferingExtensionKeys);
    }

    protected Set<OfferingExtensionKey> getOfferingExtensionKeys() {
        return this.dao.getOfferingExtensionKeys();
    }

    public ActivationInitializer<OfferingExtensionKey> getOfferingExtensionInitializer() {
        return new DefaultActivationInitializer<>(getOfferingExtensionSource());
    }
}

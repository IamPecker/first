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

import org.n52.iceland.binding.BindingKey;
import org.n52.iceland.ogc.ows.OwsExtendedCapabilitiesProviderKey;
import org.n52.iceland.ogc.swes.OfferingExtensionKey;
import org.n52.iceland.request.operator.RequestOperatorKey;

/**
 *
 * @author Christian Autermann
 */
public interface ActivationDao {

    /**
     * Returns if a operation is active and should be offered by this SOS.
     *
     * @param key the key identifying the operation
     *
     * @return {@code true} if the operation is active in this SOS
     */
    public abstract boolean isRequestOperatorActive(RequestOperatorKey key);

    /**
     * Sets the status of an operation.
     *
     * @param key    the key identifying the operation
     * @param active whether the operation is active or not
     */
    void setOperationStatus(RequestOperatorKey key, boolean active);

    Set<RequestOperatorKey> getRequestOperatorKeys();

    /**
     * Checks if the binding is active.
     *
     * @param key the binding
     *
     * @return if the binding is active
     */
    public abstract boolean isBindingActive(BindingKey key);

    /**
     * Sets the status of a binding.
     *
     * @param key    the binding
     * @param active the status
     */
    void setBindingStatus(BindingKey key, boolean active);

    Set<BindingKey> getBindingKeys();

    /**
     * Checks if the extended capabilities is active.
     *
     * @param key the extended capabilities key
     *
     * @return if the extended capabilities is active
     */
    public abstract boolean isOwsExtendedCapabilitiesProviderActive(
            OwsExtendedCapabilitiesProviderKey key);

    void setOwsExtendedCapabilitiesStatus(OwsExtendedCapabilitiesProviderKey key,
                                          boolean active);

    Set<OwsExtendedCapabilitiesProviderKey> getOwsExtendedCapabilitiesProviderKeys();


    /**
     * Checks if the offering extension is active.
     *
     * @param key
     *            the offering extension key
     *
     * @return if the offering extension is active
     */
    boolean isOfferingExtensionActive(OfferingExtensionKey key);

    void setOfferingExtensionStatus(OfferingExtensionKey key, boolean active);

    Set<OfferingExtensionKey> getOfferingExtensionKeys();

}

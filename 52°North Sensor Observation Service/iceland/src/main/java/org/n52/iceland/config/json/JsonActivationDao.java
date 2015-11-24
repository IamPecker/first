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
package org.n52.iceland.config.json;



import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.n52.iceland.binding.BindingKey;
import org.n52.iceland.binding.MediaTypeBindingKey;
import org.n52.iceland.binding.PathBindingKey;
import org.n52.iceland.config.ActivationDao;
import org.n52.iceland.ogc.ows.OwsExtendedCapabilitiesProviderKey;
import org.n52.iceland.ogc.swes.OfferingExtensionKey;
import org.n52.iceland.request.operator.RequestOperatorKey;
import org.n52.iceland.service.operator.ServiceOperatorKey;
import org.n52.iceland.util.http.MediaType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * TODO JavaDoc
 * @author Christian Autermann
 */
public class JsonActivationDao extends AbstractJsonActivationDao
        implements ActivationDao {
    protected static final String OFFERING_EXTENSIONS = "offeringExtensions";

  @Override
    public boolean isRequestOperatorActive(RequestOperatorKey key) {
        return isActive(JsonConstants.OPERATIONS, matches(key), key.isDefaultActive());
    }

    @Override
    public void setOperationStatus(RequestOperatorKey key, boolean active) {
        setStatus(JsonConstants.OPERATIONS, matches(key), s -> encode(s, key), active);
    }

    @Override
    public Set<RequestOperatorKey> getRequestOperatorKeys() {
        return getKeys(JsonConstants.OPERATIONS, this::decodeRequestOperatorKey);
    }

    @Override
    public boolean isBindingActive(BindingKey key) {
        readLock().lock();
        try {
            return getConfiguration()
                    .path(JsonConstants.ACTIVATION)
                    .path(JsonConstants.BINDINGS)
                    .path(key.getKeyAsString())
                    .asBoolean(true);
        } finally {
            readLock().unlock();
        }
    }

    @Override
    public void setBindingStatus(BindingKey key, boolean active) {
        writeLock().lock();
        try {
            ObjectNode node = getConfiguration()
                    .with(JsonConstants.ACTIVATION)
                    .with(JsonConstants.BINDINGS);
            if (key instanceof PathBindingKey) {
                node = node.with(JsonConstants.BY_PATH);
            } else if (key instanceof MediaTypeBindingKey) {
                node = node.with(JsonConstants.BY_MEDIA_TYPE);
            }
            node.put(key.getKeyAsString(), active);
        } finally {
            writeLock().unlock();
        }
        configuration().scheduleWrite();
    }

    @Override
    public Set<BindingKey> getBindingKeys() {
        readLock().lock();
        try {
            JsonNode node = getConfiguration().path(JsonConstants.ACTIVATION).path(JsonConstants.BINDINGS);
            Set<BindingKey> keys = new HashSet<>(node.size());
            node.path(JsonConstants.BY_PATH).fieldNames()
                    .forEachRemaining(k -> keys.add(new PathBindingKey(k)));
            node.path(JsonConstants.BY_MEDIA_TYPE).fieldNames()
                    .forEachRemaining(k -> keys
                            .add(new MediaTypeBindingKey(MediaType.parse(k))));
            return keys;
        } finally {
            readLock().unlock();
        }
    }

     @Override
    public boolean isOfferingExtensionActive(OfferingExtensionKey key) {
        return isActive(OFFERING_EXTENSIONS, matches(key), true);
    }

    @Override
    public void setOfferingExtensionStatus(OfferingExtensionKey key, boolean active) {
        setStatus(OFFERING_EXTENSIONS, matches(key), s -> encode(s, key), active);
    }

    @Override
    public Set<OfferingExtensionKey> getOfferingExtensionKeys() {
        return getKeys(OFFERING_EXTENSIONS, createDomainDecoder(OfferingExtensionKey::new));
    }


    @Override
    public boolean isOwsExtendedCapabilitiesProviderActive(OwsExtendedCapabilitiesProviderKey key) {
        return isActive(JsonConstants.OWS_EXTENDED_CAPABILITIES_PROVIDERS, matches(key), true);
    }

    @Override
    public void setOwsExtendedCapabilitiesStatus(OwsExtendedCapabilitiesProviderKey key, boolean active) {
        setStatus(JsonConstants.OWS_EXTENDED_CAPABILITIES_PROVIDERS, matches(key), s -> encode(s, key), active);
    }

    @Override
    public Set<OwsExtendedCapabilitiesProviderKey> getOwsExtendedCapabilitiesProviderKeys() {
        return getKeys(JsonConstants.OWS_EXTENDED_CAPABILITIES_PROVIDERS, decodeOwsExtendedCapabilitiesProviderKey());
    }


    protected RequestOperatorKey decodeRequestOperatorKey(JsonNode node) {
        return new RequestOperatorKey(decodeServiceOperatorKey(node),
                node.path(JsonConstants.OPERATION_NAME).textValue());
    }

    protected Function<JsonNode, OwsExtendedCapabilitiesProviderKey> decodeOwsExtendedCapabilitiesProviderKey() {
        return createDomainDecoder(OwsExtendedCapabilitiesProviderKey::new);
    }

    protected Supplier<ObjectNode> encode(Supplier<ObjectNode> supplier, RequestOperatorKey key) {
        Objects.requireNonNull(supplier);
        return () -> {
            ServiceOperatorKey sok = key == null ? null : key.getServiceOperatorKey();
            String operationName = key == null ? null : key.getOperationName();
            return encode(supplier, sok).get()
                    .put(JsonConstants.OPERATION_NAME, operationName);
        };
    }

    protected Predicate<JsonNode> matches(RequestOperatorKey key) {
        ServiceOperatorKey sok = key == null ? null : key.getServiceOperatorKey();
        String operationName = key == null ? null : key.getOperationName();
        return matches(sok).and(matchesOperationName(operationName));
    }

    protected Predicate<JsonNode> matchesOperationName(String operationName) {
        if (operationName == null) {
            return isNullOrMissing(JsonConstants.OPERATION_NAME);
        }
        return n -> n.path(JsonConstants.OPERATION_NAME).asText().equals(operationName);
    }

}

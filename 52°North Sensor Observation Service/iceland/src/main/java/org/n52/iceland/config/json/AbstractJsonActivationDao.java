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

import static java.util.stream.Collectors.toSet;

import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.n52.iceland.ogc.AbstractComparableServiceVersionDomainKey;
import org.n52.iceland.service.operator.ServiceOperatorKey;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public abstract class AbstractJsonActivationDao extends AbstractJsonDao {

    protected boolean isActive(String path,
                               Predicate<JsonNode> matcher,
                               boolean defaultValue) {
        readLock().lock();
        try {
            JsonNode array = getConfiguration().path(JsonConstants.ACTIVATION)
                    .path(path);
            return createStream(array).filter(matcher)
                    .findAny().orElseGet(MissingNode::getInstance)
                    .path(JsonConstants.ACTIVE).asBoolean(defaultValue);
        } finally {
            readLock().unlock();
        }
    }

    protected void setStatus(String path,
                             Predicate<JsonNode> matcher,
                             Function<Supplier<ObjectNode>, Supplier<ObjectNode>> encoder,
                             boolean active) {
        writeLock().lock();
        try {
            ArrayNode array = getConfiguration().with(JsonConstants.ACTIVATION)
                    .withArray(path);
            ObjectNode node = (ObjectNode) createStream(array)
                    .filter(matcher).findAny()
                    .orElseGet(encoder.apply(array::addObject));
            node.put(JsonConstants.ACTIVE, active);
        } finally {
            writeLock().unlock();
        }
        configuration().scheduleWrite();
    }

    protected <K> Set<K> getKeys(String path,
                                 Function<JsonNode, K> decoder) {
        readLock().lock();
        try {
            JsonNode array = getConfiguration().path(JsonConstants.ACTIVATION)
                    .path(path);
            return createStream(array).map(decoder).collect(toSet());
        } finally {
            readLock().unlock();
        }
    }

    protected Predicate<JsonNode> matches(
            AbstractComparableServiceVersionDomainKey<?> key) {
        ServiceOperatorKey sok = key == null ? null : key
                .getServiceOperatorKey();
        String domain = key == null ? null : key.getDomain();
        return matches(sok).and(matchesDomain(domain));
    }

    protected Predicate<JsonNode> matchesDomain(String domain) {
        if (domain == null) {
            return isNullOrMissing(JsonConstants.DOMAIN);
        }
        return n -> n.path(JsonConstants.DOMAIN).asText().equals(domain);
    }

    protected Predicate<JsonNode> matches(ServiceOperatorKey key) {
        String service = key == null ? null : key.getService();
        String version = key == null ? null : key.getVersion();
        return matchesService(service).and(matchesVersion(version));
    }

    protected Predicate<JsonNode> matchesService(String service) {
        if (service == null) {
            return isNullOrMissing(JsonConstants.SERVICE);
        }
        return n -> n.path(JsonConstants.SERVICE).asText().equals(service);
    }

    protected Predicate<JsonNode> matchesVersion(String version) {
        if (version == null) {
            return isNullOrMissing(JsonConstants.VERSION);
        }
        return n -> n.path(JsonConstants.VERSION).asText().equals(version);
    }

    protected Supplier<ObjectNode> encode(Supplier<ObjectNode> supplier,
                                          AbstractComparableServiceVersionDomainKey<?> key) {
        Objects.requireNonNull(supplier);
        return () -> {
            ServiceOperatorKey sok = key == null ? null : key
                    .getServiceOperatorKey();
            String domain = key == null ? null : key.getDomain();
            return encode(supplier, sok).get().put(JsonConstants.DOMAIN, domain);
        };
    }

    protected <K extends AbstractComparableServiceVersionDomainKey<K>> Function<JsonNode, K> createDomainDecoder(
            BiFunction<ServiceOperatorKey, String, K> fun) {
        Objects.requireNonNull(fun);
        return n -> fun.apply(decodeServiceOperatorKey(n), n.path(JsonConstants.DOMAIN).textValue());
    }

    protected Supplier<ObjectNode> encode(Supplier<ObjectNode> supplier,
                                          ServiceOperatorKey key) {
        Objects.requireNonNull(supplier);
        return () -> {
            String service = key == null ? null : key.getService();
            String version = key == null ? null : key.getVersion();
            return supplier.get().put(JsonConstants.SERVICE, service)
                    .put(JsonConstants.VERSION, version);
        };
    }

    protected ServiceOperatorKey decodeServiceOperatorKey(JsonNode node) {
        return new ServiceOperatorKey(
                node.path(JsonConstants.SERVICE).textValue(),
                node.path(JsonConstants.VERSION).textValue());
    }

}

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
package org.n52.iceland.util.activation;

import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.n52.iceland.lifecycle.Constructable;

import com.google.common.collect.Maps;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
@SuppressWarnings("rawtypes")
public class ActivationRegistrator implements Constructable {
    private static final Logger LOG = LoggerFactory
            .getLogger(ActivationRegistrator.class);

    private final Map<ActivationListenable, ActivationListener> listeners;
    private final Map<ActivationSink, ActivationInitializer> initializers;

    public ActivationRegistrator() {
        LOG.debug("Constructor");
        this.listeners = Maps.newHashMap();
        this.initializers = Maps.newHashMap();
    }

    public void setListeners(Map<ActivationListenable, ActivationListener> listeners) {
        Optional.ofNullable(listeners).ifPresent(this.listeners::putAll);
    }

    public void setInitializers(Map<ActivationSink, ActivationInitializer> initializers) {
        Optional.ofNullable(initializers).ifPresent(this.initializers::putAll);
    }

    @Override
    public void init() {
        LOG.debug("Initializing");
        initializeSinks();
        registerListeners();
    }

    @SuppressWarnings("unchecked")
    private void initializeSinks() {
        LOG.debug("Initializing sinks");
        this.initializers.forEach(switchParams(chain(logger(), ActivationInitializer::initialize)));
    }

    @SuppressWarnings("unchecked")
    private  void registerListeners() {
        LOG.debug("Registering listeners");
        this.listeners.forEach(chain(logger(), ActivationListenable::registerListener));
    }

    private static <T, U> BiConsumer<T,U> logger() {
        return (a, b) -> LOG.debug("Registrating {} for {}", a, b);
    }

    private static <T, U> BiConsumer<T, U> chain(BiConsumer<T, U> first, BiConsumer<T, U> second) {
        return first.andThen(second);
    }

    private static <T, U> BiConsumer<U, T> switchParams(BiConsumer<T, U> consumer) {
        return (a, b) -> consumer.accept(b, a);
    }
}

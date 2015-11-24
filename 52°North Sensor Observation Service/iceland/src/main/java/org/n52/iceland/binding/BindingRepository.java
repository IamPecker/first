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
package org.n52.iceland.binding;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.util.Producer;
import org.n52.iceland.util.Producers;
import org.n52.iceland.util.activation.Activatables;
import org.n52.iceland.util.activation.ActivationListener;
import org.n52.iceland.util.activation.ActivationListeners;
import org.n52.iceland.util.activation.ActivationManager;
import org.n52.iceland.util.activation.ActivationSource;
import org.n52.iceland.util.http.MediaType;

import com.google.common.collect.Maps;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 1.0.0
 */
public class BindingRepository extends AbstractComponentRepository<BindingKey, Binding, BindingFactory>
        implements ActivationManager<BindingKey>,
                   ActivationSource<BindingKey>,
                   Constructable {
    private static final Logger LOG = LoggerFactory.getLogger(BindingRepository.class);
    @Deprecated
    private static BindingRepository instance;

    private final ActivationListeners<BindingKey> activation = new ActivationListeners<>(true);

    private final Map<PathBindingKey, Producer<Binding>> byPath = Maps.newHashMap();
    private final Map<MediaTypeBindingKey, Producer<Binding>> byMediaType = Maps.newHashMap();
    private final Map<BindingKey, Producer<Binding>> bindings = Maps.newHashMap();

    private Collection<Binding> components;
    private Collection<BindingFactory> componentFactories;

    @Autowired(required = false)
    public void setComponentFactories(Collection<BindingFactory> componentFactories) {
        this.componentFactories = componentFactories;
    }

    @Autowired(required = false)
    public void setComponents(Collection<Binding> components) {
        this.components = components;
    }

    @Override
    public void registerListener(ActivationListener<BindingKey> listener) {
        this.activation.registerListener(listener);
    }

    @Override
    public void deregisterListener(ActivationListener<BindingKey> listener) {
        this.activation.deregisterListener(listener);
    }

    @Override
    public boolean isActive(BindingKey key) {
        return this.activation.isActive(key);
    }

    @Override
    public void activate(BindingKey key) {
        this.activation.activate(key);
    }

    @Override
    public void deactivate(BindingKey key) {
        this.activation.deactivate(key);
    }

    @Override
    public Set<BindingKey> getKeys() {
        return Collections.unmodifiableSet(this.bindings.keySet());
    }

    @Override
    public void setActive(BindingKey bk, boolean active) {
        this.activation.setActive(bk, active);
    }

    @Override
    public void init() {
        BindingRepository.instance = this;
        Map<BindingKey, Producer<Binding>> implementations
                = getUniqueProviders(this.components, this.componentFactories);
        this.bindings.clear();
        this.byMediaType.clear();
        this.byPath.clear();
        for (Entry<BindingKey, Producer<Binding>> entry : implementations.entrySet()) {
            BindingKey key = entry.getKey();
            Producer<Binding> binding = entry.getValue();
            this.bindings.put(key, binding);
            if (key instanceof MediaTypeBindingKey) {
                byMediaType.put((MediaTypeBindingKey) key, binding);
            } else if (key instanceof PathBindingKey) {
                byPath.put((PathBindingKey) key, binding);
            }
        }
        if (this.bindings.isEmpty()) {
            final StringBuilder exceptionText = new StringBuilder();
            exceptionText.append("No Binding implementation could be loaded! ");
            exceptionText.append("If the SOS is not used as webapp, this has no effect! ");
            exceptionText.append("Else add a Binding implementation!");
            LOG.warn(exceptionText.toString());
        }
    }

    public Binding getBinding(String urlPattern) {
        return getBinding(new PathBindingKey(urlPattern));
    }

    public Binding getBinding(MediaType mediaType) {
        return getBinding(new MediaTypeBindingKey(mediaType));
    }

    public Binding getBinding(BindingKey key) {
        Producer<Binding> binding = this.bindings.get(key);
        return binding == null ? null : binding.get();
    }

    public boolean isBindingSupported(String urlPattern) {
        return isActive(new PathBindingKey(urlPattern));
    }

    public boolean isBindingSupported(MediaType mediaType) {
        return isActive(new MediaTypeBindingKey(mediaType));
    }

    public boolean isBindingSupported(BindingKey key) {
        return isActive(key);
    }

    public boolean isActive(String urlPattern) {
        return isActive(new PathBindingKey(urlPattern));
    }

    public boolean isActive(MediaType mediaType) {
        return isActive(new MediaTypeBindingKey(mediaType));
    }

    public Map<BindingKey, Binding> getBindings() {
        Map<BindingKey, Producer<Binding>> actives
                = Activatables.activatedMap(this.bindings,
                                            this.activation);
        return Producers.produce(actives);
    }

    public Map<String, Binding> getBindingsByPath() {
        Map<String, Binding> map = new HashMap<>(this.byPath.size());
        for (Entry<PathBindingKey, Producer<Binding>> entry : this.byPath.entrySet()) {
            PathBindingKey key = entry.getKey();
            Producer<Binding> producer = entry.getValue();
            if (isActive(key)) {
                map.put(key.getPath(), producer.get());
            }
        }
        return map;
    }

    public Map<MediaType, Binding> getBindingsByMediaType() {
        Map<MediaType, Binding> map = new HashMap<>(this.byPath.size());
        for (Entry<MediaTypeBindingKey, Producer<Binding>> entry : this.byMediaType.entrySet()) {
            MediaTypeBindingKey key = entry.getKey();
            Producer<Binding> producer = entry.getValue();
            if (isActive(key)) {
                map.put(key.getMediaType(), producer.get());
            }
        }
        return map;
    }

    public Map<String, Binding> getAllBindingsByPath() {
        Map<String, Binding> map = new HashMap<>(this.byPath.size());
        for (Entry<PathBindingKey, Producer<Binding>> entry : this.byPath.entrySet()) {
            PathBindingKey key = entry.getKey();
            Producer<Binding> producer = entry.getValue();
            map.put(key.getPath(), producer.get());
        }
        return map;
    }

    public Map<MediaType, Binding> getAllBindingsByMediaType() {
        Map<MediaType, Binding> map = new HashMap<>(this.byPath.size());
        for (Entry<MediaTypeBindingKey, Producer<Binding>> entry : this.byMediaType.entrySet()) {
            MediaTypeBindingKey key = entry.getKey();
            Producer<Binding> producer = entry.getValue();
            map.put(key.getMediaType(), producer.get());
        }
        return map;
    }

    @Deprecated
    public static BindingRepository getInstance() {
        return BindingRepository.instance;
    }
}

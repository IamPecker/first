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
package org.n52.iceland.convert;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.util.Producer;

import com.google.common.collect.Sets;

/**
 *
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 4.0.0
 */
@SuppressWarnings("rawtypes")
public class ConverterRepository extends AbstractComponentRepository<ConverterKey, Converter<?, ?>, ConverterFactory> implements Constructable {
    @Deprecated
    private static ConverterRepository instance;

    private Collection<Converter<?, ?>> components;
    private Collection<ConverterFactory> componentFactories;

    private final Map<ConverterKey, Producer<Converter<?, ?>>> converter
            = new HashMap<>(0);

    @Autowired(required = false)
    public void setComponentFactories(Collection<ConverterFactory> componentFactories) {
        this.componentFactories = componentFactories;
    }

    @Autowired(required = false)
    public void setComponents(Collection<Converter<?, ?>> components) {
        this.components = components;
    }

    @Override
    public void init() {
        ConverterRepository.instance = this;
        // TODO check for encoder/decoder used by converter
        Map<ConverterKey, Producer<Converter<?, ?>>> implementations
                = getUniqueProviders(this.components, this.componentFactories);
        this.converter.clear();
        this.converter.putAll(implementations);
    }


    public <T, F> Converter<T, F> getConverter(final String fromNamespace, final String toNamespace) {
        return getConverter(new ConverterKey(fromNamespace, toNamespace));
    }

    @SuppressWarnings("unchecked")
    public <T, F> Converter<T, F> getConverter(final ConverterKey key) {
        Supplier<Converter<?, ?>> producer = converter.get(key);
        if (producer == null) {
            return null;
        }
        return (Converter<T, F>) producer.get();
    }

    /**
     * Get all namespaces for which a converter is available to convert from
     * requested format to default format
     *
     * @param toNamespace
     *                    Requested format
     *
     * @return Swt with all possible formats
     */
    public Set<String> getFromNamespaceConverterTo(final String toNamespace) {
        final Set<String> fromNamespaces = Sets.newHashSet();
        for (final ConverterKey converterKey : converter.keySet()) {
            if (toNamespace.equals(converterKey.getToNamespace())) {
                fromNamespaces.add(converterKey.getFromNamespace());
            }
        }
        return fromNamespaces;
    }

    /**
     * Checks if a converter is available to convert the stored object from the
     * default format to the requested format
     *
     * @param fromNamespace
     *                      Default format
     * @param toNamespace
     *                      Requested fromat
     *
     * @return If a converter is available
     */
    public boolean hasConverter(final String fromNamespace, final String toNamespace) {
        return hasConverter(new ConverterKey(fromNamespace, toNamespace));
    }

    public boolean hasConverter(ConverterKey key) {
        return this.converter.containsKey(key);
    }

    @Deprecated
    public static ConverterRepository getInstance() {
        return ConverterRepository.instance;
    }
}

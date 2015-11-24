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
package org.n52.iceland.coding.encode;


import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.util.ClassHelper;
import org.n52.iceland.util.CollectionHelper;
import org.n52.iceland.util.Comparables;
import org.n52.iceland.util.Producer;

import com.google.common.collect.Sets;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann <c.autermann@52north.org>
 * @author CarstenHollmann <c.hollmann@52north.org>
 *
 * @since 4.0.0
 */
public class ResponseWriterRepository extends AbstractComponentRepository<ResponseWriterKey, ResponseWriter<?>, ResponseWriterFactory> implements Constructable {

    private static ResponseWriterRepository instance;

    private final Map<ResponseWriterKey, Producer<ResponseWriter<?>>> writersByClass = CollectionHelper.synchronizedMap();

    @Autowired(required = false)
    private Collection<ResponseWriter<?>> components;

    @Autowired(required = false)
    private Collection<ResponseWriterFactory> componentFactories;

    @Override
    public void init() {
        ResponseWriterRepository.instance = this;
        Map<ResponseWriterKey, Producer<ResponseWriter<?>>> implementations
                = getUniqueProviders(this.components, this.componentFactories);
        this.writersByClass.clear();
        this.writersByClass.putAll(implementations);
    }

    @SuppressWarnings("unchecked")
    public <T> ResponseWriter<T> getWriter(final Class<? extends T> clazz) {
        ResponseWriterKey key = new ResponseWriterKey(clazz);
        if (!writersByClass.containsKey(key)) {
            Set<Class<?>> compatible = Sets.newHashSet();
            for (ResponseWriterKey c : writersByClass.keySet()) {
                if (ClassHelper.getSimiliarity(c.getType(), clazz) >= 0) {
                    compatible.add(c.getType());
                }
            }
            writersByClass.put(key, writersByClass.get(chooseWriter(compatible, clazz)));
        }
        return (ResponseWriter<T>) writersByClass.get(key).get();
    }

	private  ResponseWriterKey chooseWriter(Set<Class<?>> compatible, Class<?> clazz) {
        if (compatible.isEmpty()) {
            return null;
        }
        Comparator<Class<?>> comparator = new ClassSimilarityComparator(clazz);
        return new ResponseWriterKey(Collections.min(compatible, comparator));
    }

    @Deprecated
    public static ResponseWriterRepository getInstance() {
        return ResponseWriterRepository.instance;
    }

    private static class ClassSimilarityComparator implements Serializable, Comparator<Class<?>> {
        private static final long serialVersionUID = -377524541804891733L;
        private final Class<?> reference;

        ClassSimilarityComparator(Class<?> reference) {
            this.reference = reference;
        }

        @Override
        public int compare(Class<?> c1, Class<?> c2) {
            return Comparables.compare(ClassHelper.getSimiliarity(c1, reference),
                                       ClassHelper.getSimiliarity(c2, reference));
        }
    }
}

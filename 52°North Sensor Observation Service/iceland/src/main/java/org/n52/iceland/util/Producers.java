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
package org.n52.iceland.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Maps;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public class Producers {

    private Producers() {
    }

    public static <T> T produce(Producer<T> producer) {
        return producer == null ? null : producer.get();
    }

    public static <K, T> Map<K, T> produce(Map<K, Producer<T>> map) {
        return Maps.transformValues(map, Producers.<T>producingFunction());
    }

    public static <T> Collection<T> produce(Collection<Producer<T>> list) {
        return list.stream().map(Producers::produce).collect(Collectors.toList());
    }

    public static <T> List<T> produce(List<Producer<T>> list) {
        return list.stream().map(Producers::produce).collect(Collectors.toList());
    }

    public static <T> Set<T> produce(Set<Producer<T>> set) {
        return set.stream().map(Producers::produce).collect(Collectors.toSet());
    }

    public static <T> Producer<T> forInstance(T instance) {
        return new InstanceProducer<>(instance);
    }

    @SuppressWarnings("unchecked")
    public static <T> ProducingFunction<T> producingFunction() {
        return (ProducingFunction<T>) ProducingFunction.getInstance();
    }

    private static class ProducingFunction<T> implements
            Function<Producer<T>, T> {
        private static final ProducingFunction<?> instance
                = new ProducingFunction<>();

        @Override
        public T apply(Producer<T> t) {
            return produce(t);
        }

        public static ProducingFunction<?> getInstance() {
            return instance;
        }

    }

    private static class InstanceProducer<T> implements Producer<T> {
        private final T instance;

        InstanceProducer(T instance) {
            this.instance = instance;
        }

        @Override
        public T get() {
            return this.instance;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("instance", this.instance)
                    .toString();
        }

        public static <T> Producer<T> of(T instance) {
            return new InstanceProducer<>(instance);
        }
    }

}

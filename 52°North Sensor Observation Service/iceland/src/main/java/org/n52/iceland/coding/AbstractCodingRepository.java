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
package org.n52.iceland.coding;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.component.Component;
import org.n52.iceland.component.ComponentFactory;
import org.n52.iceland.util.CompositeSimilar;
import org.n52.iceland.util.Producer;
import org.n52.iceland.util.Producers;
import org.n52.iceland.util.ProxySimilarityComparator;
import org.n52.iceland.util.Similar;

import com.google.common.base.Joiner;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 * @param <K> the key type
 * @param <C> the component type
 * @param <F> the factory type
 */
public abstract class AbstractCodingRepository<K extends Similar<K>, C extends Component<K>, F extends ComponentFactory<K, C>>
        extends AbstractComponentRepository<K, C, F> {

    private static final Logger LOG = LoggerFactory
            .getLogger(AbstractCodingRepository.class);

    private final Set<Producer<C>> components = Sets.newHashSet();
    private final SetMultimap<K, Producer<C>> componentsByKey = HashMultimap.create();

    public Set<Producer<C>> getComponentProviders() {
        return Collections.unmodifiableSet(this.components);
    }

    public SetMultimap<K, Producer<C>> getComponentProvidersByKey() {
        return Multimaps.unmodifiableSetMultimap(componentsByKey);
    }

    protected void setProducers(SetMultimap<K, Producer<C>> implementations) {
        this.componentsByKey.clear();
        this.componentsByKey.putAll(implementations);
        this.components.clear();
        this.components.addAll(implementations.values());
    }

    protected C choose(Set<C> matches, K key) {
        if (matches == null || matches.isEmpty()) {
            LOG.debug("No implementation for {}", key);
            return null;
        } else if (matches.size() > 1) {
            return chooseFrom(matches, key);
        } else {
            return Iterables.getFirst(matches, null);
        }
    }

    private C chooseFrom(Set<C> matches, K key) {
        ComponentSimilarityComparator<K, C> comparator
                = new ComponentSimilarityComparator<>(key);
        C component = Collections.min(matches, comparator);
        LOG.debug("Requested ambiguous implementations for {}: Found {}; Choosing {}.",
                       key, Joiner.on(", ").join(matches), component);
        return component;
    }

    protected Set<C> findComponentForSingleKey(K key) {
        if (!this.componentsByKey.containsKey(key)) {
            Set<C> instances = Sets.newHashSet();
            for (Producer<C> producer : this.components) {
                C component = producer.get();
                for (K ckey : component.getKeys()) {
                    if (ckey.getSimilarity(key) >= 0) {
                        this.componentsByKey.put(key, producer);
                        instances.add(component);
                    }
                }
            }
            return instances;
        } else {
            return Producers.produce(componentsByKey.get(key));
        }
    }

    protected Set<C> findComponentsForCompositeKey(CompositeKey ck) {
        K key = ck.asKey();
        if (!this.componentsByKey.containsKey(key)) {
            Set<C> instances = Sets.newHashSet();
            for (Producer<C> producer : this.components) {
                C component = producer.get();
                if (ck.matches(component.getKeys())) {
                    this.componentsByKey.put(key, producer);
                    instances.add(component);
                }
            }
            LOG.debug("Found {} components for composite key: {}",
                      instances.size(), Joiner.on(", ").join(instances));
            return instances;
        } else {
            return Producers.produce(componentsByKey.get(key));
        }
    }

    protected Set<C> getComponents() {
        return Producers.produce(this.components);
    }

    @SafeVarargs
    protected final boolean hasComponent(K key, K... keys) {
        return getComponent(key, keys) != null;
    }

    protected C getComponentForSingleKey(K key) {
        return choose(findComponentForSingleKey(key), key);
    }

    protected C getComponentForCompositeKey(CompositeKey key) {
        return choose(findComponentsForCompositeKey(key), key.asKey());
    }

    @SafeVarargs
    protected final C getComponent(K key, K... keys) {
        if (keys.length == 0) {
            return getComponentForSingleKey(key);
        } else {
            return getComponentForCompositeKey(createCompositeKey(asList(key, keys)));
        }
    }

    protected abstract CompositeKey createCompositeKey(List<K> keys);

    private List<K> asList(K key, K[] keys) {
        return ImmutableList.<K>builder().add(key).add(keys).build();
    }

    private static class ComponentSimilarityComparator<K extends Similar<K>, C extends Component<K>>
            extends ProxySimilarityComparator<C, K> {
        ComponentSimilarityComparator(K key) {
            super(key);
        }

        @Override
        protected Collection<K> getSimilars(C t) {
            return t.getKeys();
        }

    }

    protected abstract class CompositeKey extends CompositeSimilar<K>{

        protected CompositeKey(Iterable<K> keys) {
            super(keys);
        }

        public abstract K asKey();

    }

}

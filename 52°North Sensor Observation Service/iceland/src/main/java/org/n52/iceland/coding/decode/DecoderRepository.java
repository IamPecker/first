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
package org.n52.iceland.coding.decode;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.coding.AbstractCodingRepository;
import org.n52.iceland.lifecycle.Constructable;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public class DecoderRepository
        extends AbstractCodingRepository<DecoderKey, Decoder<?, ?>, DecoderFactory> implements Constructable {

    @Autowired(required = false)
    private Collection<Decoder<?, ?>> decoders;
    @Autowired(required = false)
    private Collection<DecoderFactory> decoderFactories;

    @Override
    public void init() {
        setProducers(getProviders(decoders, decoderFactories));
    }

    public Set<Decoder<?, ?>> getDecoders() {
        return getComponents();
    }

    public boolean hasDecoder(DecoderKey key, DecoderKey... keys) {
        return hasComponent(key, keys);
    }

    @SuppressWarnings("unchecked")
    public <F, T> Decoder<F, T> getDecoder(DecoderKey key, DecoderKey... keys) {
        return (Decoder<F, T>) getComponent(key, keys);
    }

    @Override
    protected CompositeKey createCompositeKey(List<DecoderKey> keys) {
        return new CompositeDecoderKey(keys);
    }

    private class CompositeDecoderKey extends CompositeKey implements DecoderKey {
        CompositeDecoderKey(Iterable<DecoderKey> keys) {
            super(keys);
        }

        @Override
        public DecoderKey asKey() {
            return this;
        }
    }
}

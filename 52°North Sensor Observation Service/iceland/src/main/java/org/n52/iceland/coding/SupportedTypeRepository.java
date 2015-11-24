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

import java.util.Set;

import javax.inject.Inject;

import org.n52.iceland.coding.decode.Decoder;
import org.n52.iceland.coding.decode.DecoderRepository;
import org.n52.iceland.coding.encode.Encoder;
import org.n52.iceland.coding.encode.EncoderRepository;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.service.ServiceConstants.AbstractSupportedStringType;
import org.n52.iceland.service.ServiceConstants.FeatureType;
import org.n52.iceland.service.ServiceConstants.ObservationType;
import org.n52.iceland.service.ServiceConstants.SupportedType;
import org.n52.iceland.util.activation.Activatable;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public class SupportedTypeRepository implements Constructable {
    @Deprecated
    private static SupportedTypeRepository instance;
    private final Set<Activatable<SupportedType>> supportedTypes = Sets.newHashSet();
    private final SetMultimap<Class<? extends SupportedType>, Set<Activatable<SupportedType>>> typeMap = HashMultimap.create();
    private final LoadingCache<Class<? extends SupportedType>, Set<Activatable<SupportedType>>> cache;

    private EncoderRepository encoderRepository;
    private DecoderRepository decoderRepository;

    public SupportedTypeRepository() {
        this.cache = CacheBuilder.newBuilder().build(new CacheLoaderImpl());
    }

    @Inject
    public void setEncoderRepository(EncoderRepository encoderRepository) {
        this.encoderRepository = encoderRepository;
    }

    @Inject
    public void setDecoderRepository(DecoderRepository decoderRepository) {
        this.decoderRepository = decoderRepository;
    }

    @Override
    public void init() {
        SupportedTypeRepository.instance = this;
        this.supportedTypes.clear();

        for (Decoder<?, ?> decoder : this.decoderRepository.getDecoders()) {
            Set<SupportedType> set = decoder.getSupportedTypes();
            if (set != null) {
                this.supportedTypes.addAll(Activatable.from(set));
            }
        }

        for (Encoder<?, ?> encoder : this.encoderRepository.getEncoders()) {
            Set<SupportedType> set = encoder.getSupportedTypes();
            if (set != null) {
                this.supportedTypes.addAll(Activatable.from(set));
            }
        }
    }

    private Set<? extends SupportedType> typesFor(Class<? extends SupportedType> key) {
        return Activatable.filter(this.cache.getUnchecked(key));
    }

    @SuppressWarnings("unchecked")
    public Set<ObservationType> getFeatureOfInterestTypes() {
        return (Set<ObservationType>) typesFor(FeatureType.class);
    }

    @SuppressWarnings("unchecked")
    public Set<String> getFeatureOfInterestTypesAsString() {
        return getSupportedTypeAsString((Set<AbstractSupportedStringType>)
                typesFor(FeatureType.class));
    }

    @SuppressWarnings("unchecked")
    public Set<ObservationType> getObservationTypes() {
        return (Set<ObservationType>) typesFor(ObservationType.class);
    }
    @SuppressWarnings("unchecked")
    public Set<String> getObservationTypesAsString() {
        return getSupportedTypeAsString((Set<AbstractSupportedStringType>)
                typesFor(ObservationType.class));
    }

    private Set<String> getSupportedTypeAsString(
            Set<? extends AbstractSupportedStringType> types) {
        Set<String> strings = Sets.newHashSetWithExpectedSize(types.size());
        for (AbstractSupportedStringType type : types) {
            strings.add(type.getValue());
        }
        return strings;
    }

    @Deprecated
    public static SupportedTypeRepository getInstance() {
        return instance;
    }

    private class CacheLoaderImpl extends CacheLoader<Class<? extends SupportedType>, Set<Activatable<SupportedType>>> {
        @Override
        public Set<Activatable<SupportedType>> load( Class<? extends SupportedType> key){
            Set<Activatable<SupportedType>> set = Sets.newHashSet();
            for (Activatable<SupportedType> activatable : supportedTypes) {
                if (activatable.getInternal().getClass().isAssignableFrom(key)) {
                    set.add(activatable);
                }
            }
            return set;
        }
    }
}

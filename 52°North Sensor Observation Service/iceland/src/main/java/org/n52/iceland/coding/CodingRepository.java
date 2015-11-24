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

import org.n52.iceland.coding.encode.SchemaRepository;
import org.n52.iceland.coding.encode.EncoderRepository;
import org.n52.iceland.coding.decode.DecoderRepository;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.n52.iceland.coding.decode.Decoder;
import org.n52.iceland.coding.decode.DecoderKey;
import org.n52.iceland.coding.encode.Encoder;
import org.n52.iceland.coding.encode.EncoderKey;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.w3c.SchemaLocation;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 4.0.0
 * @see EncoderRepository
 * @see DecoderRepository
 */
@Deprecated
public class CodingRepository implements Constructable {

    @Deprecated
    private static CodingRepository instance;
    private EncoderRepository encoderRepository;
    private DecoderRepository decoderRepository;
    private SchemaRepository schemaRepository;

    @Inject
    public void setEncoderRepository(EncoderRepository encoderRepository) {
        this.encoderRepository = encoderRepository;
    }

    @Inject
    public void setDecoderRepository(DecoderRepository decoderRepository) {
        this.decoderRepository = decoderRepository;
    }

    @Inject
    public void setSchemaRepository(SchemaRepository schemaRepository) {
        this.schemaRepository = schemaRepository;
    }

    @Override
    public void init() {
        CodingRepository.instance = this;
    }

    @Deprecated
    public Set<Decoder<?, ?>> getDecoders() {
        return this.decoderRepository.getDecoders();
    }

    @Deprecated
    public Set<Encoder<?, ?>> getEncoders() {
        return this.encoderRepository.getEncoders();
    }

    @Deprecated
    public Map<DecoderKey, Set<Decoder<?, ?>>> getDecoderByKey() {
        return Collections.emptyMap();
    }

    @Deprecated
    public Map<EncoderKey, Set<Encoder<?, ?>>> getEncoderByKey() {
        return Collections.emptyMap();
    }

    @Deprecated
    public boolean hasDecoder(DecoderKey key, DecoderKey... keys) {
        return this.decoderRepository.hasDecoder(key, keys);
    }

    @Deprecated
    public <F, T> Decoder<F, T> getDecoder(DecoderKey key, DecoderKey... keys) {
        return this.decoderRepository.getDecoder(key, keys);
    }

    @Deprecated
    public boolean hasEncoder(EncoderKey key, EncoderKey... keys) {
        return this.encoderRepository.hasEncoder(key, keys);
    }

    @Deprecated
    public <F, T> Encoder<F, T> getEncoder(EncoderKey key, EncoderKey... keys) {
        return this.encoderRepository.getEncoder(key, keys);
    }

    @Deprecated
    public Set<SchemaLocation> getSchemaLocation(String namespace) {
        return this.schemaRepository.getSchemaLocation(namespace);
    }

    @Deprecated
    public String getNamespaceFor(String prefix) {
        return this.schemaRepository.getNamespaceFor(prefix);
    }

    @Deprecated
    public String getPrefixFor(String namespace) {
        return this.schemaRepository.getPrefixFor(namespace);
    }

    @Deprecated
    public static CodingRepository getInstance() {
        return CodingRepository.instance;
    }
}

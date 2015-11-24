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


import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.w3c.SchemaLocation;

import com.google.common.collect.Maps;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public class SchemaRepository implements Constructable {
    @Deprecated
    private static SchemaRepository instance;

    private final Map<String, Set<SchemaLocation>> schemaLocations = Maps.newHashMap();
    private EncoderRepository encoderRepository;

    @Inject
    public void setEncoderRepository(EncoderRepository encoderRepository) {
        this.encoderRepository = encoderRepository;
    }

    @Deprecated
    public static SchemaRepository getInstance() {
        return instance;
    }

    @Override
    public void init() {
        SchemaRepository.instance = this;
        this.schemaLocations.clear();
        for (Encoder<?, ?> encoder : this.encoderRepository.getEncoders()) {
            for (EncoderKey key : encoder.getKeys()) {
                if (key instanceof XmlEncoderKey) {
                    Set<SchemaLocation> locations = encoder.getSchemaLocations();
                    if (locations != null && !locations.isEmpty()) {
                        String namespace = ((XmlEncoderKey) key).getNamespace();
                        this.schemaLocations.put(namespace, locations);
                    }
                }
            }
        }
    }

     public Set<SchemaLocation> getSchemaLocation(String namespace) {
        if (this.schemaLocations.containsKey(namespace)) {
            return this.schemaLocations.get(namespace);
        }
        return Collections.emptySet();
    }

    public String getNamespaceFor(String prefix) {
        Map<String, String> prefixNamspaceMap = getPrefixNamspaceMap();
        for (String namespace : prefixNamspaceMap.keySet()) {
            if (prefix.equals(prefixNamspaceMap.get(prefix))) {
                return namespace;
            }
        }
        return null;
    }

    public String getPrefixFor(String namespace) {
        return getPrefixNamspaceMap().get(namespace);
    }

    private Map<String, String> getPrefixNamspaceMap() {
        Map<String, String> prefixMap = Maps.newHashMap();
        for (Encoder<?, ?> encoder : this.encoderRepository.getEncoders()) {
            encoder.addNamespacePrefixToMap(prefixMap);
        }
        return prefixMap;
    }

}

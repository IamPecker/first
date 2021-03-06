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

import java.util.Collections;
import java.util.Set;

import org.n52.iceland.util.http.MediaType;
import org.n52.iceland.util.http.MediaTypes;

import com.google.common.collect.ImmutableSet;

public class TestXmlBinding extends AbstractXmlBinding {

    private static final PathBindingKey PATH_KEY
            = new PathBindingKey("/sos/test");
    private static final MediaTypeBindingKey MEDIA_TYPE_KEY
            = new MediaTypeBindingKey(MediaTypes.APPLICATION_XML);
    private static final ImmutableSet<BindingKey> KEYS
            = ImmutableSet.of(PATH_KEY, MEDIA_TYPE_KEY);

    @Override
    protected boolean isUseHttpResponseCodes() {
        return false;
    }

    @Override
    public Set<BindingKey> getKeys() {
        return Collections.unmodifiableSet(KEYS);
    }

    @Override
    public Set<String> getConformanceClasses(String service, String version) {
        return Collections.emptySet();
    }

    @Override
    protected MediaType getDefaultContentType() {
        return MEDIA_TYPE_KEY.getMediaType();
    }

    @Override
    public String getUrlPattern() {
        return PATH_KEY.getPath();
    }

}

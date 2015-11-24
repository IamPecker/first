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
package org.n52.iceland.response;

import org.n52.iceland.ogc.ows.Extension;
import org.n52.iceland.ogc.ows.Extensions;
import org.n52.iceland.ogc.ows.OWSConstants.HasExtension;
import org.n52.iceland.service.AbstractServiceCommunicationObject;
import org.n52.iceland.util.http.MediaType;

/**
 * abstract super class for all service request classes
 *
 * @since 1.0.0
 */
public abstract class AbstractServiceResponse
        extends AbstractServiceCommunicationObject
        implements HasExtension<AbstractServiceResponse> {

    private MediaType contentType;

    private Extensions extensions;

    @Override
    public Extensions getExtensions() {
        return extensions;
    }

    @Override
    public AbstractServiceResponse setExtensions(final Extensions extensions) {
        this.extensions = extensions;
        return this;
    }

    @Override
    public AbstractServiceResponse addExtensions(final Extensions extensions) {
        if (getExtensions() == null) {
            setExtensions(extensions);
        } else {
            getExtensions().addExtension(extensions.getExtensions());
        }
        return this;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public AbstractServiceResponse addExtension(final Extension extension) {
        if (getExtensions() == null) {
            setExtensions(new Extensions());
        }
        getExtensions().addExtension(extension);
        return this;
    }

    @Override
    public boolean isSetExtensions() {
        return extensions != null && !extensions.isEmpty();
    }

    public AbstractServiceResponse setContentType(MediaType contentType) {
        this.contentType = contentType;
        return this;
    }

    public MediaType getContentType() {
        return this.contentType;
    }

    public boolean isSetContentType() {
        return getContentType() != null;
    }

}

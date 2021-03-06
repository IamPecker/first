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
package org.n52.iceland.ogc.gml;

import java.io.Serializable;

import org.n52.iceland.util.StringHelper;

/**
 * Abstract class for encoding the feature of interest. Necessary because
 * different feature types should be supported. The SOS database or another
 * feature source (e.g. WFS) should provide information about the application
 * schema.
 * 
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 * 
 */
public abstract class AbstractFeature extends AbstractGML implements Serializable {

    /**
     * serial number
     */
    private static final long serialVersionUID = -6117378246552782214L;
    
    private String defaultEncoding;
    
    /**
     * constructor
     */
    public AbstractFeature() {
        super();
    }

    /**
     * constructor
     */
    public AbstractFeature(String identifier) {
        super(identifier);
    }

    /**
     * constructor
     * 
     * @param featureIdentifier
     *            Feature identifier
     */
    public AbstractFeature(CodeWithAuthority featureIdentifier) {
        super(featureIdentifier);
    }

    /**
     * constructor
     * 
     * @param featureIdentifier
     *            Feature identifier
     * @param gmlId
     *            GML id
     */
    public AbstractFeature(CodeWithAuthority featureIdentifier, String gmlId) {
        super(featureIdentifier, gmlId);
    }
    
    public void copyTo(AbstractFeature copyOf) {
        super.copyTo(copyOf);
    }
    
    public AbstractFeature setDefaultElementEncoding(String defaultEncoding) {
    	this.defaultEncoding = defaultEncoding;
    	return this;
    }

    public String getDefaultElementEncoding() {
    	return defaultEncoding;
    }
    
    public boolean isSetDefaultElementEncoding() {
    	return StringHelper.isNotEmpty(getDefaultElementEncoding());
    }

}

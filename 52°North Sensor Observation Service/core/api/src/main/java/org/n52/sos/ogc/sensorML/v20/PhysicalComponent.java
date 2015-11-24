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
package org.n52.sos.ogc.sensorML.v20;

import org.n52.sos.ogc.sensorML.HasProcessMethod;
import org.n52.sos.ogc.sensorML.ProcessMethod;
import org.n52.sos.util.JavaHelper;

/**
 * Class that represents SensorML 2.0 PhysicalComponent
 * 
 * @author Carsten Hollmann <c.hollmann@52north.org>
 * @since 4.2.0
 *
 */
public class PhysicalComponent extends AbstractPhysicalProcess implements HasProcessMethod {

    private static final long serialVersionUID = 5935212001491183960L;
    
    public static final String ID_PREFIX = "pc_";

    private ProcessMethod method;
    
    public PhysicalComponent() {
        setGmlId(ID_PREFIX + JavaHelper.generateID(ID_PREFIX));
    }

    @Override
    public ProcessMethod getMethod() {
        return method;
    }

    @Override
    public void setMethod(ProcessMethod method) {
      this.method = method;
    }

    @Override
    public boolean isSetMethod() {
        return getMethod() != null;
    }

}

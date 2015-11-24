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
package org.n52.iceland.convert;

/**
 * Defines the types of modification the {@link RequestResponseModifier}
 * performs
 * 
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public class RequestResponseModifierFacilitator {

    private boolean merger = false;

    private boolean splitter = false;

    private boolean adderRemover = false;

    /**
     * @param merger
     * @return this
     */
    public RequestResponseModifierFacilitator setMerger(boolean merger) {
        this.merger = merger;
        return this;
    }

    /**
     * @return <code>true</code>, if the {@link RequestResponseModifier} merges
     *         values, e.g. observations
     */
    public boolean isMerger() {
        return merger;
    }

    /**
     * @param splitter
     * @return this
     */
    public RequestResponseModifierFacilitator setSplitter(boolean splitter) {
        this.splitter = splitter;
        return this;
    }

    /**
     * @return <code>true</code>, if the {@link RequestResponseModifier} splits
     *         values, e.g. SweDataArray observaiton into single observations
     */
    public boolean isSplitter() {
        return splitter;
    }

    /**
     * @param adderRemover
     * @return this
     */
    public RequestResponseModifierFacilitator setAdderRemover(boolean adderRemover) {
        this.adderRemover = adderRemover;
        return this;
    }

    /**
     * @return <code>true</code>, if the {@link RequestResponseModifier}
     *         adds/removes values, e.g. add/remove prefixes to identifier
     */
    public boolean isAdderRemover() {
        return adderRemover;
    }

}

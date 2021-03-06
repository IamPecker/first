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
package org.n52.iceland.service;

import java.util.Objects;

import com.google.common.base.MoreObjects;

/**
 * @since 4.0.0
 *
 */
public interface ServiceConstants {

    interface SupportedType {

    }

    abstract class AbstractSupportedStringType implements SupportedType {
        private final String value;

        public AbstractSupportedStringType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AbstractSupportedStringType that = (AbstractSupportedStringType) obj;
            return Objects.equals(this.getValue(), that.getValue());
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("value", getValue())
                    .toString();
        }

    }

    class FeatureType extends AbstractSupportedStringType{
        public FeatureType(String value) {
            super(value);
        }
    }

    class ObservationType extends AbstractSupportedStringType {
        public ObservationType(String value) {
            super(value);
        }
    }

    class ProcedureDescriptionFormat extends AbstractSupportedStringType {
        public ProcedureDescriptionFormat(String value) {
            super(value);
        }
    }

    class SweType extends AbstractSupportedStringType {
        public SweType(String value) {
            super(value);
        }
    }
}

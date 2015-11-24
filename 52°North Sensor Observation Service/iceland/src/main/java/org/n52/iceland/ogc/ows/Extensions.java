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
package org.n52.iceland.ogc.ows;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.n52.iceland.util.StringHelper;

public class Extensions {

    private final Set<Extension<?>> extensions = new HashSet<>();

    public Extensions() {

    }

    /**
     * @param extensionName
     *
     * @return <b><tt>true</tt></b>, only if the extension with the definition
     *         <tt>extensionName</tt> is holding a {@link Boolean} and is set to
     *         <tt>true</tt>.
     */
    @SuppressWarnings("rawtypes")
    public boolean isBooleanExtensionSet(final String extensionName) {
        for (final Extension<?> extension : getExtensions()) {
            if (isExtensionNameEquals(extensionName, (Extension<?>)extension)) {
                final Object value = extension.getValue();
                if (value instanceof Boolean) {
                    return (Boolean)value;
                } else if (value instanceof Value && ((Value)value).getValue() instanceof Boolean) {
                    return (Boolean) ((Value)value).getValue();
                }
                return false;
            }
        }
        return false;
    }
  public boolean addExtension(Extensions extensions) {
       return addExtension(extensions.getExtensions());
    }

    public boolean addExtension(Collection<Extension<?>> extensions) {
       return getExtensions().addAll(extensions);
    }

    public boolean addExtension(Extension<?> extensions) {
        return getExtensions().add(extensions);
    }

    public Set<Extension<?>> getExtensions() {
        return extensions;
    }

    @SuppressWarnings("rawtypes")
    public boolean containsExtension(Enum identifier) {
        return containsExtension(identifier.name());
    }

    public boolean containsExtension(String identifier) {
        return this.extensions.stream()
                .filter(e -> isExtensionNameEquals(identifier, e))
                .findAny().isPresent();
    }

    @SuppressWarnings("rawtypes")
    public Extension<?> getExtension(Enum identifier) {
        return getExtension(identifier.name());
    }

    public Extension<?> getExtension(String identifier) {
        return this.extensions.stream()
                .filter(e -> isExtensionNameEquals(identifier, e))
                .findFirst().orElse(null);
    }

    public boolean isEmpty() {
        return getExtensions().isEmpty();
    }

    @Override
    public String toString() {
        return String.format("Extensions [extensions=%s]", getExtensions());
    }

    protected boolean isExtensionNameEquals(final String extensionName, final Extension<?> swesExtension) {
        return checkExtensionDefinition(extensionName, swesExtension)
                || checkExtensionIdentifier(extensionName, swesExtension)
                || checkSweExtensionValue(extensionName, swesExtension);
    }

    private boolean checkSweExtensionValue(String extensionName, Extension<?> extension) {
            return (extension.isSetDefinition() && extension.getDefinition()
                    .equalsIgnoreCase(extensionName))
                    || (extension.isSetIdentifier() && extension.getIdentifier()
                            .equalsIgnoreCase(extensionName));
    }

    private boolean checkExtensionIdentifier(String extensionName, Extension<?> extension) {
        if (StringHelper.isNotEmpty(extensionName)) {
            return extension.isSetIdentifier() && extension.getIdentifier().equalsIgnoreCase(extensionName);
        }
        return false;
    }

    private boolean checkExtensionDefinition(String extensionName, Extension<?> extension) {
        if (extensionName != null && extension != null) {
            return extension.isSetDefinition() && extension.getDefinition().equalsIgnoreCase(extensionName);
        }
        return false;
    }

}

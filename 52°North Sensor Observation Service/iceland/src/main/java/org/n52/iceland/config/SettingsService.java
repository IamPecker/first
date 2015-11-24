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
package org.n52.iceland.config;

import java.util.Map;
import java.util.Set;

import org.n52.iceland.config.annotation.Configurable;
import org.n52.iceland.config.annotation.Setting;
import org.n52.iceland.exception.ConfigurationError;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public interface SettingsService {

    /**
     * Changes a setting. The change is propagated to all Objects that are
     * configured. If the change fails for one of these objects, the setting is
     * reverted to the old value of the setting for all objects.
     *
     * @param newValue
     *                 the new value of the setting
     *
     * @throws ConfigurationError
     *                                if there is a problem changing the setting.
     */
    void changeSetting(SettingValue<?> newValue)
            throws ConfigurationError;

    /**
     * Configure {@code o} with the required settings. All changes to a setting
     * required by the object will be applied.
     *
     * @param object
     *               the object to configure
     *
     * @throws ConfigurationError
     *                                if there is a problem configuring the object
     * @see Configurable
     * @see Setting
     */
    void configure(Object object)
            throws ConfigurationError;

    /**
     * Deletes all settings and users.
     */
    void deleteAll();

    /**
     * Deletes the setting defined by {@code setting}.
     *
     * @param setting
     *                the definition
     *
     * @throws ConfigurationError
     *                                if there is a problem deleting the setting
     */
    void deleteSetting(SettingDefinition<?, ?> setting)
            throws ConfigurationError;

    /**
     * Get the definition that is defined with the specified key.
     *
     * @param key
     *            the key
     *
     * @return the definition or {@code null} if there is no definition for the
     *         key
     */
    SettingDefinition<?, ?> getDefinitionByKey(String key);

    /**
     * @return the keys for all definitions
     */
    Set<String> getKeys();

    /**
     * Gets the value of the setting defined by {@code key}.
     *
     * @param <T>
     *            the type of the setting and value
     * @param key
     *            the definition of the setting
     *
     * @return the value of the setting
     */
    @SuppressWarnings(value = "unchecked")
    <T> SettingValue<T> getSetting(SettingDefinition<?, T> key);

    /**
     * Gets the value of the setting defined by {@code key}.
     *
     * @param <T>
     *            the type of the setting and value
     * @param key
     *            the id of the setting
     *
     * @return the value of the setting
     */
    @SuppressWarnings(value = "unchecked")
    <T> SettingValue<T> getSetting(String key);

    /**
     * Gets all {@code SettingDefinition}s known by this class.
     *
     * @return the definitions
     */
    Set<SettingDefinition<?, ?>> getSettingDefinitions();

    /**
     * @return the {@link SettingValueFactory} to produce values
     */
    SettingValueFactory getSettingFactory();

    /**
     * Gets all values for all definitions. If there is no value for a
     * definition {@code null} is added to the map.
     *
     * @return all values by definition
     */
    Map<SettingDefinition<?, ?>, SettingValue<?>> getSettings();

}

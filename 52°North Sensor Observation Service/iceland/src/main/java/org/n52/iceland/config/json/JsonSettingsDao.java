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
package org.n52.iceland.config.json;


import java.util.HashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;

import org.n52.iceland.config.SettingType;
import org.n52.iceland.config.SettingValue;
import org.n52.iceland.config.SettingsDao;
import org.n52.iceland.i18n.LocaleHelper;
import org.n52.iceland.i18n.MultilingualString;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 *
 * @author Christian Autermann
 */
public class JsonSettingsDao extends AbstractJsonDao
        implements SettingsDao {
    private JsonSettingsEncoder settingsEncoder;
    private JsonSettingValueFactory settingValueFactory;

    @Inject
    public void setSettingValueFactory(JsonSettingValueFactory settingValueFactory) {
        this.settingValueFactory = settingValueFactory;
    }

    @Inject
    public void setSettingsEncoder(JsonSettingsEncoder settingsEncoder) {
        this.settingsEncoder = settingsEncoder;
    }

    protected JsonSettingsEncoder getSettingsEncoder() {
        return this.settingsEncoder;
    }

    @Override
    public Set<SettingValue<?>> getSettingValues() {
        readLock().lock();
        try {
            JsonNode node = getConfiguration().path(JsonConstants.SETTINGS);
            Set<SettingValue<?>> values = new HashSet<>(node.size());
            node.fieldNames().forEachRemaining(key -> values.add(createSettingValue(key, node.path(key))));
            return values;
        } finally {
            readLock().unlock();
        }
    }

    @Override
    public SettingValue<?> getSettingValue(String key) {
        readLock().lock();
        try {
            JsonNode node = getConfiguration().path(JsonConstants.SETTINGS).path(key);
            if (!node.isObject()) { return null; }
            return createSettingValue(key, node);
        } finally {
            readLock().unlock();
        }
    }

    @Override
    public void deleteSettingValue(String key) {
        writeLock().lock();
        try {
            getConfiguration().with(JsonConstants.SETTINGS).remove(key);
        } finally {
            writeLock().unlock();
        }
        configuration().scheduleWrite();
    }

    @Override
    public void saveSettingValue(SettingValue<?> value) {
        writeLock().lock();
        try {
            ObjectNode settings = getConfiguration().with(JsonConstants.SETTINGS);
            JsonNode node = settings.path(value.getKey());
            ObjectNode settingNode = (ObjectNode) Optional.ofNullable(node.isObject() ? node : null)
                    .orElseGet(()-> settings.putObject(value.getKey()));
            settingNode.put(JsonConstants.TYPE, value.getType().toString());
            settingNode.set(JsonConstants.VALUE, this.settingsEncoder.encodeValue(value));
        } finally {
            writeLock().unlock();
        }
        configuration().scheduleWrite();
    }

    @Override
    public void deleteAll() {
        this.configuration().delete();
    }

    protected SettingValue<?> createSettingValue(String key, JsonNode node) {
        SettingType type = SettingType.fromString(node.path(JsonConstants.TYPE).asText(null));
        Object value = decodeValue(type, node.path(JsonConstants.VALUE));
        return new JsonSettingValue<>(type).setKey(key).setValue(value);
    }

    protected Object decodeValue(SettingType type, JsonNode node) {
        switch (type) {
            case INTEGER:
                return node.intValue();
            case NUMERIC:
                return node.doubleValue();
            case BOOLEAN:
                return node.booleanValue();
            case TIMEINSTANT:
                return this.settingValueFactory.parseTimeInstant(node.textValue());
            case FILE:
                return this.settingValueFactory.parseFile(node.textValue());
            case STRING:
                return node.textValue();
            case URI:
                return this.settingValueFactory.parseUri(node.textValue());
            case MULTILINGUAL_STRING:
                return decodeMultilingualString(node);
            case CHOICE:
                return node.textValue();
            default:
                throw new IllegalArgumentException(String.format("Unknown Type %s", type));
        }
    }

    protected MultilingualString decodeMultilingualString(JsonNode json) {
        MultilingualString mls = new MultilingualString();
        json.fields().forEachRemaining(e -> {
            Locale locale = LocaleHelper.fromString(e.getKey());
            mls.addLocalization(locale, e.getValue().asText());
        });
        return mls;
    }

}

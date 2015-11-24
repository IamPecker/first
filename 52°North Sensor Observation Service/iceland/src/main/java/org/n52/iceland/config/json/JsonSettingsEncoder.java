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

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import org.n52.iceland.config.SettingDefinition;
import org.n52.iceland.config.SettingDefinitionGroup;
import org.n52.iceland.config.SettingType;
import org.n52.iceland.config.SettingValue;
import org.n52.iceland.config.settings.ChoiceSettingDefinition;
import org.n52.iceland.config.settings.IntegerSettingDefinition;
import org.n52.iceland.ds.Datasource;
import org.n52.iceland.i18n.MultilingualString;
import org.n52.iceland.i18n.json.I18NJsonEncoder;
import org.n52.iceland.ogc.gml.time.TimeInstant;
import org.n52.iceland.util.DateTimeHelper;
import org.n52.iceland.util.JSONUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;


public class JsonSettingsEncoder {
    private final JsonNodeFactory nodeFactory = JSONUtils.nodeFactory();

    public Map<SettingDefinitionGroup, Set<SettingDefinition<?, ?>>> sortByGroup(Set<SettingDefinition<?, ?>> defs) {
        return defs.stream().collect(groupingBy(def -> def.getGroup(Datasource.ADVANCED_GROUP), toSet()));
    }

    public ObjectNode encode(Map<SettingDefinitionGroup, Set<SettingDefinition<?,?>>> grouped) {
        ObjectNode json = nodeFactory.objectNode();
        ArrayNode sections = json.putArray(JsonConstants.SECTIONS_KEY);
        grouped.keySet().stream().sorted().forEach(group -> {
            ObjectNode jgroup = sections.addObject();
            jgroup.put(JsonConstants.TITLE_KEY, group.getTitle());
            jgroup.put(JsonConstants.DESCRIPTION_KEY, group.getDescription());
            jgroup.set(JsonConstants.SETTINGS_KEY, encode(grouped.get(group)));
        });
        return json;
    }

    public ObjectNode encode(Set<SettingDefinition<?,?>> settings) {
        return settings.stream().sorted()
                .collect(nodeFactory::objectNode,
                         (j, def) -> j.set(def.getKey(), encode(def)),
                         ObjectNode::setAll);
    }

    public ObjectNode encode(SettingDefinition<?,?> def) {
        ObjectNode j = nodeFactory.objectNode();
        j.put(JsonConstants.TITLE_KEY, def.getTitle());
        j.put(JsonConstants.DESCRIPTION_KEY, def.getDescription());
        j.put(JsonConstants.TYPE_KEY, getType(def));
        j.put(JsonConstants.REQUIRED_KEY, !def.isOptional());
        j.set(JsonConstants.DEFAULT, def.hasDefaultValue() ?
                                     encodeDefaultValue(def): null);

        if (def instanceof IntegerSettingDefinition) {
            IntegerSettingDefinition iDef = (IntegerSettingDefinition) def;
            if (iDef.hasMinimum()) {
                j.put(JsonConstants.MINIMUM_KEY, iDef.getMinimum());
                j.put(JsonConstants.MINIMUM_EXCLUSIVE_KEY, iDef.isExclusiveMinimum());
            }
            if (iDef.hasMaximum()) {
                j.put(JsonConstants.MAXIMUM_KEY, iDef.getMaximum());
                j.put(JsonConstants.MAXIMUM_EXCLUSIVE_KEY, iDef.isExclusiveMaximum());
            }
        }

        if (def instanceof ChoiceSettingDefinition) {
            ChoiceSettingDefinition cDef = (ChoiceSettingDefinition) def;
            ObjectNode options = j.putObject(JsonConstants.OPTIONS_KEY);
            cDef.getOptions().entrySet().forEach(o -> options.put(o.getKey(), o.getValue()));
        }
        return j;
    }

    protected String getType(SettingDefinition<?,?> def) {
        return getType(def.getType());
    }

    protected String getType(SettingType type)
            throws IllegalArgumentException {
        switch (type) {
            case INTEGER:
                return JsonConstants.INTEGER_TYPE;
            case NUMERIC:
                return JsonConstants.NUMBER_TYPE;
            case BOOLEAN:
                return JsonConstants.BOOLEAN_TYPE;
            case TIMEINSTANT:
                return JsonConstants.STRING_TYPE;
            case FILE:
                return JsonConstants.STRING_TYPE;
            case STRING:
                return JsonConstants.STRING_TYPE;
            case URI:
                return JsonConstants.STRING_TYPE;
            case MULTILINGUAL_STRING:
                return JsonConstants.MULTILINGUAL_TYPE;
            case CHOICE:
                return JsonConstants.CHOICE_TYPE;
            default:
                throw new IllegalArgumentException(String.format("Unknown Type %s", type));
        }
    }

    public JsonNode encodeDefaultValue(SettingDefinition<?,?> def) {
        if (def == null) {
            return nodeFactory.nullNode();
        }
        return encodeValue(def.getType(), def.getDefaultValue());
    }

    public JsonNode encodeValue(SettingValue<?> def) {
        if (def == null) {
            return nodeFactory.nullNode();
        }
        return encodeValue(def.getType(), def.getValue());
    }

    public JsonNode encodeValue(SettingType type, Object value) {
        if (value == null) {
            return nodeFactory.nullNode();
        }
        switch (type) {
            case TIMEINSTANT:
                return textNode(DateTimeHelper.format((TimeInstant) value));
            case FILE:
                return textNode(value);
            case URI:
                return textNode(value);
            case CHOICE:
                return textNode(value);
            case STRING:
                return textNode(value);
            case BOOLEAN:
                return nodeFactory.booleanNode((Boolean) value);
            case INTEGER:
                return nodeFactory.numberNode((Integer) value);
            case NUMERIC:
                return nodeFactory.numberNode((Double) value);
            case MULTILINGUAL_STRING:
                return new I18NJsonEncoder().encode((MultilingualString) value);
            default:
                throw new IllegalArgumentException(String.format("Unknown Type %s", type));
        }
    }

    public JsonNode encodeValues(Map<SettingDefinition<?, ?>, SettingValue<?>> settings) {
        return settings.entrySet().stream()
                .sorted(delegatedComparator(Entry::getKey))
                .collect(nodeFactory::objectNode,
                         (o, e) -> {
                             SettingDefinition<?, ?> def = e.getKey();
                             Object value = Optional.ofNullable(e.getValue())
                                    .map(v -> (Object) v.getValue())
                                    .orElseGet(def::getDefaultValue);
                             o.set(def.getKey(), encodeValue(def.getType(), value));
                         },
                         ObjectNode::setAll);
    }

    private TextNode textNode(Object value) {
        return nodeFactory.textNode(String.valueOf(value));
    }

    private static <T, C extends Comparable<C>> Comparator<T> delegatedComparator(Function<T, C> supplier) {
        return (t1, t2) -> supplier.apply(t1).compareTo(supplier.apply(t2));
    }
}

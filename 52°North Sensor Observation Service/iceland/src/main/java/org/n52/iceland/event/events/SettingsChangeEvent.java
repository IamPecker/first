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
package org.n52.iceland.event.events;

import org.n52.iceland.config.SettingDefinition;
import org.n52.iceland.config.SettingValue;
import org.n52.iceland.event.ServiceEvent;

/**
 * This event is fired if the {@link SettingValue} of a
 * {@link SettingDefinition} has been changed or a {@link SettingDefinition} was
 * deleted.
 * 
 * @author Christian Autermann <c.autermann@52north.org>
 * 
 * @since 1.0.0
 */
public class SettingsChangeEvent implements ServiceEvent {

    private SettingDefinition<?, ?> setting;

    private SettingValue<?> oldValue;

    private SettingValue<?> newValue;

    public SettingsChangeEvent(SettingDefinition<?, ?> setting, SettingValue<?> oldValue, SettingValue<?> newValue) {
        this.setting = setting;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public SettingDefinition<?, ?> getSetting() {
        return setting;
    }

    public SettingValue<?> getOldValue() {
        return oldValue;
    }

    public SettingValue<?> getNewValue() {
        return newValue;
    }

    public boolean hasNewValue() {
        return getNewValue() != null;
    }

    public boolean hasOldValue() {
        return getOldValue() != null;
    }

    @Override
    public String toString() {
        return String.format("SettingsChangeEvent[setting=%s, oldValue=%s, newValue=%s", getSetting(), getOldValue(),
                getNewValue());
    }
}

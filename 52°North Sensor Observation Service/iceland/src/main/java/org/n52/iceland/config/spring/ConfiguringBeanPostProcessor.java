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
package org.n52.iceland.config.spring;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import org.n52.iceland.config.SettingsService;
import org.n52.iceland.config.annotation.Configurable;
import org.n52.iceland.config.annotation.Setting;

/**
 * Bean post processor, that
 * {@linkplain SettingsService#configure(java.lang.Object) configures} beans
 * using a {@link SettingsService} bean. Configuration takes place after all
 * dependencies are injected, but before any initialization methods are called.
 *
 * Note that all beans that are required to create the {@code SettingsService}
 * bean can not be processed.
 *
 * @see Configurable
 * @see Setting
 *
 * @since 1.0.0
 *
 * @author Christian Autermann
 */
public class ConfiguringBeanPostProcessor implements BeanPostProcessor {

    private SettingsService settingsService;

    /**
     * Sets the {@code SettingsManager} used to configure the beans.
     *
     * @param settingsService the settings service
     */
    @Autowired
    public void setSettingsManager(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    /**
     * Configures the {@code bean} using the settings service.
     *
     * @param bean     the bean instance
     * @param beanName the bean name
     *
     * @return the bean
     *
     * @throws BeanInitializationException if the configuration fails
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        try {
            this.settingsService.configure(bean);
        } catch (Throwable t) {
            throw new BeanInitializationException(
                    "Couldn't set settings on bean " + beanName, t);
        }
        return bean;
    }

    /**
     * Noop implementation, will just return {@code bean}.
     *
     * @param bean     the bean instance
     * @param beanName the bean name
     *
     * @return {@code bean}
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }

}

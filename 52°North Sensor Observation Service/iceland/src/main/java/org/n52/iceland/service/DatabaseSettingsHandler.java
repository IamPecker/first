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

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.n52.iceland.exception.ConfigurationError;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.util.ServletContextPropertyFileHandler;

/**
 * @since 4.0.0
 *
 */
public class DatabaseSettingsHandler implements Constructable {

    public static final String INIT_PARAM_DATA_SOURCE_CONFIG_LOCATION
            = "datasourceConfigLocation";

    @Deprecated
    private static DatabaseSettingsHandler instance;
    private ServletContextPropertyFileHandler handler;

    @Inject
    public void setServletContext(ServletContext ctx) {
        String name = ctx
                .getInitParameter(INIT_PARAM_DATA_SOURCE_CONFIG_LOCATION);
        this.handler = new ServletContextPropertyFileHandler(ctx, name);
    }

    @Override
    public void init() {
        DatabaseSettingsHandler.instance = this;
    }

    public boolean delete() {
        return this.handler.delete();
    }

    public void delete(String key) {
        this.handler.delete(key);
    }

    public boolean exists() {
        return this.handler.exists();
    }

    public String get(String m)
            throws ConfigurationError {
        return this.handler.get(m);
    }

    public Properties getAll()
            throws ConfigurationError {
        return this.handler.getAll();
    }

    public File getFile(boolean create)
            throws IOException {
        return this.handler.getFile(create);
    }

    public String getPath() {
        return this.handler.getPath();
    }

    public void save(String m, String value)
            throws ConfigurationError {
        this.handler.save(m, value);
    }

    public void saveAll(Properties properties)
            throws ConfigurationError {
        this.handler.saveAll(properties);
    }

    @Deprecated
    public static DatabaseSettingsHandler getInstance() {
        return instance;
    }

    @Deprecated
    public static DatabaseSettingsHandler getInstance(ServletContext ctx) {
        return instance;
    }

}

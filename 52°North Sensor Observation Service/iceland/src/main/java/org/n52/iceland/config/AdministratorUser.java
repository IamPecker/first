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

/**
 * Interface for users that are allowed to administer the service.
 * Implementations are {@link SettingsService} specific.
 *
 * @author Christian Autermann <c.autermann@52north.org>
 * @since 4.0.0
 */
public interface AdministratorUser {

    /**
     * Get the value of password.
     *
     * @return the value of password
     */
    String getPassword();

    /**
     * Get the value of username.
     *
     * @return the value of username
     */
    String getUsername();

    /**
     * Set the value of password.
     *
     * @param password new value of password
     *
     * @return {@code this}
     */
    AdministratorUser setPassword(String password);

    /**
     * Set the value of username.
     *
     * @param username new value of username
     *
     * @return {@code this}
     */
    AdministratorUser setUsername(String username);
}

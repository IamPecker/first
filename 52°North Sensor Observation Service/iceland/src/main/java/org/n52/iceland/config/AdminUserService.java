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

import java.util.Set;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public interface AdminUserService {

    /**
     * Creates a new {@code AdministratorUser}. This method will fail if the
     * username is already used by another user.
     *
     * @param username
     *                 the proposed username
     * @param password
     *                 the proposed (hashed) password
     * @return the user
     */
    AdministratorUser createAdminUser(String username, String password);

    /**
     * Deletes the user with the specified username.
     *
     * @param username
     *                 the username
     */
    void deleteAdminUser(String username);

    /**
     * Deletes the user previously returned by
     * {@link #getAdminUser(java.lang.String)} or {@link #getAdminUsers()}.
     *
     * @param user
     */
    void deleteAdminUser(AdministratorUser user);

    /**
     * Gets the administrator user with the specified user name.
     *
     * @param username
     *                 the username
     *
     * @return the administrator user or {@code null} if no user with the
     *         specified name exists
     */
    AdministratorUser getAdminUser(String username);

    /**
     * Gets all registered administrator users.
     *
     * @return the users
     */
    Set<AdministratorUser> getAdminUsers();

    /**
     * Checks if a administrator user exists.
     *
     * @return {@code true} if there is a admin user, otherwise {@code false}.
     */
    boolean hasAdminUser();

    /**
     * Saves a user previously returned by
     * {@link #getAdminUser(java.lang.String)} or {@link #getAdminUsers()}.
     *
     * @param user
     *             the user to change
     */
    void saveAdminUser(AdministratorUser user);

    /**
     * Deletes all users.
     */
    void deleteAll();
}

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
import java.util.Set;

import org.n52.iceland.config.AdminUserDao;
import org.n52.iceland.config.AdministratorUser;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * TODO JavaDoc
 * @author Christian Autermann
 */
public class JsonAdminUserDao extends AbstractJsonDao implements AdminUserDao {

    @Override
    public AdministratorUser createAdminUser(String username, String password) {
        JsonAdministratorUser user;
        configuration().writeLock().lock();
        try {
            user = new JsonAdministratorUser(username, password);
            saveAdminUser(user);
        } finally {
            configuration().writeLock().unlock();
        }
        configuration().scheduleWrite();
        return user;
    }

    @Override
    public void deleteAdminUser(String username) {
        configuration().writeLock().lock();
        try {
            getConfiguration().with(JsonConstants.USERS).remove(username);
            configuration().scheduleWrite();
        } finally {
            configuration().writeLock().unlock();
        }
    }

    @Override
    public AdministratorUser getAdminUser(String username) {
        configuration().readLock().lock();
        try {
            String password = getConfiguration().path(JsonConstants.USERS).path(username).asText(null);
            return password == null ? null : new JsonAdministratorUser(username, password);
        } finally {
            configuration().readLock().unlock();
        }
    }


    @Override
    public Set<AdministratorUser> getAdminUsers() {
        Set<AdministratorUser> users;
        configuration().readLock().lock();
        try {
            JsonNode node = getConfiguration().path(JsonConstants.USERS);
            users = new HashSet<>(node.size());
            node.fieldNames()
                    .forEachRemaining(name -> users.add(new JsonAdministratorUser(name, node.path(name).asText(null))));
            return users;
        } finally {
            configuration().readLock().unlock();
        }

    }

    @Override
    public void saveAdminUser(AdministratorUser user) {
        configuration().writeLock().lock();
        try {
            getConfiguration().with(JsonConstants.USERS).put(user.getUsername(), user.getPassword());
            configuration().writeNow();
        } finally {
            configuration().writeLock().unlock();
        }

    }

    @Override
    public void deleteAll() {
        this.configuration().delete();
    }


}

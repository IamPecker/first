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
package org.n52.iceland.i18n;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.n52.iceland.component.AbstractComponentRepository;
import org.n52.iceland.i18n.metadata.AbstractI18NMetadata;
import org.n52.iceland.lifecycle.Constructable;
import org.n52.iceland.util.Producer;

import com.google.common.collect.Maps;


/**
 * I18N DAO repository
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 4.1.0
 */
@SuppressWarnings("rawtypes")
public class I18NDAORepository extends AbstractComponentRepository<I18NDAOKey, I18NDAO<?>, I18NDAOFactory> implements Constructable {
    @Deprecated
    private static I18NDAORepository instance;
    private final Map<I18NDAOKey, Producer<I18NDAO<?>>> daos = Maps.newHashMap();

    @Autowired(required = false)
    private Collection<I18NDAO<?>> components;
    @Autowired(required = false)
    private Collection<I18NDAOFactory> componentFactories;

    @Override
    public void init() {
        I18NDAORepository.instance = this;
        this.daos.clear();
        this.daos.putAll(getUniqueProviders(this.components, this.componentFactories));
    }

    /**
     * Get the available DAO
     *
     * @param <T> the meta data type
     * @param c the meta data class
     * @return the loaded DAO
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractI18NMetadata> I18NDAO<T> getDAO(Class<T> c) {
        Producer<I18NDAO<?>> producer = daos.get(new I18NDAOKey(c));
        // TODO check for subtypes
        I18NDAO<?> dao = producer == null ? null : producer.get();
        return (I18NDAO<T>) dao;
    }

    /**
     * Get the singleton instance of the I18NDAORepository.
     *
     * @return Returns a singleton instance of the I18NDAORepository.
     */
    @Deprecated
    public static I18NDAORepository getInstance() {
        return I18NDAORepository.instance;
    }

}

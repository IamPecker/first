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
package org.n52.iceland.cache;

import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.lifecycle.Destroyable;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 *
 * @since 4.0.0
 */
public interface ContentCacheController extends Destroyable {
    /**
     * @return the content cache
     */
    ContentCache getCache();

    /**
     * Update the content cache with the specified update.
     *
     * @param update the update
     *
     * @throws OwsExceptionReport ian error occurs while updating the cache
     */
    void update(ContentCacheUpdate update)
            throws OwsExceptionReport;

    /**
     * Renew the content cache completely.
     *
     * @throws OwsExceptionReport if an error occurs while updating the cache
     */
    void update()
            throws OwsExceptionReport;

    /**
     * @return Is a cache update currently in progress?
     */
    boolean isUpdateInProgress();

    /**
     * @return the ContentCachePersistenceStrategy
     *
     * @since 4.2.0
     */
    ContentCachePersistenceStrategy getContentCachePersistenceStrategy();
}

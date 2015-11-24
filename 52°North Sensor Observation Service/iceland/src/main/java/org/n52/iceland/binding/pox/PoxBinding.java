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
package org.n52.iceland.binding.pox;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.n52.iceland.binding.AbstractXmlBinding;
import org.n52.iceland.binding.Binding;
import org.n52.iceland.binding.BindingConstants;
import org.n52.iceland.binding.BindingKey;
import org.n52.iceland.binding.MediaTypeBindingKey;
import org.n52.iceland.binding.PathBindingKey;
import org.n52.iceland.coding.OperationKey;
import org.n52.iceland.config.annotation.Configurable;
import org.n52.iceland.config.annotation.Setting;
import org.n52.iceland.exception.HTTPException;
import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.ogc.sos.ConformanceClasses;
import org.n52.iceland.ogc.sos.Sos2Constants;
import org.n52.iceland.ogc.sos.SosConstants;
import org.n52.iceland.request.AbstractServiceRequest;
import org.n52.iceland.response.AbstractServiceResponse;
import org.n52.iceland.service.MiscSettings;
import org.n52.iceland.util.http.MediaType;
import org.n52.iceland.util.http.MediaTypes;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

/**
 * {@link Binding} implementation for POX (XML) encoded requests
 * @since 1.0.0
 *
 */
@Configurable
public class PoxBinding extends AbstractXmlBinding {

    private static final Set<String> CONFORMANCE_CLASSES = Collections
            .singleton(ConformanceClasses.SOS_V2_POX_BINDING);

     private static final ImmutableSet<BindingKey> KEYS = ImmutableSet.<BindingKey>builder()
            .add(new PathBindingKey(BindingConstants.POX_BINDING_ENDPOINT))
            .add(new MediaTypeBindingKey(MediaTypes.APPLICATION_XML))
            .add(new MediaTypeBindingKey(MediaTypes.TEXT_XML))
            .build();

    private boolean useHttpResponseCodes;

    @Setting(MiscSettings.HTTP_STATUS_CODE_USE_IN_KVP_POX_BINDING)
    public void setUseHttpResponseCodes(boolean useHttpResponseCodes) {
        this.useHttpResponseCodes = useHttpResponseCodes;
    }

    @Override
    protected boolean isUseHttpResponseCodes() {
        return this.useHttpResponseCodes;
    }

    @Override
    public Set<BindingKey> getKeys() {
        return Collections.unmodifiableSet(KEYS);
    }

    @Override
    public void doPostOperation(HttpServletRequest req,
                                HttpServletResponse res)
            throws HTTPException, IOException {
        AbstractServiceRequest<?> sosRequest = null;
        try {
            sosRequest = parseRequest(req);
            AbstractServiceResponse sosResponse = getServiceOperator(sosRequest)
                    .receiveRequest(sosRequest);
            writeResponse(req, res, sosResponse);
        } catch (OwsExceptionReport oer) {
            oer.setVersion(sosRequest != null ? sosRequest.getVersion() : null);
            writeOwsExceptionReport(req, res, oer);
        }
    }

    protected AbstractServiceRequest<?> parseRequest(HttpServletRequest request)
            throws OwsExceptionReport {
        return ((AbstractServiceRequest<?>)decode(request)).setRequestContext(getRequestContext(request));
    }

    @Override
    public Set<String> getConformanceClasses(String service, String version) {
        if(SosConstants.SOS.equals(service) && Sos2Constants.SERVICEVERSION.equals(version)) {
            return Collections.unmodifiableSet(CONFORMANCE_CLASSES);
        }
        return Collections.emptySet();
    }

    @Override
    public boolean checkOperationHttpPostSupported(OperationKey k) {
        return hasDecoder(k, MediaTypes.TEXT_XML) ||
               hasDecoder(k, MediaTypes.APPLICATION_XML);
    }

    @Override
    protected MediaType getDefaultContentType() {
        return MediaTypes.APPLICATION_XML;
    }

    @Override
    public Set<MediaType> getSupportedEncodings() {
        return Sets.newHashSet(MediaTypes.TEXT_XML, MediaTypes.APPLICATION_XML);
    }

    @Override
    public String getUrlPattern() {
        return BindingConstants.POX_BINDING_ENDPOINT;
    }

}


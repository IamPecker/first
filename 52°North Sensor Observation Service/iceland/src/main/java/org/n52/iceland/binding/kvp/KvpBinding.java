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
package org.n52.iceland.binding.kvp;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.n52.iceland.binding.BindingConstants;
import org.n52.iceland.binding.BindingKey;
import org.n52.iceland.binding.MediaTypeBindingKey;
import org.n52.iceland.binding.PathBindingKey;
import org.n52.iceland.binding.SimpleBinding;
import org.n52.iceland.coding.OperationKey;
import org.n52.iceland.coding.decode.Decoder;
import org.n52.iceland.coding.decode.DecoderKey;
import org.n52.iceland.coding.decode.OperationDecoderKey;
import org.n52.iceland.config.annotation.Configurable;
import org.n52.iceland.config.annotation.Setting;
import org.n52.iceland.exception.HTTPException;
import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.exception.ows.concrete.InvalidServiceParameterException;
import org.n52.iceland.exception.ows.concrete.MissingRequestParameterException;
import org.n52.iceland.exception.ows.concrete.NoDecoderForKeyException;
import org.n52.iceland.exception.ows.concrete.VersionNotSupportedException;
import org.n52.iceland.ogc.ows.OWSConstants;
import org.n52.iceland.ogc.ows.OWSConstants.RequestParams;
import org.n52.iceland.ogc.sos.ConformanceClasses;
import org.n52.iceland.ogc.sos.Sos2Constants;
import org.n52.iceland.ogc.sos.SosConstants;
import org.n52.iceland.request.AbstractServiceRequest;
import org.n52.iceland.response.AbstractServiceResponse;
import org.n52.iceland.service.MiscSettings;
import org.n52.iceland.util.KvpHelper;
import org.n52.iceland.util.http.MediaType;
import org.n52.iceland.util.http.MediaTypes;

import com.google.common.collect.ImmutableSet;

/**
 * OWS binding for Key-Value-Pair (HTTP-Get) requests
 *
 * @since 1.0.0
 */
@Configurable
public class KvpBinding extends SimpleBinding {
    private static final Logger LOGGER = LoggerFactory.getLogger(KvpBinding.class);

    private static final Set<String> CONFORMANCE_CLASSES = Collections
            .singleton(ConformanceClasses.SOS_V2_KVP_CORE_BINDING);

     private static final ImmutableSet<BindingKey> KEYS = ImmutableSet.<BindingKey>builder()
            .add(new PathBindingKey(BindingConstants.KVP_BINDING_ENDPOINT))
            .add(new MediaTypeBindingKey(MediaTypes.APPLICATION_KVP))
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
    public Set<String> getConformanceClasses(String service, String version) {
        if (SosConstants.SOS.equals(service) && Sos2Constants.SERVICEVERSION.equals(version)) {
            return Collections.unmodifiableSet(CONFORMANCE_CLASSES);
        }
        return Collections.emptySet();
    }

    @Override
    protected MediaType getDefaultContentType() {
        return MediaTypes.APPLICATION_XML;
    }

    @Override
    public void doGetOperation(HttpServletRequest req, HttpServletResponse res) throws HTTPException, IOException {
        LOGGER.debug("KVP-REQUEST: {}", req.getQueryString());
        AbstractServiceRequest<?> serviceRequest = null;
        try {
            serviceRequest = parseRequest(req);
            // add request context information
            serviceRequest.setRequestContext(getRequestContext(req));
            AbstractServiceResponse response = getServiceOperator(serviceRequest).receiveRequest(serviceRequest);
            writeResponse(req, res, response);
        } catch (OwsExceptionReport oer) {
            oer.setVersion(serviceRequest != null ? serviceRequest.getVersion() : null);
            writeOwsExceptionReport(req, res, oer);
        }
    }

    private String getServiceParameterValue(Map<String, String> map) throws OwsExceptionReport {
        final String service = KvpHelper.getParameterValue(RequestParams.service, map);
        KvpHelper.checkParameterValue(service, RequestParams.service);
        if (!isServiceSupported(service)) {
            throw new InvalidServiceParameterException(service);
        }
        return service;
    }

    private String getVersionParameterValue(Map<String, String> map) throws OwsExceptionReport {
        final String version = KvpHelper.getParameterValue(RequestParams.version, map);
        final String service = KvpHelper.getParameterValue(RequestParams.service, map);
        if (!isGetCapabilities(map)) {
            KvpHelper.checkParameterValue(version, RequestParams.version);
            KvpHelper.checkParameterValue(service, RequestParams.service);
            if (!isVersionSupported(service, version)) {
                throw new VersionNotSupportedException();
            }
        }
        return version;
    }

    @Override
    public boolean checkOperationHttpGetSupported(OperationKey k) {
        return hasDecoder(k, MediaTypes.APPLICATION_KVP);
    }

    protected boolean isGetCapabilities(Map<String, String> map) throws OwsExceptionReport {
        return OWSConstants.Operations.GetCapabilities.name().equals(getRequestParameterValue(map));
    }

    public String getRequestParameterValue(Map<String, String> map) throws OwsExceptionReport {
        String value = KvpHelper.getParameterValue(RequestParams.request, map);
        KvpHelper.checkParameterValue(value, RequestParams.request);
        return value;
    }

    protected AbstractServiceRequest<?> parseRequest(HttpServletRequest req) throws OwsExceptionReport {
        if (req.getParameterMap() == null || (req.getParameterMap() != null && req.getParameterMap().isEmpty())) {
            throw new MissingRequestParameterException();
        }
        Map<String, String> parameterValueMap = KvpHelper.getKvpParameterValueMap(req);
        // check if request contains request parameter
        String operation = getRequestParameterValue(parameterValueMap);
        KvpHelper.checkParameterValue(operation, RequestParams.request);
        // sanity check on operation value before continued processing
        KvpHelper.checkRequestParameter(operation);
        String service = getServiceParameterValue(parameterValueMap);
        String version = getVersionParameterValue(parameterValueMap);
        if (version != null && !isVersionSupported(service, version)) {
            throw new VersionNotSupportedException();
        }
        DecoderKey k = new OperationDecoderKey(service, version, operation, MediaTypes.APPLICATION_KVP);
        Decoder<AbstractServiceRequest<?>, Map<String, String>> decoder = getDecoder(k);
        if (decoder != null) {
            return decoder.decode(parameterValueMap);
        } else {
            throw new NoDecoderForKeyException(k);
        }
    }

    @Override
    public Set<MediaType> getSupportedEncodings() {
        return Collections.singleton(MediaTypes.APPLICATION_KVP);
    }

    @Override
    public String getUrlPattern() {
        return BindingConstants.KVP_BINDING_ENDPOINT;
    }
}

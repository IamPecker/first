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
package org.n52.iceland.request;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.exception.ows.VersionNegotiationFailedException;
import org.n52.iceland.ogc.ows.OWSConstants;
import org.n52.iceland.response.GetCapabilitiesResponse;
import org.n52.iceland.service.operator.ServiceOperatorKey;
import org.n52.iceland.service.operator.ServiceOperatorRepository;
import org.n52.iceland.util.CollectionHelper;
import org.n52.iceland.util.Comparables;
import org.n52.iceland.util.StringHelper;

/**
 * Implementation of {@link AbstractServiceRequest} for OWS GetCapabilities
 *
 * @since 1.0.0
 */
public class GetCapabilitiesRequest extends AbstractServiceRequest<GetCapabilitiesResponse> {
    private final List<String> acceptVersions = new LinkedList<>();
    private final List<String> sections = new LinkedList<>();
    private final List<String> acceptFormats = new LinkedList<>();
    private List<ServiceOperatorKey> serviceOperatorKeyTypes;
    private String capabilitiesId;
    private String updateSequence;

    public GetCapabilitiesRequest(String service) {
        setService(service);
    }

    @Override
    public String getOperationName() {
        return OWSConstants.Operations.GetCapabilities.name();
    }

    /**
     * Get accept Formats
     *
     * @return accept Formats
     */
    public List<String> getAcceptFormats() {
        return acceptFormats == null ? null : Collections.unmodifiableList(acceptFormats);
    }

    /**
     * Set accept Formats
     *
     * @param acceptFormats
     *            accept Formats
     */
    public void setAcceptFormats(List<String> acceptFormats) {
        this.acceptFormats.clear();
        if (acceptFormats != null) {
            this.acceptFormats.addAll(acceptFormats);
        }
    }

    /**
     * Get accept versions
     *
     * @return accept versions
     */
    public List<String> getAcceptVersions() {
        return acceptVersions == null ? null : Collections.unmodifiableList(acceptVersions);
    }

    public void setAcceptVersions(List<String> acceptVersions) {
        this.acceptVersions.clear();
        if (acceptVersions != null) {
            this.acceptVersions.addAll(acceptVersions);
        }
    }

    public void addAcceptVersion(String acceptVersion) {
        if (acceptVersion != null) {
            acceptVersions.add(acceptVersion);
        }
    }

    /**
     * Get sections
     *
     * @return sections
     */
    public List<String> getSections() {
        return sections == null ? null : Collections.unmodifiableList(sections);
    }

    /**
     * Set sections
     *
     * @param sections
     *            sections
     */
    public void setSections(List<String> sections) {
        this.sections.clear();
        if (sections != null) {
            this.sections.addAll(sections);
        }
    }

    /**
     * Get update sequence
     *
     * @return update sequence
     */
    public String getUpdateSequence() {
        return updateSequence;
    }

    /**
     * Set update sequence
     *
     * @param updateSequence
     *            update sequence
     */
    public void setUpdateSequence(String updateSequence) {
        this.updateSequence = updateSequence;
    }

    public String getCapabilitiesId() {
        return this.capabilitiesId;
    }

    public void setCapabilitiesId(String id) {
        this.capabilitiesId = id;
    }

    public boolean isCapabilitiesIdSet() {
        return getCapabilitiesId() != null && !getCapabilitiesId().isEmpty();
    }

    public boolean isSetAcceptFormats() {
        return CollectionHelper.isNotEmpty(getAcceptFormats());
    }

    public boolean isSetAcceptVersions() {
        return CollectionHelper.isNotEmpty(getAcceptVersions());
    }

    public boolean isSetSections() {
        return CollectionHelper.isNotEmpty(getSections());
    }

    public boolean isSetUpdateSequence() {
        return StringHelper.isNotEmpty(getUpdateSequence());
    }

    @Override
    public GetCapabilitiesResponse getResponse() throws OwsExceptionReport {
        return (GetCapabilitiesResponse)
                new GetCapabilitiesResponse().set(this).setVersion(getVersionParameter());
    }

    /**
     * Get the response version from request, from set version, from
     * acceptVersions or from supported versions
     *
     * @return the response version
     * @throws OwsExceptionReport
     *             If the requested version is not supported
     */
    private String getVersionParameter() throws OwsExceptionReport {
        if (isSetVersion()) {
            return getVersion();
        } else {
            Stream<String> versions;
            if (isSetAcceptVersions()) {
                versions = acceptVersions.stream()
                        .filter(this::isVersionSupported);
            } else {
                versions = getSupportedVersions().stream();
            }
            return setVersion(versions.findFirst()
                    .orElseThrow(this::versionNegotiationFailed)).getVersion();
        }
    }

    private OwsExceptionReport versionNegotiationFailed() {
        return new VersionNegotiationFailedException().withMessage(
                "The requested '%s' values are not supported by this service!",
                OWSConstants.GetCapabilitiesParams.AcceptVersions);
    }


    @Override
    public List<ServiceOperatorKey> getServiceOperatorKeys() {
        if (serviceOperatorKeyTypes == null) {
            String service = getService();
            if (isSetAcceptVersions()) {
                serviceOperatorKeyTypes = acceptVersions.stream()
                        .map(version -> new ServiceOperatorKey(service, version))
                        .collect(Collectors.toList());
            } else {
                Set<String> supportedVersions = getSupportedVersions();
                if (CollectionHelper.isNotEmpty(supportedVersions)) {
                    setVersion(Comparables.version().max(supportedVersions));
                }
                serviceOperatorKeyTypes = Collections.singletonList(new ServiceOperatorKey(service, getVersion()));
            }
        }
        return Collections.unmodifiableList(serviceOperatorKeyTypes);
    }

    private Set<String> getSupportedVersions() {
        return ServiceOperatorRepository.getInstance().getSupportedVersions(getService());
    }

    private boolean isVersionSupported(String acceptedVersion) {
        return ServiceOperatorRepository.getInstance().isVersionSupported(getService(), acceptedVersion);
    }

}

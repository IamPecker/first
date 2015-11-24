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
package org.n52.iceland.binding;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import org.junit.Test;
import org.n52.iceland.coding.decode.DecoderKey;
import org.n52.iceland.coding.decode.OperationDecoderKey;
import org.n52.iceland.coding.decode.XmlNamespaceOperationDecoderKey;
import org.n52.iceland.exception.CodedException;
import org.n52.iceland.w3c.soap.SoapConstants;

public class AbstractXmlBindingTest {

    private TestXmlBinding binding = new TestXmlBinding();

    private String xmlStringGetObs =
            new StringBuilder()
                    .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                    .append("<sos:GetObservation service=\"SOS\" version=\"2.0.0\"")
                    .append(" xmlns:sos=\"http://www.opengis.net/sos/2.0\"")
                    .append(" xmlns:fes=\"http://www.opengis.net/fes/2.0\"")
                    .append(" xmlns:gml=\"http://www.opengis.net/gml/3.2\"")
                    .append(" xmlns:swe=\"http://www.opengis.net/swe/2.0\"")
                    .append(" xmlns:xlink=\"http://www.w3.org/1999/xlink\"")
                    .append(" xmlns:swes=\"http://www.opengis.net/swes/2.0\"")
                    .append(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"")
                    .append(" xsi:schemaLocation=\"http://www.opengis.net/sos/2.0 http://schemas.opengis.net/sos/2.0/sos.xsd\">")
                    .append("</sos:GetObservation>").toString();

    private String xmlStringGetCaps =
            new StringBuilder()
                    .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                    .append("<sos:GetCapabilities service=\"SOS\" version=\"2.0.0\"")
                    .append(" xmlns:sos=\"http://www.opengis.net/sos/2.0\"")
                    .append(" xsi:schemaLocation=\"http://www.opengis.net/sos/2.0 http://schemas.opengis.net/sos/2.0/sos.xsd\">")
                    .append("</sos:GetCapabilities>").toString();
    
    private String xmlStringSoapPrefix= new StringBuilder().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
            .append("<env:Envelope xmlns:env=\"http://www.w3.org/2003/05/soap-envelope\">").append("<env:Body/>")
            .append("</env:Envelope>").toString();
    
    private String xmlStringSoapNoPrefix = new StringBuilder().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
            .append("<Envelope xmlns=\"http://www.w3.org/2003/05/soap-envelope\">").append("<env:Body/>")
            .append("</Envelope>").toString();

    @Test
    public void test_SoapPrefix() throws CodedException {
        DecoderKey decoderKey = binding.getDecoderKey(xmlStringSoapPrefix);
        assertTrue(decoderKey instanceof XmlNamespaceOperationDecoderKey);
        assertTrue(SoapConstants.NS_SOAP_12.equals(((XmlNamespaceOperationDecoderKey)decoderKey).getNamespace()));
    }
    
    @Test
    public void test_SoapNoPrefix() throws CodedException {
        DecoderKey decoderKey = binding.getDecoderKey(xmlStringSoapNoPrefix);
        assertTrue(decoderKey instanceof XmlNamespaceOperationDecoderKey);
        assertTrue(SoapConstants.NS_SOAP_12.equals(((XmlNamespaceOperationDecoderKey)decoderKey).getNamespace()));
    }

    @Test
    public void test_GetObs() throws CodedException {
        DecoderKey decoderKey = binding.getDecoderKey(xmlStringGetObs);
        if (decoderKey instanceof OperationDecoderKey) {
            assertThat(((OperationDecoderKey) decoderKey).getService(), is("SOS"));
            assertThat(((OperationDecoderKey) decoderKey).getVersion(), is("2.0.0"));
            assertThat(((OperationDecoderKey) decoderKey).getOperation(), is("GetObservation"));
        }
    }

    @Test
    public void test_GetCaps() throws CodedException {
        DecoderKey decoderKey = binding.getDecoderKey(xmlStringGetCaps);
        if (decoderKey instanceof OperationDecoderKey) {
            assertThat(((OperationDecoderKey) decoderKey).getService(), is("SOS"));
            assertThat(((OperationDecoderKey) decoderKey).getOperation(), is("GetCapabilities"));
        }
    }

}

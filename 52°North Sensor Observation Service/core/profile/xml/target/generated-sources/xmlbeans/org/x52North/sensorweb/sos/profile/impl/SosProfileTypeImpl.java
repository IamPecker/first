/*
 * XML Type:  SosProfileType
 * Namespace: http://www.52north.org/sensorweb/sos/profile
 * Java type: org.x52North.sensorweb.sos.profile.SosProfileType
 *
 * Automatically generated - do not modify.
 */
package org.x52North.sensorweb.sos.profile.impl;
/**
 * An XML SosProfileType(@http://www.52north.org/sensorweb/sos/profile).
 *
 * This is a complex type.
 */
public class SosProfileTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.x52North.sensorweb.sos.profile.SosProfileType
{
    private static final long serialVersionUID = 1L;
    
    public SosProfileTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName IDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "identifier");
    private static final javax.xml.namespace.QName ACTIVEPROFILE$2 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "activeProfile");
    private static final javax.xml.namespace.QName OBSERVATIONRESPONSEFORMAT$4 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "observationResponseFormat");
    private static final javax.xml.namespace.QName ENCODEFEATUREOFINTERESTINOBSERVATIONS$6 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "encodeFeatureOfInterestInObservations");
    private static final javax.xml.namespace.QName ENCODINGNAMESPACEFORFEATUREOFINTERESTENCODING$8 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "encodingNamespaceForFeatureOfInterestEncoding");
    private static final javax.xml.namespace.QName SHOWMETADATAOFEMPTYOBSERVATIONS$10 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "showMetadataOfEmptyObservations");
    private static final javax.xml.namespace.QName LISTFEATUREOFINTERESTSINOFFERINGS$12 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "listFeatureOfInterestsInOfferings");
    private static final javax.xml.namespace.QName ENCODECHILDPROCEDUREDESCRIPTIONS$14 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "encodeChildProcedureDescriptions");
    private static final javax.xml.namespace.QName SHOWFULLOPERATIONSMETADATA$16 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "showFullOperationsMetadata");
    private static final javax.xml.namespace.QName SHOWFULLOPERATIONSMETADATAFOROBSERVATIONS$18 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "showFullOperationsMetadataForObservations");
    private static final javax.xml.namespace.QName ALLOWSUBSETTINGFORSOS20OM20$20 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "allowSubsettingForSOS20OM20");
    private static final javax.xml.namespace.QName MERGEVALUES$22 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "mergeValues");
    private static final javax.xml.namespace.QName NODATAPLACEHOLDER$24 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "NoDataPlaceholder");
    private static final javax.xml.namespace.QName RETURNLATESTVALUEIFTEMPORALFILTERISMISSINGINGETOBSERVATION$26 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "returnLatestValueIfTemporalFilterIsMissingInGetObservation");
    private static final javax.xml.namespace.QName ENCODEPROCEDURE$28 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "EncodeProcedure");
    private static final javax.xml.namespace.QName DEFAULTOBSERVATIONTYPESFORENCODING$30 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "DefaultObservationTypesForEncoding");
    
    
    /**
     * Gets the "identifier" element
     */
    public java.lang.String getIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "identifier" element
     */
    public org.apache.xmlbeans.XmlString xgetIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IDENTIFIER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "identifier" element
     */
    public void setIdentifier(java.lang.String identifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(IDENTIFIER$0);
            }
            target.setStringValue(identifier);
        }
    }
    
    /**
     * Sets (as xml) the "identifier" element
     */
    public void xsetIdentifier(org.apache.xmlbeans.XmlString identifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(IDENTIFIER$0);
            }
            target.set(identifier);
        }
    }
    
    /**
     * Gets the "activeProfile" element
     */
    public boolean getActiveProfile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACTIVEPROFILE$2, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "activeProfile" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetActiveProfile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ACTIVEPROFILE$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "activeProfile" element
     */
    public void setActiveProfile(boolean activeProfile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACTIVEPROFILE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ACTIVEPROFILE$2);
            }
            target.setBooleanValue(activeProfile);
        }
    }
    
    /**
     * Sets (as xml) the "activeProfile" element
     */
    public void xsetActiveProfile(org.apache.xmlbeans.XmlBoolean activeProfile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ACTIVEPROFILE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(ACTIVEPROFILE$2);
            }
            target.set(activeProfile);
        }
    }
    
    /**
     * Gets the "observationResponseFormat" element
     */
    public java.lang.String getObservationResponseFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OBSERVATIONRESPONSEFORMAT$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "observationResponseFormat" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetObservationResponseFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(OBSERVATIONRESPONSEFORMAT$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "observationResponseFormat" element
     */
    public void setObservationResponseFormat(java.lang.String observationResponseFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OBSERVATIONRESPONSEFORMAT$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OBSERVATIONRESPONSEFORMAT$4);
            }
            target.setStringValue(observationResponseFormat);
        }
    }
    
    /**
     * Sets (as xml) the "observationResponseFormat" element
     */
    public void xsetObservationResponseFormat(org.apache.xmlbeans.XmlAnyURI observationResponseFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(OBSERVATIONRESPONSEFORMAT$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(OBSERVATIONRESPONSEFORMAT$4);
            }
            target.set(observationResponseFormat);
        }
    }
    
    /**
     * Gets the "encodeFeatureOfInterestInObservations" element
     */
    public boolean getEncodeFeatureOfInterestInObservations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODEFEATUREOFINTERESTINOBSERVATIONS$6, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "encodeFeatureOfInterestInObservations" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetEncodeFeatureOfInterestInObservations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ENCODEFEATUREOFINTERESTINOBSERVATIONS$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "encodeFeatureOfInterestInObservations" element
     */
    public void setEncodeFeatureOfInterestInObservations(boolean encodeFeatureOfInterestInObservations)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODEFEATUREOFINTERESTINOBSERVATIONS$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODEFEATUREOFINTERESTINOBSERVATIONS$6);
            }
            target.setBooleanValue(encodeFeatureOfInterestInObservations);
        }
    }
    
    /**
     * Sets (as xml) the "encodeFeatureOfInterestInObservations" element
     */
    public void xsetEncodeFeatureOfInterestInObservations(org.apache.xmlbeans.XmlBoolean encodeFeatureOfInterestInObservations)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ENCODEFEATUREOFINTERESTINOBSERVATIONS$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(ENCODEFEATUREOFINTERESTINOBSERVATIONS$6);
            }
            target.set(encodeFeatureOfInterestInObservations);
        }
    }
    
    /**
     * Gets the "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    public java.lang.String getEncodingNamespaceForFeatureOfInterestEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGNAMESPACEFORFEATUREOFINTERESTENCODING$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetEncodingNamespaceForFeatureOfInterestEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(ENCODINGNAMESPACEFORFEATUREOFINTERESTENCODING$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    public boolean isSetEncodingNamespaceForFeatureOfInterestEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ENCODINGNAMESPACEFORFEATUREOFINTERESTENCODING$8) != 0;
        }
    }
    
    /**
     * Sets the "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    public void setEncodingNamespaceForFeatureOfInterestEncoding(java.lang.String encodingNamespaceForFeatureOfInterestEncoding)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODINGNAMESPACEFORFEATUREOFINTERESTENCODING$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODINGNAMESPACEFORFEATUREOFINTERESTENCODING$8);
            }
            target.setStringValue(encodingNamespaceForFeatureOfInterestEncoding);
        }
    }
    
    /**
     * Sets (as xml) the "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    public void xsetEncodingNamespaceForFeatureOfInterestEncoding(org.apache.xmlbeans.XmlAnyURI encodingNamespaceForFeatureOfInterestEncoding)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(ENCODINGNAMESPACEFORFEATUREOFINTERESTENCODING$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(ENCODINGNAMESPACEFORFEATUREOFINTERESTENCODING$8);
            }
            target.set(encodingNamespaceForFeatureOfInterestEncoding);
        }
    }
    
    /**
     * Unsets the "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    public void unsetEncodingNamespaceForFeatureOfInterestEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ENCODINGNAMESPACEFORFEATUREOFINTERESTENCODING$8, 0);
        }
    }
    
    /**
     * Gets the "showMetadataOfEmptyObservations" element
     */
    public boolean getShowMetadataOfEmptyObservations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHOWMETADATAOFEMPTYOBSERVATIONS$10, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "showMetadataOfEmptyObservations" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetShowMetadataOfEmptyObservations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(SHOWMETADATAOFEMPTYOBSERVATIONS$10, 0);
            return target;
        }
    }
    
    /**
     * Sets the "showMetadataOfEmptyObservations" element
     */
    public void setShowMetadataOfEmptyObservations(boolean showMetadataOfEmptyObservations)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHOWMETADATAOFEMPTYOBSERVATIONS$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SHOWMETADATAOFEMPTYOBSERVATIONS$10);
            }
            target.setBooleanValue(showMetadataOfEmptyObservations);
        }
    }
    
    /**
     * Sets (as xml) the "showMetadataOfEmptyObservations" element
     */
    public void xsetShowMetadataOfEmptyObservations(org.apache.xmlbeans.XmlBoolean showMetadataOfEmptyObservations)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(SHOWMETADATAOFEMPTYOBSERVATIONS$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(SHOWMETADATAOFEMPTYOBSERVATIONS$10);
            }
            target.set(showMetadataOfEmptyObservations);
        }
    }
    
    /**
     * Gets the "listFeatureOfInterestsInOfferings" element
     */
    public boolean getListFeatureOfInterestsInOfferings()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LISTFEATUREOFINTERESTSINOFFERINGS$12, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "listFeatureOfInterestsInOfferings" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetListFeatureOfInterestsInOfferings()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(LISTFEATUREOFINTERESTSINOFFERINGS$12, 0);
            return target;
        }
    }
    
    /**
     * Sets the "listFeatureOfInterestsInOfferings" element
     */
    public void setListFeatureOfInterestsInOfferings(boolean listFeatureOfInterestsInOfferings)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LISTFEATUREOFINTERESTSINOFFERINGS$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LISTFEATUREOFINTERESTSINOFFERINGS$12);
            }
            target.setBooleanValue(listFeatureOfInterestsInOfferings);
        }
    }
    
    /**
     * Sets (as xml) the "listFeatureOfInterestsInOfferings" element
     */
    public void xsetListFeatureOfInterestsInOfferings(org.apache.xmlbeans.XmlBoolean listFeatureOfInterestsInOfferings)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(LISTFEATUREOFINTERESTSINOFFERINGS$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(LISTFEATUREOFINTERESTSINOFFERINGS$12);
            }
            target.set(listFeatureOfInterestsInOfferings);
        }
    }
    
    /**
     * Gets the "encodeChildProcedureDescriptions" element
     */
    public boolean getEncodeChildProcedureDescriptions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODECHILDPROCEDUREDESCRIPTIONS$14, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "encodeChildProcedureDescriptions" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetEncodeChildProcedureDescriptions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ENCODECHILDPROCEDUREDESCRIPTIONS$14, 0);
            return target;
        }
    }
    
    /**
     * Sets the "encodeChildProcedureDescriptions" element
     */
    public void setEncodeChildProcedureDescriptions(boolean encodeChildProcedureDescriptions)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODECHILDPROCEDUREDESCRIPTIONS$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODECHILDPROCEDUREDESCRIPTIONS$14);
            }
            target.setBooleanValue(encodeChildProcedureDescriptions);
        }
    }
    
    /**
     * Sets (as xml) the "encodeChildProcedureDescriptions" element
     */
    public void xsetEncodeChildProcedureDescriptions(org.apache.xmlbeans.XmlBoolean encodeChildProcedureDescriptions)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ENCODECHILDPROCEDUREDESCRIPTIONS$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(ENCODECHILDPROCEDUREDESCRIPTIONS$14);
            }
            target.set(encodeChildProcedureDescriptions);
        }
    }
    
    /**
     * Gets the "showFullOperationsMetadata" element
     */
    public boolean getShowFullOperationsMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHOWFULLOPERATIONSMETADATA$16, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "showFullOperationsMetadata" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetShowFullOperationsMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(SHOWFULLOPERATIONSMETADATA$16, 0);
            return target;
        }
    }
    
    /**
     * Sets the "showFullOperationsMetadata" element
     */
    public void setShowFullOperationsMetadata(boolean showFullOperationsMetadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHOWFULLOPERATIONSMETADATA$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SHOWFULLOPERATIONSMETADATA$16);
            }
            target.setBooleanValue(showFullOperationsMetadata);
        }
    }
    
    /**
     * Sets (as xml) the "showFullOperationsMetadata" element
     */
    public void xsetShowFullOperationsMetadata(org.apache.xmlbeans.XmlBoolean showFullOperationsMetadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(SHOWFULLOPERATIONSMETADATA$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(SHOWFULLOPERATIONSMETADATA$16);
            }
            target.set(showFullOperationsMetadata);
        }
    }
    
    /**
     * Gets the "showFullOperationsMetadataForObservations" element
     */
    public boolean getShowFullOperationsMetadataForObservations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHOWFULLOPERATIONSMETADATAFOROBSERVATIONS$18, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "showFullOperationsMetadataForObservations" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetShowFullOperationsMetadataForObservations()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(SHOWFULLOPERATIONSMETADATAFOROBSERVATIONS$18, 0);
            return target;
        }
    }
    
    /**
     * Sets the "showFullOperationsMetadataForObservations" element
     */
    public void setShowFullOperationsMetadataForObservations(boolean showFullOperationsMetadataForObservations)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SHOWFULLOPERATIONSMETADATAFOROBSERVATIONS$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SHOWFULLOPERATIONSMETADATAFOROBSERVATIONS$18);
            }
            target.setBooleanValue(showFullOperationsMetadataForObservations);
        }
    }
    
    /**
     * Sets (as xml) the "showFullOperationsMetadataForObservations" element
     */
    public void xsetShowFullOperationsMetadataForObservations(org.apache.xmlbeans.XmlBoolean showFullOperationsMetadataForObservations)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(SHOWFULLOPERATIONSMETADATAFOROBSERVATIONS$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(SHOWFULLOPERATIONSMETADATAFOROBSERVATIONS$18);
            }
            target.set(showFullOperationsMetadataForObservations);
        }
    }
    
    /**
     * Gets the "allowSubsettingForSOS20OM20" element
     */
    public boolean getAllowSubsettingForSOS20OM20()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ALLOWSUBSETTINGFORSOS20OM20$20, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "allowSubsettingForSOS20OM20" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetAllowSubsettingForSOS20OM20()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ALLOWSUBSETTINGFORSOS20OM20$20, 0);
            return target;
        }
    }
    
    /**
     * Sets the "allowSubsettingForSOS20OM20" element
     */
    public void setAllowSubsettingForSOS20OM20(boolean allowSubsettingForSOS20OM20)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ALLOWSUBSETTINGFORSOS20OM20$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ALLOWSUBSETTINGFORSOS20OM20$20);
            }
            target.setBooleanValue(allowSubsettingForSOS20OM20);
        }
    }
    
    /**
     * Sets (as xml) the "allowSubsettingForSOS20OM20" element
     */
    public void xsetAllowSubsettingForSOS20OM20(org.apache.xmlbeans.XmlBoolean allowSubsettingForSOS20OM20)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ALLOWSUBSETTINGFORSOS20OM20$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(ALLOWSUBSETTINGFORSOS20OM20$20);
            }
            target.set(allowSubsettingForSOS20OM20);
        }
    }
    
    /**
     * Gets the "mergeValues" element
     */
    public boolean getMergeValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MERGEVALUES$22, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "mergeValues" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetMergeValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(MERGEVALUES$22, 0);
            return target;
        }
    }
    
    /**
     * Sets the "mergeValues" element
     */
    public void setMergeValues(boolean mergeValues)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MERGEVALUES$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MERGEVALUES$22);
            }
            target.setBooleanValue(mergeValues);
        }
    }
    
    /**
     * Sets (as xml) the "mergeValues" element
     */
    public void xsetMergeValues(org.apache.xmlbeans.XmlBoolean mergeValues)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(MERGEVALUES$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(MERGEVALUES$22);
            }
            target.set(mergeValues);
        }
    }
    
    /**
     * Gets the "NoDataPlaceholder" element
     */
    public org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder getNoDataPlaceholder()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder target = null;
            target = (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder)get_store().find_element_user(NODATAPLACEHOLDER$24, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "NoDataPlaceholder" element
     */
    public void setNoDataPlaceholder(org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder noDataPlaceholder)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder target = null;
            target = (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder)get_store().find_element_user(NODATAPLACEHOLDER$24, 0);
            if (target == null)
            {
                target = (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder)get_store().add_element_user(NODATAPLACEHOLDER$24);
            }
            target.set(noDataPlaceholder);
        }
    }
    
    /**
     * Appends and returns a new empty "NoDataPlaceholder" element
     */
    public org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder addNewNoDataPlaceholder()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder target = null;
            target = (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder)get_store().add_element_user(NODATAPLACEHOLDER$24);
            return target;
        }
    }
    
    /**
     * Gets the "returnLatestValueIfTemporalFilterIsMissingInGetObservation" element
     */
    public boolean getReturnLatestValueIfTemporalFilterIsMissingInGetObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RETURNLATESTVALUEIFTEMPORALFILTERISMISSINGINGETOBSERVATION$26, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "returnLatestValueIfTemporalFilterIsMissingInGetObservation" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetReturnLatestValueIfTemporalFilterIsMissingInGetObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(RETURNLATESTVALUEIFTEMPORALFILTERISMISSINGINGETOBSERVATION$26, 0);
            return target;
        }
    }
    
    /**
     * Sets the "returnLatestValueIfTemporalFilterIsMissingInGetObservation" element
     */
    public void setReturnLatestValueIfTemporalFilterIsMissingInGetObservation(boolean returnLatestValueIfTemporalFilterIsMissingInGetObservation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RETURNLATESTVALUEIFTEMPORALFILTERISMISSINGINGETOBSERVATION$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RETURNLATESTVALUEIFTEMPORALFILTERISMISSINGINGETOBSERVATION$26);
            }
            target.setBooleanValue(returnLatestValueIfTemporalFilterIsMissingInGetObservation);
        }
    }
    
    /**
     * Sets (as xml) the "returnLatestValueIfTemporalFilterIsMissingInGetObservation" element
     */
    public void xsetReturnLatestValueIfTemporalFilterIsMissingInGetObservation(org.apache.xmlbeans.XmlBoolean returnLatestValueIfTemporalFilterIsMissingInGetObservation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(RETURNLATESTVALUEIFTEMPORALFILTERISMISSINGINGETOBSERVATION$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(RETURNLATESTVALUEIFTEMPORALFILTERISMISSINGINGETOBSERVATION$26);
            }
            target.set(returnLatestValueIfTemporalFilterIsMissingInGetObservation);
        }
    }
    
    /**
     * Gets array of all "EncodeProcedure" elements
     */
    public org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure[] getEncodeProcedureArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ENCODEPROCEDURE$28, targetList);
            org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure[] result = new org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "EncodeProcedure" element
     */
    public org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure getEncodeProcedureArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure target = null;
            target = (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure)get_store().find_element_user(ENCODEPROCEDURE$28, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "EncodeProcedure" element
     */
    public int sizeOfEncodeProcedureArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ENCODEPROCEDURE$28);
        }
    }
    
    /**
     * Sets array of all "EncodeProcedure" element
     */
    public void setEncodeProcedureArray(org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure[] encodeProcedureArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(encodeProcedureArray, ENCODEPROCEDURE$28);
        }
    }
    
    /**
     * Sets ith "EncodeProcedure" element
     */
    public void setEncodeProcedureArray(int i, org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure encodeProcedure)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure target = null;
            target = (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure)get_store().find_element_user(ENCODEPROCEDURE$28, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(encodeProcedure);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "EncodeProcedure" element
     */
    public org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure insertNewEncodeProcedure(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure target = null;
            target = (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure)get_store().insert_element_user(ENCODEPROCEDURE$28, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "EncodeProcedure" element
     */
    public org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure addNewEncodeProcedure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure target = null;
            target = (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure)get_store().add_element_user(ENCODEPROCEDURE$28);
            return target;
        }
    }
    
    /**
     * Removes the ith "EncodeProcedure" element
     */
    public void removeEncodeProcedure(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ENCODEPROCEDURE$28, i);
        }
    }
    
    /**
     * Gets array of all "DefaultObservationTypesForEncoding" elements
     */
    public org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding[] getDefaultObservationTypesForEncodingArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DEFAULTOBSERVATIONTYPESFORENCODING$30, targetList);
            org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding[] result = new org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "DefaultObservationTypesForEncoding" element
     */
    public org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding getDefaultObservationTypesForEncodingArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding target = null;
            target = (org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding)get_store().find_element_user(DEFAULTOBSERVATIONTYPESFORENCODING$30, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "DefaultObservationTypesForEncoding" element
     */
    public int sizeOfDefaultObservationTypesForEncodingArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DEFAULTOBSERVATIONTYPESFORENCODING$30);
        }
    }
    
    /**
     * Sets array of all "DefaultObservationTypesForEncoding" element
     */
    public void setDefaultObservationTypesForEncodingArray(org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding[] defaultObservationTypesForEncodingArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(defaultObservationTypesForEncodingArray, DEFAULTOBSERVATIONTYPESFORENCODING$30);
        }
    }
    
    /**
     * Sets ith "DefaultObservationTypesForEncoding" element
     */
    public void setDefaultObservationTypesForEncodingArray(int i, org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding defaultObservationTypesForEncoding)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding target = null;
            target = (org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding)get_store().find_element_user(DEFAULTOBSERVATIONTYPESFORENCODING$30, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(defaultObservationTypesForEncoding);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "DefaultObservationTypesForEncoding" element
     */
    public org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding insertNewDefaultObservationTypesForEncoding(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding target = null;
            target = (org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding)get_store().insert_element_user(DEFAULTOBSERVATIONTYPESFORENCODING$30, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "DefaultObservationTypesForEncoding" element
     */
    public org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding addNewDefaultObservationTypesForEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding target = null;
            target = (org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding)get_store().add_element_user(DEFAULTOBSERVATIONTYPESFORENCODING$30);
            return target;
        }
    }
    
    /**
     * Removes the ith "DefaultObservationTypesForEncoding" element
     */
    public void removeDefaultObservationTypesForEncoding(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DEFAULTOBSERVATIONTYPESFORENCODING$30, i);
        }
    }
}

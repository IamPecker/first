/*
 * XML Type:  SosProfileType
 * Namespace: http://www.52north.org/sensorweb/sos/profile
 * Java type: org.x52North.sensorweb.sos.profile.SosProfileType
 *
 * Automatically generated - do not modify.
 */
package org.x52North.sensorweb.sos.profile;


/**
 * An XML SosProfileType(@http://www.52north.org/sensorweb/sos/profile).
 *
 * This is a complex type.
 */
public interface SosProfileType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SosProfileType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sA9EDFA21CC6AEFC37448615A3EEC3294").resolveHandle("sosprofiletype28edtype");
    
    /**
     * Gets the "identifier" element
     */
    java.lang.String getIdentifier();
    
    /**
     * Gets (as xml) the "identifier" element
     */
    org.apache.xmlbeans.XmlString xgetIdentifier();
    
    /**
     * Sets the "identifier" element
     */
    void setIdentifier(java.lang.String identifier);
    
    /**
     * Sets (as xml) the "identifier" element
     */
    void xsetIdentifier(org.apache.xmlbeans.XmlString identifier);
    
    /**
     * Gets the "activeProfile" element
     */
    boolean getActiveProfile();
    
    /**
     * Gets (as xml) the "activeProfile" element
     */
    org.apache.xmlbeans.XmlBoolean xgetActiveProfile();
    
    /**
     * Sets the "activeProfile" element
     */
    void setActiveProfile(boolean activeProfile);
    
    /**
     * Sets (as xml) the "activeProfile" element
     */
    void xsetActiveProfile(org.apache.xmlbeans.XmlBoolean activeProfile);
    
    /**
     * Gets the "observationResponseFormat" element
     */
    java.lang.String getObservationResponseFormat();
    
    /**
     * Gets (as xml) the "observationResponseFormat" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetObservationResponseFormat();
    
    /**
     * Sets the "observationResponseFormat" element
     */
    void setObservationResponseFormat(java.lang.String observationResponseFormat);
    
    /**
     * Sets (as xml) the "observationResponseFormat" element
     */
    void xsetObservationResponseFormat(org.apache.xmlbeans.XmlAnyURI observationResponseFormat);
    
    /**
     * Gets the "encodeFeatureOfInterestInObservations" element
     */
    boolean getEncodeFeatureOfInterestInObservations();
    
    /**
     * Gets (as xml) the "encodeFeatureOfInterestInObservations" element
     */
    org.apache.xmlbeans.XmlBoolean xgetEncodeFeatureOfInterestInObservations();
    
    /**
     * Sets the "encodeFeatureOfInterestInObservations" element
     */
    void setEncodeFeatureOfInterestInObservations(boolean encodeFeatureOfInterestInObservations);
    
    /**
     * Sets (as xml) the "encodeFeatureOfInterestInObservations" element
     */
    void xsetEncodeFeatureOfInterestInObservations(org.apache.xmlbeans.XmlBoolean encodeFeatureOfInterestInObservations);
    
    /**
     * Gets the "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    java.lang.String getEncodingNamespaceForFeatureOfInterestEncoding();
    
    /**
     * Gets (as xml) the "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetEncodingNamespaceForFeatureOfInterestEncoding();
    
    /**
     * True if has "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    boolean isSetEncodingNamespaceForFeatureOfInterestEncoding();
    
    /**
     * Sets the "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    void setEncodingNamespaceForFeatureOfInterestEncoding(java.lang.String encodingNamespaceForFeatureOfInterestEncoding);
    
    /**
     * Sets (as xml) the "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    void xsetEncodingNamespaceForFeatureOfInterestEncoding(org.apache.xmlbeans.XmlAnyURI encodingNamespaceForFeatureOfInterestEncoding);
    
    /**
     * Unsets the "encodingNamespaceForFeatureOfInterestEncoding" element
     */
    void unsetEncodingNamespaceForFeatureOfInterestEncoding();
    
    /**
     * Gets the "showMetadataOfEmptyObservations" element
     */
    boolean getShowMetadataOfEmptyObservations();
    
    /**
     * Gets (as xml) the "showMetadataOfEmptyObservations" element
     */
    org.apache.xmlbeans.XmlBoolean xgetShowMetadataOfEmptyObservations();
    
    /**
     * Sets the "showMetadataOfEmptyObservations" element
     */
    void setShowMetadataOfEmptyObservations(boolean showMetadataOfEmptyObservations);
    
    /**
     * Sets (as xml) the "showMetadataOfEmptyObservations" element
     */
    void xsetShowMetadataOfEmptyObservations(org.apache.xmlbeans.XmlBoolean showMetadataOfEmptyObservations);
    
    /**
     * Gets the "listFeatureOfInterestsInOfferings" element
     */
    boolean getListFeatureOfInterestsInOfferings();
    
    /**
     * Gets (as xml) the "listFeatureOfInterestsInOfferings" element
     */
    org.apache.xmlbeans.XmlBoolean xgetListFeatureOfInterestsInOfferings();
    
    /**
     * Sets the "listFeatureOfInterestsInOfferings" element
     */
    void setListFeatureOfInterestsInOfferings(boolean listFeatureOfInterestsInOfferings);
    
    /**
     * Sets (as xml) the "listFeatureOfInterestsInOfferings" element
     */
    void xsetListFeatureOfInterestsInOfferings(org.apache.xmlbeans.XmlBoolean listFeatureOfInterestsInOfferings);
    
    /**
     * Gets the "encodeChildProcedureDescriptions" element
     */
    boolean getEncodeChildProcedureDescriptions();
    
    /**
     * Gets (as xml) the "encodeChildProcedureDescriptions" element
     */
    org.apache.xmlbeans.XmlBoolean xgetEncodeChildProcedureDescriptions();
    
    /**
     * Sets the "encodeChildProcedureDescriptions" element
     */
    void setEncodeChildProcedureDescriptions(boolean encodeChildProcedureDescriptions);
    
    /**
     * Sets (as xml) the "encodeChildProcedureDescriptions" element
     */
    void xsetEncodeChildProcedureDescriptions(org.apache.xmlbeans.XmlBoolean encodeChildProcedureDescriptions);
    
    /**
     * Gets the "showFullOperationsMetadata" element
     */
    boolean getShowFullOperationsMetadata();
    
    /**
     * Gets (as xml) the "showFullOperationsMetadata" element
     */
    org.apache.xmlbeans.XmlBoolean xgetShowFullOperationsMetadata();
    
    /**
     * Sets the "showFullOperationsMetadata" element
     */
    void setShowFullOperationsMetadata(boolean showFullOperationsMetadata);
    
    /**
     * Sets (as xml) the "showFullOperationsMetadata" element
     */
    void xsetShowFullOperationsMetadata(org.apache.xmlbeans.XmlBoolean showFullOperationsMetadata);
    
    /**
     * Gets the "showFullOperationsMetadataForObservations" element
     */
    boolean getShowFullOperationsMetadataForObservations();
    
    /**
     * Gets (as xml) the "showFullOperationsMetadataForObservations" element
     */
    org.apache.xmlbeans.XmlBoolean xgetShowFullOperationsMetadataForObservations();
    
    /**
     * Sets the "showFullOperationsMetadataForObservations" element
     */
    void setShowFullOperationsMetadataForObservations(boolean showFullOperationsMetadataForObservations);
    
    /**
     * Sets (as xml) the "showFullOperationsMetadataForObservations" element
     */
    void xsetShowFullOperationsMetadataForObservations(org.apache.xmlbeans.XmlBoolean showFullOperationsMetadataForObservations);
    
    /**
     * Gets the "allowSubsettingForSOS20OM20" element
     */
    boolean getAllowSubsettingForSOS20OM20();
    
    /**
     * Gets (as xml) the "allowSubsettingForSOS20OM20" element
     */
    org.apache.xmlbeans.XmlBoolean xgetAllowSubsettingForSOS20OM20();
    
    /**
     * Sets the "allowSubsettingForSOS20OM20" element
     */
    void setAllowSubsettingForSOS20OM20(boolean allowSubsettingForSOS20OM20);
    
    /**
     * Sets (as xml) the "allowSubsettingForSOS20OM20" element
     */
    void xsetAllowSubsettingForSOS20OM20(org.apache.xmlbeans.XmlBoolean allowSubsettingForSOS20OM20);
    
    /**
     * Gets the "mergeValues" element
     */
    boolean getMergeValues();
    
    /**
     * Gets (as xml) the "mergeValues" element
     */
    org.apache.xmlbeans.XmlBoolean xgetMergeValues();
    
    /**
     * Sets the "mergeValues" element
     */
    void setMergeValues(boolean mergeValues);
    
    /**
     * Sets (as xml) the "mergeValues" element
     */
    void xsetMergeValues(org.apache.xmlbeans.XmlBoolean mergeValues);
    
    /**
     * Gets the "NoDataPlaceholder" element
     */
    org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder getNoDataPlaceholder();
    
    /**
     * Sets the "NoDataPlaceholder" element
     */
    void setNoDataPlaceholder(org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder noDataPlaceholder);
    
    /**
     * Appends and returns a new empty "NoDataPlaceholder" element
     */
    org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder addNewNoDataPlaceholder();
    
    /**
     * Gets the "returnLatestValueIfTemporalFilterIsMissingInGetObservation" element
     */
    boolean getReturnLatestValueIfTemporalFilterIsMissingInGetObservation();
    
    /**
     * Gets (as xml) the "returnLatestValueIfTemporalFilterIsMissingInGetObservation" element
     */
    org.apache.xmlbeans.XmlBoolean xgetReturnLatestValueIfTemporalFilterIsMissingInGetObservation();
    
    /**
     * Sets the "returnLatestValueIfTemporalFilterIsMissingInGetObservation" element
     */
    void setReturnLatestValueIfTemporalFilterIsMissingInGetObservation(boolean returnLatestValueIfTemporalFilterIsMissingInGetObservation);
    
    /**
     * Sets (as xml) the "returnLatestValueIfTemporalFilterIsMissingInGetObservation" element
     */
    void xsetReturnLatestValueIfTemporalFilterIsMissingInGetObservation(org.apache.xmlbeans.XmlBoolean returnLatestValueIfTemporalFilterIsMissingInGetObservation);
    
    /**
     * Gets array of all "EncodeProcedure" elements
     */
    org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure[] getEncodeProcedureArray();
    
    /**
     * Gets ith "EncodeProcedure" element
     */
    org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure getEncodeProcedureArray(int i);
    
    /**
     * Returns number of "EncodeProcedure" element
     */
    int sizeOfEncodeProcedureArray();
    
    /**
     * Sets array of all "EncodeProcedure" element
     */
    void setEncodeProcedureArray(org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure[] encodeProcedureArray);
    
    /**
     * Sets ith "EncodeProcedure" element
     */
    void setEncodeProcedureArray(int i, org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure encodeProcedure);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "EncodeProcedure" element
     */
    org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure insertNewEncodeProcedure(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "EncodeProcedure" element
     */
    org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure addNewEncodeProcedure();
    
    /**
     * Removes the ith "EncodeProcedure" element
     */
    void removeEncodeProcedure(int i);
    
    /**
     * Gets array of all "DefaultObservationTypesForEncoding" elements
     */
    org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding[] getDefaultObservationTypesForEncodingArray();
    
    /**
     * Gets ith "DefaultObservationTypesForEncoding" element
     */
    org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding getDefaultObservationTypesForEncodingArray(int i);
    
    /**
     * Returns number of "DefaultObservationTypesForEncoding" element
     */
    int sizeOfDefaultObservationTypesForEncodingArray();
    
    /**
     * Sets array of all "DefaultObservationTypesForEncoding" element
     */
    void setDefaultObservationTypesForEncodingArray(org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding[] defaultObservationTypesForEncodingArray);
    
    /**
     * Sets ith "DefaultObservationTypesForEncoding" element
     */
    void setDefaultObservationTypesForEncodingArray(int i, org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding defaultObservationTypesForEncoding);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "DefaultObservationTypesForEncoding" element
     */
    org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding insertNewDefaultObservationTypesForEncoding(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "DefaultObservationTypesForEncoding" element
     */
    org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding addNewDefaultObservationTypesForEncoding();
    
    /**
     * Removes the ith "DefaultObservationTypesForEncoding" element
     */
    void removeDefaultObservationTypesForEncoding(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.x52North.sensorweb.sos.profile.SosProfileType newInstance() {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.x52North.sensorweb.sos.profile.SosProfileType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.x52North.sensorweb.sos.profile.SosProfileType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

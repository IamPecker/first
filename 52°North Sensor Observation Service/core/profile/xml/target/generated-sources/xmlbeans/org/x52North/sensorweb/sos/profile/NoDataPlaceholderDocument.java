/*
 * An XML document type.
 * Localname: NoDataPlaceholder
 * Namespace: http://www.52north.org/sensorweb/sos/profile
 * Java type: org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument
 *
 * Automatically generated - do not modify.
 */
package org.x52North.sensorweb.sos.profile;


/**
 * A document containing one NoDataPlaceholder(@http://www.52north.org/sensorweb/sos/profile) element.
 *
 * This is a complex type.
 */
public interface NoDataPlaceholderDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(NoDataPlaceholderDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sA9EDFA21CC6AEFC37448615A3EEC3294").resolveHandle("nodataplaceholder8873doctype");
    
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
     * An XML NoDataPlaceholder(@http://www.52north.org/sensorweb/sos/profile).
     *
     * This is a complex type.
     */
    public interface NoDataPlaceholder extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(NoDataPlaceholder.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sA9EDFA21CC6AEFC37448615A3EEC3294").resolveHandle("nodataplaceholdere53felemtype");
        
        /**
         * Gets the "responsePlaceholder" element
         */
        java.lang.String getResponsePlaceholder();
        
        /**
         * Gets (as xml) the "responsePlaceholder" element
         */
        org.apache.xmlbeans.XmlString xgetResponsePlaceholder();
        
        /**
         * Sets the "responsePlaceholder" element
         */
        void setResponsePlaceholder(java.lang.String responsePlaceholder);
        
        /**
         * Sets (as xml) the "responsePlaceholder" element
         */
        void xsetResponsePlaceholder(org.apache.xmlbeans.XmlString responsePlaceholder);
        
        /**
         * Gets array of all "placeholder" elements
         */
        java.lang.String[] getPlaceholderArray();
        
        /**
         * Gets ith "placeholder" element
         */
        java.lang.String getPlaceholderArray(int i);
        
        /**
         * Gets (as xml) array of all "placeholder" elements
         */
        org.apache.xmlbeans.XmlString[] xgetPlaceholderArray();
        
        /**
         * Gets (as xml) ith "placeholder" element
         */
        org.apache.xmlbeans.XmlString xgetPlaceholderArray(int i);
        
        /**
         * Returns number of "placeholder" element
         */
        int sizeOfPlaceholderArray();
        
        /**
         * Sets array of all "placeholder" element
         */
        void setPlaceholderArray(java.lang.String[] placeholderArray);
        
        /**
         * Sets ith "placeholder" element
         */
        void setPlaceholderArray(int i, java.lang.String placeholder);
        
        /**
         * Sets (as xml) array of all "placeholder" element
         */
        void xsetPlaceholderArray(org.apache.xmlbeans.XmlString[] placeholderArray);
        
        /**
         * Sets (as xml) ith "placeholder" element
         */
        void xsetPlaceholderArray(int i, org.apache.xmlbeans.XmlString placeholder);
        
        /**
         * Inserts the value as the ith "placeholder" element
         */
        void insertPlaceholder(int i, java.lang.String placeholder);
        
        /**
         * Appends the value as the last "placeholder" element
         */
        void addPlaceholder(java.lang.String placeholder);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "placeholder" element
         */
        org.apache.xmlbeans.XmlString insertNewPlaceholder(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "placeholder" element
         */
        org.apache.xmlbeans.XmlString addNewPlaceholder();
        
        /**
         * Removes the ith "placeholder" element
         */
        void removePlaceholder(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder newInstance() {
              return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument newInstance() {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

/*
 * An XML document type.
 * Localname: EncodeProcedure
 * Namespace: http://www.52north.org/sensorweb/sos/profile
 * Java type: org.x52North.sensorweb.sos.profile.EncodeProcedureDocument
 *
 * Automatically generated - do not modify.
 */
package org.x52North.sensorweb.sos.profile;


/**
 * A document containing one EncodeProcedure(@http://www.52north.org/sensorweb/sos/profile) element.
 *
 * This is a complex type.
 */
public interface EncodeProcedureDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EncodeProcedureDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sA9EDFA21CC6AEFC37448615A3EEC3294").resolveHandle("encodeprocedure36dedoctype");
    
    /**
     * Gets the "EncodeProcedure" element
     */
    org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure getEncodeProcedure();
    
    /**
     * Sets the "EncodeProcedure" element
     */
    void setEncodeProcedure(org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure encodeProcedure);
    
    /**
     * Appends and returns a new empty "EncodeProcedure" element
     */
    org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure addNewEncodeProcedure();
    
    /**
     * An XML EncodeProcedure(@http://www.52north.org/sensorweb/sos/profile).
     *
     * This is a complex type.
     */
    public interface EncodeProcedure extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EncodeProcedure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sA9EDFA21CC6AEFC37448615A3EEC3294").resolveHandle("encodeprocedure5c15elemtype");
        
        /**
         * Gets the "namespace" element
         */
        java.lang.String getNamespace();
        
        /**
         * Gets (as xml) the "namespace" element
         */
        org.apache.xmlbeans.XmlAnyURI xgetNamespace();
        
        /**
         * Sets the "namespace" element
         */
        void setNamespace(java.lang.String namespace);
        
        /**
         * Sets (as xml) the "namespace" element
         */
        void xsetNamespace(org.apache.xmlbeans.XmlAnyURI namespace);
        
        /**
         * Gets the "encode" element
         */
        boolean getEncode();
        
        /**
         * Gets (as xml) the "encode" element
         */
        org.apache.xmlbeans.XmlBoolean xgetEncode();
        
        /**
         * Sets the "encode" element
         */
        void setEncode(boolean encode);
        
        /**
         * Sets (as xml) the "encode" element
         */
        void xsetEncode(org.apache.xmlbeans.XmlBoolean encode);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure newInstance() {
              return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument newInstance() {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.x52North.sensorweb.sos.profile.EncodeProcedureDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

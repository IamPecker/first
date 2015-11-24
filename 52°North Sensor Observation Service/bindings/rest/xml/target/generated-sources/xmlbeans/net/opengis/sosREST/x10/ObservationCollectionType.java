/*
 * XML Type:  ObservationCollectionType
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.ObservationCollectionType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10;


/**
 * An XML ObservationCollectionType(@http://www.opengis.net/sosREST/1.0).
 *
 * This is a complex type.
 */
public interface ObservationCollectionType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ObservationCollectionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s1F42B53AC1C5BCA7D16C683ABB571955").resolveHandle("observationcollectiontype5d52type");
    
    /**
     * Gets array of all "Observation" elements
     */
    net.opengis.sosREST.x10.ObservationType[] getObservationArray();
    
    /**
     * Gets ith "Observation" element
     */
    net.opengis.sosREST.x10.ObservationType getObservationArray(int i);
    
    /**
     * Returns number of "Observation" element
     */
    int sizeOfObservationArray();
    
    /**
     * Sets array of all "Observation" element
     */
    void setObservationArray(net.opengis.sosREST.x10.ObservationType[] observationArray);
    
    /**
     * Sets ith "Observation" element
     */
    void setObservationArray(int i, net.opengis.sosREST.x10.ObservationType observation);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Observation" element
     */
    net.opengis.sosREST.x10.ObservationType insertNewObservation(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Observation" element
     */
    net.opengis.sosREST.x10.ObservationType addNewObservation();
    
    /**
     * Removes the ith "Observation" element
     */
    void removeObservation(int i);
    
    /**
     * Gets array of all "link" elements
     */
    net.opengis.sosREST.x10.LinkType[] getLinkArray();
    
    /**
     * Gets ith "link" element
     */
    net.opengis.sosREST.x10.LinkType getLinkArray(int i);
    
    /**
     * Returns number of "link" element
     */
    int sizeOfLinkArray();
    
    /**
     * Sets array of all "link" element
     */
    void setLinkArray(net.opengis.sosREST.x10.LinkType[] linkArray);
    
    /**
     * Sets ith "link" element
     */
    void setLinkArray(int i, net.opengis.sosREST.x10.LinkType link);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "link" element
     */
    net.opengis.sosREST.x10.LinkType insertNewLink(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "link" element
     */
    net.opengis.sosREST.x10.LinkType addNewLink();
    
    /**
     * Removes the ith "link" element
     */
    void removeLink(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.sosREST.x10.ObservationCollectionType newInstance() {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.sosREST.x10.ObservationCollectionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.sosREST.x10.ObservationCollectionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

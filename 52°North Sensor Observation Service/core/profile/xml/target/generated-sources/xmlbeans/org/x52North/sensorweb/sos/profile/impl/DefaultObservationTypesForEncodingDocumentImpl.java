/*
 * An XML document type.
 * Localname: DefaultObservationTypesForEncoding
 * Namespace: http://www.52north.org/sensorweb/sos/profile
 * Java type: org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument
 *
 * Automatically generated - do not modify.
 */
package org.x52North.sensorweb.sos.profile.impl;
/**
 * A document containing one DefaultObservationTypesForEncoding(@http://www.52north.org/sensorweb/sos/profile) element.
 *
 * This is a complex type.
 */
public class DefaultObservationTypesForEncodingDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument
{
    private static final long serialVersionUID = 1L;
    
    public DefaultObservationTypesForEncodingDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DEFAULTOBSERVATIONTYPESFORENCODING$0 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "DefaultObservationTypesForEncoding");
    
    
    /**
     * Gets the "DefaultObservationTypesForEncoding" element
     */
    public org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding getDefaultObservationTypesForEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding target = null;
            target = (org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding)get_store().find_element_user(DEFAULTOBSERVATIONTYPESFORENCODING$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "DefaultObservationTypesForEncoding" element
     */
    public void setDefaultObservationTypesForEncoding(org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding defaultObservationTypesForEncoding)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding target = null;
            target = (org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding)get_store().find_element_user(DEFAULTOBSERVATIONTYPESFORENCODING$0, 0);
            if (target == null)
            {
                target = (org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding)get_store().add_element_user(DEFAULTOBSERVATIONTYPESFORENCODING$0);
            }
            target.set(defaultObservationTypesForEncoding);
        }
    }
    
    /**
     * Appends and returns a new empty "DefaultObservationTypesForEncoding" element
     */
    public org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding addNewDefaultObservationTypesForEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding target = null;
            target = (org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding)get_store().add_element_user(DEFAULTOBSERVATIONTYPESFORENCODING$0);
            return target;
        }
    }
    /**
     * An XML DefaultObservationTypesForEncoding(@http://www.52north.org/sensorweb/sos/profile).
     *
     * This is a complex type.
     */
    public static class DefaultObservationTypesForEncodingImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.x52North.sensorweb.sos.profile.DefaultObservationTypesForEncodingDocument.DefaultObservationTypesForEncoding
    {
        private static final long serialVersionUID = 1L;
        
        public DefaultObservationTypesForEncodingImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAMESPACE$0 = 
            new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "namespace");
        private static final javax.xml.namespace.QName OBSERVATIONTYPE$2 = 
            new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "observationType");
        
        
        /**
         * Gets the "namespace" element
         */
        public java.lang.String getNamespace()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAMESPACE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "namespace" element
         */
        public org.apache.xmlbeans.XmlAnyURI xgetNamespace()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(NAMESPACE$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "namespace" element
         */
        public void setNamespace(java.lang.String namespace)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAMESPACE$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NAMESPACE$0);
                }
                target.setStringValue(namespace);
            }
        }
        
        /**
         * Sets (as xml) the "namespace" element
         */
        public void xsetNamespace(org.apache.xmlbeans.XmlAnyURI namespace)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(NAMESPACE$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(NAMESPACE$0);
                }
                target.set(namespace);
            }
        }
        
        /**
         * Gets the "observationType" element
         */
        public java.lang.String getObservationType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OBSERVATIONTYPE$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "observationType" element
         */
        public org.apache.xmlbeans.XmlAnyURI xgetObservationType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(OBSERVATIONTYPE$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "observationType" element
         */
        public void setObservationType(java.lang.String observationType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OBSERVATIONTYPE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OBSERVATIONTYPE$2);
                }
                target.setStringValue(observationType);
            }
        }
        
        /**
         * Sets (as xml) the "observationType" element
         */
        public void xsetObservationType(org.apache.xmlbeans.XmlAnyURI observationType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(OBSERVATIONTYPE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(OBSERVATIONTYPE$2);
                }
                target.set(observationType);
            }
        }
    }
}

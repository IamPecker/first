/*
 * An XML document type.
 * Localname: EncodeProcedure
 * Namespace: http://www.52north.org/sensorweb/sos/profile
 * Java type: org.x52North.sensorweb.sos.profile.EncodeProcedureDocument
 *
 * Automatically generated - do not modify.
 */
package org.x52North.sensorweb.sos.profile.impl;
/**
 * A document containing one EncodeProcedure(@http://www.52north.org/sensorweb/sos/profile) element.
 *
 * This is a complex type.
 */
public class EncodeProcedureDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.x52North.sensorweb.sos.profile.EncodeProcedureDocument
{
    private static final long serialVersionUID = 1L;
    
    public EncodeProcedureDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENCODEPROCEDURE$0 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "EncodeProcedure");
    
    
    /**
     * Gets the "EncodeProcedure" element
     */
    public org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure getEncodeProcedure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure target = null;
            target = (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure)get_store().find_element_user(ENCODEPROCEDURE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "EncodeProcedure" element
     */
    public void setEncodeProcedure(org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure encodeProcedure)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure target = null;
            target = (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure)get_store().find_element_user(ENCODEPROCEDURE$0, 0);
            if (target == null)
            {
                target = (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure)get_store().add_element_user(ENCODEPROCEDURE$0);
            }
            target.set(encodeProcedure);
        }
    }
    
    /**
     * Appends and returns a new empty "EncodeProcedure" element
     */
    public org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure addNewEncodeProcedure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure target = null;
            target = (org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure)get_store().add_element_user(ENCODEPROCEDURE$0);
            return target;
        }
    }
    /**
     * An XML EncodeProcedure(@http://www.52north.org/sensorweb/sos/profile).
     *
     * This is a complex type.
     */
    public static class EncodeProcedureImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.x52North.sensorweb.sos.profile.EncodeProcedureDocument.EncodeProcedure
    {
        private static final long serialVersionUID = 1L;
        
        public EncodeProcedureImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAMESPACE$0 = 
            new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "namespace");
        private static final javax.xml.namespace.QName ENCODE$2 = 
            new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "encode");
        
        
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
         * Gets the "encode" element
         */
        public boolean getEncode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODE$2, 0);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "encode" element
         */
        public org.apache.xmlbeans.XmlBoolean xgetEncode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ENCODE$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "encode" element
         */
        public void setEncode(boolean encode)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODE$2);
                }
                target.setBooleanValue(encode);
            }
        }
        
        /**
         * Sets (as xml) the "encode" element
         */
        public void xsetEncode(org.apache.xmlbeans.XmlBoolean encode)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ENCODE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(ENCODE$2);
                }
                target.set(encode);
            }
        }
    }
}

/*
 * An XML document type.
 * Localname: SosProfile
 * Namespace: http://www.52north.org/sensorweb/sos/profile
 * Java type: org.x52North.sensorweb.sos.profile.SosProfileDocument
 *
 * Automatically generated - do not modify.
 */
package org.x52North.sensorweb.sos.profile.impl;
/**
 * A document containing one SosProfile(@http://www.52north.org/sensorweb/sos/profile) element.
 *
 * This is a complex type.
 */
public class SosProfileDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.x52North.sensorweb.sos.profile.SosProfileDocument
{
    private static final long serialVersionUID = 1L;
    
    public SosProfileDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SOSPROFILE$0 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "SosProfile");
    
    
    /**
     * Gets the "SosProfile" element
     */
    public org.x52North.sensorweb.sos.profile.SosProfileType getSosProfile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.SosProfileType target = null;
            target = (org.x52North.sensorweb.sos.profile.SosProfileType)get_store().find_element_user(SOSPROFILE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SosProfile" element
     */
    public void setSosProfile(org.x52North.sensorweb.sos.profile.SosProfileType sosProfile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.SosProfileType target = null;
            target = (org.x52North.sensorweb.sos.profile.SosProfileType)get_store().find_element_user(SOSPROFILE$0, 0);
            if (target == null)
            {
                target = (org.x52North.sensorweb.sos.profile.SosProfileType)get_store().add_element_user(SOSPROFILE$0);
            }
            target.set(sosProfile);
        }
    }
    
    /**
     * Appends and returns a new empty "SosProfile" element
     */
    public org.x52North.sensorweb.sos.profile.SosProfileType addNewSosProfile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.SosProfileType target = null;
            target = (org.x52North.sensorweb.sos.profile.SosProfileType)get_store().add_element_user(SOSPROFILE$0);
            return target;
        }
    }
}

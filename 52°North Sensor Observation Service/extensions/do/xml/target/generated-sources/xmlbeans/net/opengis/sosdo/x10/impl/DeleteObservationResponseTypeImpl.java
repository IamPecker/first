/*
 * XML Type:  DeleteObservationResponseType
 * Namespace: http://www.opengis.net/sosdo/1.0
 * Java type: net.opengis.sosdo.x10.DeleteObservationResponseType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosdo.x10.impl;
/**
 * An XML DeleteObservationResponseType(@http://www.opengis.net/sosdo/1.0).
 *
 * This is a complex type.
 */
public class DeleteObservationResponseTypeImpl extends net.opengis.swes.x20.impl.ExtensibleResponseTypeImpl implements net.opengis.sosdo.x10.DeleteObservationResponseType
{
    private static final long serialVersionUID = 1L;
    
    public DeleteObservationResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DELETEDOBSERVATION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosdo/1.0", "deletedObservation");
    
    
    /**
     * Gets the "deletedObservation" element
     */
    public java.lang.String getDeletedObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DELETEDOBSERVATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "deletedObservation" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetDeletedObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(DELETEDOBSERVATION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "deletedObservation" element
     */
    public void setDeletedObservation(java.lang.String deletedObservation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DELETEDOBSERVATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DELETEDOBSERVATION$0);
            }
            target.setStringValue(deletedObservation);
        }
    }
    
    /**
     * Sets (as xml) the "deletedObservation" element
     */
    public void xsetDeletedObservation(org.apache.xmlbeans.XmlAnyURI deletedObservation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(DELETEDOBSERVATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(DELETEDOBSERVATION$0);
            }
            target.set(deletedObservation);
        }
    }
}

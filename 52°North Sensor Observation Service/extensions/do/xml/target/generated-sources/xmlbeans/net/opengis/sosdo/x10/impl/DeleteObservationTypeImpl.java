/*
 * XML Type:  DeleteObservationType
 * Namespace: http://www.opengis.net/sosdo/1.0
 * Java type: net.opengis.sosdo.x10.DeleteObservationType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosdo.x10.impl;
/**
 * An XML DeleteObservationType(@http://www.opengis.net/sosdo/1.0).
 *
 * This is a complex type.
 */
public class DeleteObservationTypeImpl extends net.opengis.swes.x20.impl.ExtensibleRequestTypeImpl implements net.opengis.sosdo.x10.DeleteObservationType
{
    private static final long serialVersionUID = 1L;
    
    public DeleteObservationTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OBSERVATION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosdo/1.0", "observation");
    
    
    /**
     * Gets the "observation" element
     */
    public java.lang.String getObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OBSERVATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "observation" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(OBSERVATION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "observation" element
     */
    public void setObservation(java.lang.String observation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OBSERVATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OBSERVATION$0);
            }
            target.setStringValue(observation);
        }
    }
    
    /**
     * Sets (as xml) the "observation" element
     */
    public void xsetObservation(org.apache.xmlbeans.XmlAnyURI observation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(OBSERVATION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(OBSERVATION$0);
            }
            target.set(observation);
        }
    }
}

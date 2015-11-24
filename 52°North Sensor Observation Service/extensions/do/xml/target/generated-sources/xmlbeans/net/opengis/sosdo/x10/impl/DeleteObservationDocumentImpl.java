/*
 * An XML document type.
 * Localname: DeleteObservation
 * Namespace: http://www.opengis.net/sosdo/1.0
 * Java type: net.opengis.sosdo.x10.DeleteObservationDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosdo.x10.impl;
/**
 * A document containing one DeleteObservation(@http://www.opengis.net/sosdo/1.0) element.
 *
 * This is a complex type.
 */
public class DeleteObservationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosdo.x10.DeleteObservationDocument
{
    private static final long serialVersionUID = 1L;
    
    public DeleteObservationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DELETEOBSERVATION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosdo/1.0", "DeleteObservation");
    
    
    /**
     * Gets the "DeleteObservation" element
     */
    public net.opengis.sosdo.x10.DeleteObservationType getDeleteObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosdo.x10.DeleteObservationType target = null;
            target = (net.opengis.sosdo.x10.DeleteObservationType)get_store().find_element_user(DELETEOBSERVATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "DeleteObservation" element
     */
    public void setDeleteObservation(net.opengis.sosdo.x10.DeleteObservationType deleteObservation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosdo.x10.DeleteObservationType target = null;
            target = (net.opengis.sosdo.x10.DeleteObservationType)get_store().find_element_user(DELETEOBSERVATION$0, 0);
            if (target == null)
            {
                target = (net.opengis.sosdo.x10.DeleteObservationType)get_store().add_element_user(DELETEOBSERVATION$0);
            }
            target.set(deleteObservation);
        }
    }
    
    /**
     * Appends and returns a new empty "DeleteObservation" element
     */
    public net.opengis.sosdo.x10.DeleteObservationType addNewDeleteObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosdo.x10.DeleteObservationType target = null;
            target = (net.opengis.sosdo.x10.DeleteObservationType)get_store().add_element_user(DELETEOBSERVATION$0);
            return target;
        }
    }
}

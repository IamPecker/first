/*
 * An XML document type.
 * Localname: DeleteObservationResponse
 * Namespace: http://www.opengis.net/sosdo/1.0
 * Java type: net.opengis.sosdo.x10.DeleteObservationResponseDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosdo.x10.impl;
/**
 * A document containing one DeleteObservationResponse(@http://www.opengis.net/sosdo/1.0) element.
 *
 * This is a complex type.
 */
public class DeleteObservationResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosdo.x10.DeleteObservationResponseDocument
{
    private static final long serialVersionUID = 1L;
    
    public DeleteObservationResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DELETEOBSERVATIONRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosdo/1.0", "DeleteObservationResponse");
    
    
    /**
     * Gets the "DeleteObservationResponse" element
     */
    public net.opengis.sosdo.x10.DeleteObservationResponseType getDeleteObservationResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosdo.x10.DeleteObservationResponseType target = null;
            target = (net.opengis.sosdo.x10.DeleteObservationResponseType)get_store().find_element_user(DELETEOBSERVATIONRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "DeleteObservationResponse" element
     */
    public void setDeleteObservationResponse(net.opengis.sosdo.x10.DeleteObservationResponseType deleteObservationResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosdo.x10.DeleteObservationResponseType target = null;
            target = (net.opengis.sosdo.x10.DeleteObservationResponseType)get_store().find_element_user(DELETEOBSERVATIONRESPONSE$0, 0);
            if (target == null)
            {
                target = (net.opengis.sosdo.x10.DeleteObservationResponseType)get_store().add_element_user(DELETEOBSERVATIONRESPONSE$0);
            }
            target.set(deleteObservationResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "DeleteObservationResponse" element
     */
    public net.opengis.sosdo.x10.DeleteObservationResponseType addNewDeleteObservationResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosdo.x10.DeleteObservationResponseType target = null;
            target = (net.opengis.sosdo.x10.DeleteObservationResponseType)get_store().add_element_user(DELETEOBSERVATIONRESPONSE$0);
            return target;
        }
    }
}

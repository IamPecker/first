/*
 * An XML document type.
 * Localname: ObservationOffering
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.ObservationOfferingDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * A document containing one ObservationOffering(@http://www.opengis.net/sosREST/1.0) element.
 *
 * This is a complex type.
 */
public class ObservationOfferingDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.ObservationOfferingDocument
{
    private static final long serialVersionUID = 1L;
    
    public ObservationOfferingDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OBSERVATIONOFFERING$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "ObservationOffering");
    
    
    /**
     * Gets the "ObservationOffering" element
     */
    public net.opengis.sosREST.x10.ObservationOfferingType getObservationOffering()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationOfferingType target = null;
            target = (net.opengis.sosREST.x10.ObservationOfferingType)get_store().find_element_user(OBSERVATIONOFFERING$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ObservationOffering" element
     */
    public void setObservationOffering(net.opengis.sosREST.x10.ObservationOfferingType observationOffering)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationOfferingType target = null;
            target = (net.opengis.sosREST.x10.ObservationOfferingType)get_store().find_element_user(OBSERVATIONOFFERING$0, 0);
            if (target == null)
            {
                target = (net.opengis.sosREST.x10.ObservationOfferingType)get_store().add_element_user(OBSERVATIONOFFERING$0);
            }
            target.set(observationOffering);
        }
    }
    
    /**
     * Appends and returns a new empty "ObservationOffering" element
     */
    public net.opengis.sosREST.x10.ObservationOfferingType addNewObservationOffering()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationOfferingType target = null;
            target = (net.opengis.sosREST.x10.ObservationOfferingType)get_store().add_element_user(OBSERVATIONOFFERING$0);
            return target;
        }
    }
}

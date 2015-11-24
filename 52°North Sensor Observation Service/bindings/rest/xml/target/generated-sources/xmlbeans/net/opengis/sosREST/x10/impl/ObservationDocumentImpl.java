/*
 * An XML document type.
 * Localname: Observation
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.ObservationDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * A document containing one Observation(@http://www.opengis.net/sosREST/1.0) element.
 *
 * This is a complex type.
 */
public class ObservationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.ObservationDocument
{
    private static final long serialVersionUID = 1L;
    
    public ObservationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OBSERVATION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "Observation");
    
    
    /**
     * Gets the "Observation" element
     */
    public net.opengis.sosREST.x10.ObservationType getObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationType target = null;
            target = (net.opengis.sosREST.x10.ObservationType)get_store().find_element_user(OBSERVATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Observation" element
     */
    public void setObservation(net.opengis.sosREST.x10.ObservationType observation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationType target = null;
            target = (net.opengis.sosREST.x10.ObservationType)get_store().find_element_user(OBSERVATION$0, 0);
            if (target == null)
            {
                target = (net.opengis.sosREST.x10.ObservationType)get_store().add_element_user(OBSERVATION$0);
            }
            target.set(observation);
        }
    }
    
    /**
     * Appends and returns a new empty "Observation" element
     */
    public net.opengis.sosREST.x10.ObservationType addNewObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationType target = null;
            target = (net.opengis.sosREST.x10.ObservationType)get_store().add_element_user(OBSERVATION$0);
            return target;
        }
    }
}

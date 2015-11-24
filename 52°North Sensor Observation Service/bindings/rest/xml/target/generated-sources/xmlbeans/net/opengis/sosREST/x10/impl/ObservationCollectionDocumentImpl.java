/*
 * An XML document type.
 * Localname: ObservationCollection
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.ObservationCollectionDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * A document containing one ObservationCollection(@http://www.opengis.net/sosREST/1.0) element.
 *
 * This is a complex type.
 */
public class ObservationCollectionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.ObservationCollectionDocument
{
    private static final long serialVersionUID = 1L;
    
    public ObservationCollectionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OBSERVATIONCOLLECTION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "ObservationCollection");
    
    
    /**
     * Gets the "ObservationCollection" element
     */
    public net.opengis.sosREST.x10.ObservationCollectionType getObservationCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationCollectionType target = null;
            target = (net.opengis.sosREST.x10.ObservationCollectionType)get_store().find_element_user(OBSERVATIONCOLLECTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ObservationCollection" element
     */
    public void setObservationCollection(net.opengis.sosREST.x10.ObservationCollectionType observationCollection)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationCollectionType target = null;
            target = (net.opengis.sosREST.x10.ObservationCollectionType)get_store().find_element_user(OBSERVATIONCOLLECTION$0, 0);
            if (target == null)
            {
                target = (net.opengis.sosREST.x10.ObservationCollectionType)get_store().add_element_user(OBSERVATIONCOLLECTION$0);
            }
            target.set(observationCollection);
        }
    }
    
    /**
     * Appends and returns a new empty "ObservationCollection" element
     */
    public net.opengis.sosREST.x10.ObservationCollectionType addNewObservationCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationCollectionType target = null;
            target = (net.opengis.sosREST.x10.ObservationCollectionType)get_store().add_element_user(OBSERVATIONCOLLECTION$0);
            return target;
        }
    }
}

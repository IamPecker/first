/*
 * An XML document type.
 * Localname: OfferingCollection
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.OfferingCollectionDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * A document containing one OfferingCollection(@http://www.opengis.net/sosREST/1.0) element.
 *
 * This is a complex type.
 */
public class OfferingCollectionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.OfferingCollectionDocument
{
    private static final long serialVersionUID = 1L;
    
    public OfferingCollectionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OFFERINGCOLLECTION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "OfferingCollection");
    
    
    /**
     * Gets the "OfferingCollection" element
     */
    public net.opengis.sosREST.x10.ResourceCollectionType getOfferingCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ResourceCollectionType target = null;
            target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().find_element_user(OFFERINGCOLLECTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "OfferingCollection" element
     */
    public void setOfferingCollection(net.opengis.sosREST.x10.ResourceCollectionType offeringCollection)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ResourceCollectionType target = null;
            target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().find_element_user(OFFERINGCOLLECTION$0, 0);
            if (target == null)
            {
                target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().add_element_user(OFFERINGCOLLECTION$0);
            }
            target.set(offeringCollection);
        }
    }
    
    /**
     * Appends and returns a new empty "OfferingCollection" element
     */
    public net.opengis.sosREST.x10.ResourceCollectionType addNewOfferingCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ResourceCollectionType target = null;
            target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().add_element_user(OFFERINGCOLLECTION$0);
            return target;
        }
    }
}

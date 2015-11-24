/*
 * An XML document type.
 * Localname: FeatureCollection
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.FeatureCollectionDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * A document containing one FeatureCollection(@http://www.opengis.net/sosREST/1.0) element.
 *
 * This is a complex type.
 */
public class FeatureCollectionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.FeatureCollectionDocument
{
    private static final long serialVersionUID = 1L;
    
    public FeatureCollectionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FEATURECOLLECTION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "FeatureCollection");
    
    
    /**
     * Gets the "FeatureCollection" element
     */
    public net.opengis.sosREST.x10.ResourceCollectionType getFeatureCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ResourceCollectionType target = null;
            target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().find_element_user(FEATURECOLLECTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "FeatureCollection" element
     */
    public void setFeatureCollection(net.opengis.sosREST.x10.ResourceCollectionType featureCollection)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ResourceCollectionType target = null;
            target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().find_element_user(FEATURECOLLECTION$0, 0);
            if (target == null)
            {
                target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().add_element_user(FEATURECOLLECTION$0);
            }
            target.set(featureCollection);
        }
    }
    
    /**
     * Appends and returns a new empty "FeatureCollection" element
     */
    public net.opengis.sosREST.x10.ResourceCollectionType addNewFeatureCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ResourceCollectionType target = null;
            target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().add_element_user(FEATURECOLLECTION$0);
            return target;
        }
    }
}

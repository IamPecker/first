/*
 * An XML document type.
 * Localname: Feature
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.FeatureDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * A document containing one Feature(@http://www.opengis.net/sosREST/1.0) element.
 *
 * This is a complex type.
 */
public class FeatureDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.FeatureDocument
{
    private static final long serialVersionUID = 1L;
    
    public FeatureDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FEATURE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "Feature");
    
    
    /**
     * Gets the "Feature" element
     */
    public net.opengis.sosREST.x10.FeatureType getFeature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.FeatureType target = null;
            target = (net.opengis.sosREST.x10.FeatureType)get_store().find_element_user(FEATURE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Feature" element
     */
    public void setFeature(net.opengis.sosREST.x10.FeatureType feature)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.FeatureType target = null;
            target = (net.opengis.sosREST.x10.FeatureType)get_store().find_element_user(FEATURE$0, 0);
            if (target == null)
            {
                target = (net.opengis.sosREST.x10.FeatureType)get_store().add_element_user(FEATURE$0);
            }
            target.set(feature);
        }
    }
    
    /**
     * Appends and returns a new empty "Feature" element
     */
    public net.opengis.sosREST.x10.FeatureType addNewFeature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.FeatureType target = null;
            target = (net.opengis.sosREST.x10.FeatureType)get_store().add_element_user(FEATURE$0);
            return target;
        }
    }
}

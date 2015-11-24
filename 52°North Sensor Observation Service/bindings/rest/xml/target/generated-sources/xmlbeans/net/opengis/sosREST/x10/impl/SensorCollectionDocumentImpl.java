/*
 * An XML document type.
 * Localname: SensorCollection
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.SensorCollectionDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * A document containing one SensorCollection(@http://www.opengis.net/sosREST/1.0) element.
 *
 * This is a complex type.
 */
public class SensorCollectionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.SensorCollectionDocument
{
    private static final long serialVersionUID = 1L;
    
    public SensorCollectionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SENSORCOLLECTION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "SensorCollection");
    
    
    /**
     * Gets the "SensorCollection" element
     */
    public net.opengis.sosREST.x10.ResourceCollectionType getSensorCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ResourceCollectionType target = null;
            target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().find_element_user(SENSORCOLLECTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "SensorCollection" element
     */
    public void setSensorCollection(net.opengis.sosREST.x10.ResourceCollectionType sensorCollection)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ResourceCollectionType target = null;
            target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().find_element_user(SENSORCOLLECTION$0, 0);
            if (target == null)
            {
                target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().add_element_user(SENSORCOLLECTION$0);
            }
            target.set(sensorCollection);
        }
    }
    
    /**
     * Appends and returns a new empty "SensorCollection" element
     */
    public net.opengis.sosREST.x10.ResourceCollectionType addNewSensorCollection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ResourceCollectionType target = null;
            target = (net.opengis.sosREST.x10.ResourceCollectionType)get_store().add_element_user(SENSORCOLLECTION$0);
            return target;
        }
    }
}

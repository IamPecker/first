/*
 * An XML document type.
 * Localname: Sensor
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.SensorDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * A document containing one Sensor(@http://www.opengis.net/sosREST/1.0) element.
 *
 * This is a complex type.
 */
public class SensorDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.SensorDocument
{
    private static final long serialVersionUID = 1L;
    
    public SensorDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SENSOR$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "Sensor");
    
    
    /**
     * Gets the "Sensor" element
     */
    public net.opengis.sosREST.x10.SensorType getSensor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.SensorType target = null;
            target = (net.opengis.sosREST.x10.SensorType)get_store().find_element_user(SENSOR$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Sensor" element
     */
    public void setSensor(net.opengis.sosREST.x10.SensorType sensor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.SensorType target = null;
            target = (net.opengis.sosREST.x10.SensorType)get_store().find_element_user(SENSOR$0, 0);
            if (target == null)
            {
                target = (net.opengis.sosREST.x10.SensorType)get_store().add_element_user(SENSOR$0);
            }
            target.set(sensor);
        }
    }
    
    /**
     * Appends and returns a new empty "Sensor" element
     */
    public net.opengis.sosREST.x10.SensorType addNewSensor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.SensorType target = null;
            target = (net.opengis.sosREST.x10.SensorType)get_store().add_element_user(SENSOR$0);
            return target;
        }
    }
}

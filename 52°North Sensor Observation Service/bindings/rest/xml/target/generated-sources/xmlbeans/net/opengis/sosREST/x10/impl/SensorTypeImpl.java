/*
 * XML Type:  SensorType
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.SensorType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * An XML SensorType(@http://www.opengis.net/sosREST/1.0).
 *
 * This is a complex type.
 */
public class SensorTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.SensorType
{
    private static final long serialVersionUID = 1L;
    
    public SensorTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESS$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sensorML/1.0.1", "_Process");
    private static final org.apache.xmlbeans.QNameSet PROCESS$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengis.net/sensorML/1.0.1", "ComponentArray"),
        new javax.xml.namespace.QName("http://www.opengis.net/sensorML/1.0.1", "ProcessChain"),
        new javax.xml.namespace.QName("http://www.opengis.net/sensorML/1.0.1", "System"),
        new javax.xml.namespace.QName("http://www.opengis.net/sensorML/1.0.1", "Component"),
        new javax.xml.namespace.QName("http://www.opengis.net/sensorML/1.0.1", "ProcessModel"),
        new javax.xml.namespace.QName("http://www.opengis.net/sensorML/1.0.1", "_Process"),
        new javax.xml.namespace.QName("http://www.opengis.net/sensorML/1.0.1", "DataSource"),
    });
    private static final javax.xml.namespace.QName LINK$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "link");
    
    
    /**
     * Gets the "_Process" element
     */
    public net.opengis.sensorML.x101.AbstractProcessType getProcess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sensorML.x101.AbstractProcessType target = null;
            target = (net.opengis.sensorML.x101.AbstractProcessType)get_store().find_element_user(PROCESS$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "_Process" element
     */
    public void setProcess(net.opengis.sensorML.x101.AbstractProcessType process)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sensorML.x101.AbstractProcessType target = null;
            target = (net.opengis.sensorML.x101.AbstractProcessType)get_store().find_element_user(PROCESS$1, 0);
            if (target == null)
            {
                target = (net.opengis.sensorML.x101.AbstractProcessType)get_store().add_element_user(PROCESS$0);
            }
            target.set(process);
        }
    }
    
    /**
     * Appends and returns a new empty "_Process" element
     */
    public net.opengis.sensorML.x101.AbstractProcessType addNewProcess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sensorML.x101.AbstractProcessType target = null;
            target = (net.opengis.sensorML.x101.AbstractProcessType)get_store().add_element_user(PROCESS$0);
            return target;
        }
    }
    
    /**
     * Gets array of all "link" elements
     */
    public net.opengis.sosREST.x10.LinkType[] getLinkArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(LINK$2, targetList);
            net.opengis.sosREST.x10.LinkType[] result = new net.opengis.sosREST.x10.LinkType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "link" element
     */
    public net.opengis.sosREST.x10.LinkType getLinkArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.LinkType target = null;
            target = (net.opengis.sosREST.x10.LinkType)get_store().find_element_user(LINK$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "link" element
     */
    public int sizeOfLinkArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(LINK$2);
        }
    }
    
    /**
     * Sets array of all "link" element
     */
    public void setLinkArray(net.opengis.sosREST.x10.LinkType[] linkArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(linkArray, LINK$2);
        }
    }
    
    /**
     * Sets ith "link" element
     */
    public void setLinkArray(int i, net.opengis.sosREST.x10.LinkType link)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.LinkType target = null;
            target = (net.opengis.sosREST.x10.LinkType)get_store().find_element_user(LINK$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(link);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "link" element
     */
    public net.opengis.sosREST.x10.LinkType insertNewLink(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.LinkType target = null;
            target = (net.opengis.sosREST.x10.LinkType)get_store().insert_element_user(LINK$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "link" element
     */
    public net.opengis.sosREST.x10.LinkType addNewLink()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.LinkType target = null;
            target = (net.opengis.sosREST.x10.LinkType)get_store().add_element_user(LINK$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "link" element
     */
    public void removeLink(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(LINK$2, i);
        }
    }
}

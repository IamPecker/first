/*
 * XML Type:  CapabilitiesType
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.CapabilitiesType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * An XML CapabilitiesType(@http://www.opengis.net/sosREST/1.0).
 *
 * This is a complex type.
 */
public class CapabilitiesTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.CapabilitiesType
{
    private static final long serialVersionUID = 1L;
    
    public CapabilitiesTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CAPABILITIES$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sos/2.0", "Capabilities");
    private static final javax.xml.namespace.QName LINK$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "link");
    
    
    /**
     * Gets the "Capabilities" element
     */
    public net.opengis.sos.x20.CapabilitiesType getCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sos.x20.CapabilitiesType target = null;
            target = (net.opengis.sos.x20.CapabilitiesType)get_store().find_element_user(CAPABILITIES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Capabilities" element
     */
    public void setCapabilities(net.opengis.sos.x20.CapabilitiesType capabilities)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sos.x20.CapabilitiesType target = null;
            target = (net.opengis.sos.x20.CapabilitiesType)get_store().find_element_user(CAPABILITIES$0, 0);
            if (target == null)
            {
                target = (net.opengis.sos.x20.CapabilitiesType)get_store().add_element_user(CAPABILITIES$0);
            }
            target.set(capabilities);
        }
    }
    
    /**
     * Appends and returns a new empty "Capabilities" element
     */
    public net.opengis.sos.x20.CapabilitiesType addNewCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sos.x20.CapabilitiesType target = null;
            target = (net.opengis.sos.x20.CapabilitiesType)get_store().add_element_user(CAPABILITIES$0);
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

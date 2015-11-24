/*
 * XML Type:  ObservationType
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.ObservationType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * An XML ObservationType(@http://www.opengis.net/sosREST/1.0).
 *
 * This is a complex type.
 */
public class ObservationTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.ObservationType
{
    private static final long serialVersionUID = 1L;
    
    public ObservationTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OMOBSERVATION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/om/2.0", "OM_Observation");
    private static final javax.xml.namespace.QName LINK$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "link");
    
    
    /**
     * Gets the "OM_Observation" element
     */
    public net.opengis.om.x20.OMObservationType getOMObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.om.x20.OMObservationType target = null;
            target = (net.opengis.om.x20.OMObservationType)get_store().find_element_user(OMOBSERVATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "OM_Observation" element
     */
    public void setOMObservation(net.opengis.om.x20.OMObservationType omObservation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.om.x20.OMObservationType target = null;
            target = (net.opengis.om.x20.OMObservationType)get_store().find_element_user(OMOBSERVATION$0, 0);
            if (target == null)
            {
                target = (net.opengis.om.x20.OMObservationType)get_store().add_element_user(OMOBSERVATION$0);
            }
            target.set(omObservation);
        }
    }
    
    /**
     * Appends and returns a new empty "OM_Observation" element
     */
    public net.opengis.om.x20.OMObservationType addNewOMObservation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.om.x20.OMObservationType target = null;
            target = (net.opengis.om.x20.OMObservationType)get_store().add_element_user(OMOBSERVATION$0);
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

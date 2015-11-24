/*
 * XML Type:  ObservationCollectionType
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.ObservationCollectionType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * An XML ObservationCollectionType(@http://www.opengis.net/sosREST/1.0).
 *
 * This is a complex type.
 */
public class ObservationCollectionTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.ObservationCollectionType
{
    private static final long serialVersionUID = 1L;
    
    public ObservationCollectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OBSERVATION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "Observation");
    private static final javax.xml.namespace.QName LINK$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "link");
    
    
    /**
     * Gets array of all "Observation" elements
     */
    public net.opengis.sosREST.x10.ObservationType[] getObservationArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OBSERVATION$0, targetList);
            net.opengis.sosREST.x10.ObservationType[] result = new net.opengis.sosREST.x10.ObservationType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Observation" element
     */
    public net.opengis.sosREST.x10.ObservationType getObservationArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationType target = null;
            target = (net.opengis.sosREST.x10.ObservationType)get_store().find_element_user(OBSERVATION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Observation" element
     */
    public int sizeOfObservationArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OBSERVATION$0);
        }
    }
    
    /**
     * Sets array of all "Observation" element
     */
    public void setObservationArray(net.opengis.sosREST.x10.ObservationType[] observationArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(observationArray, OBSERVATION$0);
        }
    }
    
    /**
     * Sets ith "Observation" element
     */
    public void setObservationArray(int i, net.opengis.sosREST.x10.ObservationType observation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationType target = null;
            target = (net.opengis.sosREST.x10.ObservationType)get_store().find_element_user(OBSERVATION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(observation);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Observation" element
     */
    public net.opengis.sosREST.x10.ObservationType insertNewObservation(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.ObservationType target = null;
            target = (net.opengis.sosREST.x10.ObservationType)get_store().insert_element_user(OBSERVATION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Observation" element
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
    
    /**
     * Removes the ith "Observation" element
     */
    public void removeObservation(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OBSERVATION$0, i);
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

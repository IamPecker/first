/*
 * XML Type:  FeatureType
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.FeatureType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * An XML FeatureType(@http://www.opengis.net/sosREST/1.0).
 *
 * This is a complex type.
 */
public class FeatureTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.FeatureType
{
    private static final long serialVersionUID = 1L;
    
    public FeatureTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTFEATURE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "AbstractFeature");
    private static final org.apache.xmlbeans.QNameSet ABSTRACTFEATURE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "DynamicFeatureCollection"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "MultiSurfaceCoverage"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "AbstractContinuousCoverage"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "DirectedObservationAtDistance"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "GridCoverage"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "Observation"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "DirectedObservation"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "RectifiedGridCoverage"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "AbstractFeature"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "AbstractCoverage"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "AbstractFeatureCollection"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "MultiSolidCoverage"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "AbstractDiscreteCoverage"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "MultiPointCoverage"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "FeatureCollection"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "MultiCurveCoverage"),
        new javax.xml.namespace.QName("http://www.opengis.net/gml/3.2", "DynamicFeature"),
    });
    private static final javax.xml.namespace.QName LINK$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "link");
    
    
    /**
     * Gets the "AbstractFeature" element
     */
    public net.opengis.gml.x32.AbstractFeatureType getAbstractFeature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.x32.AbstractFeatureType target = null;
            target = (net.opengis.gml.x32.AbstractFeatureType)get_store().find_element_user(ABSTRACTFEATURE$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AbstractFeature" element
     */
    public void setAbstractFeature(net.opengis.gml.x32.AbstractFeatureType abstractFeature)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.x32.AbstractFeatureType target = null;
            target = (net.opengis.gml.x32.AbstractFeatureType)get_store().find_element_user(ABSTRACTFEATURE$1, 0);
            if (target == null)
            {
                target = (net.opengis.gml.x32.AbstractFeatureType)get_store().add_element_user(ABSTRACTFEATURE$0);
            }
            target.set(abstractFeature);
        }
    }
    
    /**
     * Appends and returns a new empty "AbstractFeature" element
     */
    public net.opengis.gml.x32.AbstractFeatureType addNewAbstractFeature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.x32.AbstractFeatureType target = null;
            target = (net.opengis.gml.x32.AbstractFeatureType)get_store().add_element_user(ABSTRACTFEATURE$0);
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

/*
 * An XML document type.
 * Localname: Capabilities
 * Namespace: http://www.opengis.net/sosREST/1.0
 * Java type: net.opengis.sosREST.x10.CapabilitiesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.sosREST.x10.impl;
/**
 * A document containing one Capabilities(@http://www.opengis.net/sosREST/1.0) element.
 *
 * This is a complex type.
 */
public class CapabilitiesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.sosREST.x10.CapabilitiesDocument
{
    private static final long serialVersionUID = 1L;
    
    public CapabilitiesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CAPABILITIES$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/sosREST/1.0", "Capabilities");
    
    
    /**
     * Gets the "Capabilities" element
     */
    public net.opengis.sosREST.x10.CapabilitiesType getCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.CapabilitiesType target = null;
            target = (net.opengis.sosREST.x10.CapabilitiesType)get_store().find_element_user(CAPABILITIES$0, 0);
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
    public void setCapabilities(net.opengis.sosREST.x10.CapabilitiesType capabilities)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.CapabilitiesType target = null;
            target = (net.opengis.sosREST.x10.CapabilitiesType)get_store().find_element_user(CAPABILITIES$0, 0);
            if (target == null)
            {
                target = (net.opengis.sosREST.x10.CapabilitiesType)get_store().add_element_user(CAPABILITIES$0);
            }
            target.set(capabilities);
        }
    }
    
    /**
     * Appends and returns a new empty "Capabilities" element
     */
    public net.opengis.sosREST.x10.CapabilitiesType addNewCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.sosREST.x10.CapabilitiesType target = null;
            target = (net.opengis.sosREST.x10.CapabilitiesType)get_store().add_element_user(CAPABILITIES$0);
            return target;
        }
    }
}

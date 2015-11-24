/*
 * An XML document type.
 * Localname: NoDataPlaceholder
 * Namespace: http://www.52north.org/sensorweb/sos/profile
 * Java type: org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument
 *
 * Automatically generated - do not modify.
 */
package org.x52North.sensorweb.sos.profile.impl;
/**
 * A document containing one NoDataPlaceholder(@http://www.52north.org/sensorweb/sos/profile) element.
 *
 * This is a complex type.
 */
public class NoDataPlaceholderDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument
{
    private static final long serialVersionUID = 1L;
    
    public NoDataPlaceholderDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NODATAPLACEHOLDER$0 = 
        new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "NoDataPlaceholder");
    
    
    /**
     * Gets the "NoDataPlaceholder" element
     */
    public org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder getNoDataPlaceholder()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder target = null;
            target = (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder)get_store().find_element_user(NODATAPLACEHOLDER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "NoDataPlaceholder" element
     */
    public void setNoDataPlaceholder(org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder noDataPlaceholder)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder target = null;
            target = (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder)get_store().find_element_user(NODATAPLACEHOLDER$0, 0);
            if (target == null)
            {
                target = (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder)get_store().add_element_user(NODATAPLACEHOLDER$0);
            }
            target.set(noDataPlaceholder);
        }
    }
    
    /**
     * Appends and returns a new empty "NoDataPlaceholder" element
     */
    public org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder addNewNoDataPlaceholder()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder target = null;
            target = (org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder)get_store().add_element_user(NODATAPLACEHOLDER$0);
            return target;
        }
    }
    /**
     * An XML NoDataPlaceholder(@http://www.52north.org/sensorweb/sos/profile).
     *
     * This is a complex type.
     */
    public static class NoDataPlaceholderImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.x52North.sensorweb.sos.profile.NoDataPlaceholderDocument.NoDataPlaceholder
    {
        private static final long serialVersionUID = 1L;
        
        public NoDataPlaceholderImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName RESPONSEPLACEHOLDER$0 = 
            new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "responsePlaceholder");
        private static final javax.xml.namespace.QName PLACEHOLDER$2 = 
            new javax.xml.namespace.QName("http://www.52north.org/sensorweb/sos/profile", "placeholder");
        
        
        /**
         * Gets the "responsePlaceholder" element
         */
        public java.lang.String getResponsePlaceholder()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESPONSEPLACEHOLDER$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "responsePlaceholder" element
         */
        public org.apache.xmlbeans.XmlString xgetResponsePlaceholder()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RESPONSEPLACEHOLDER$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "responsePlaceholder" element
         */
        public void setResponsePlaceholder(java.lang.String responsePlaceholder)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESPONSEPLACEHOLDER$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RESPONSEPLACEHOLDER$0);
                }
                target.setStringValue(responsePlaceholder);
            }
        }
        
        /**
         * Sets (as xml) the "responsePlaceholder" element
         */
        public void xsetResponsePlaceholder(org.apache.xmlbeans.XmlString responsePlaceholder)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RESPONSEPLACEHOLDER$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RESPONSEPLACEHOLDER$0);
                }
                target.set(responsePlaceholder);
            }
        }
        
        /**
         * Gets array of all "placeholder" elements
         */
        public java.lang.String[] getPlaceholderArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PLACEHOLDER$2, targetList);
                java.lang.String[] result = new java.lang.String[targetList.size()];
                for (int i = 0, len = targetList.size() ; i < len ; i++)
                    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
                return result;
            }
        }
        
        /**
         * Gets ith "placeholder" element
         */
        public java.lang.String getPlaceholderArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PLACEHOLDER$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) array of all "placeholder" elements
         */
        public org.apache.xmlbeans.XmlString[] xgetPlaceholderArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PLACEHOLDER$2, targetList);
                org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets (as xml) ith "placeholder" element
         */
        public org.apache.xmlbeans.XmlString xgetPlaceholderArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PLACEHOLDER$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return (org.apache.xmlbeans.XmlString)target;
            }
        }
        
        /**
         * Returns number of "placeholder" element
         */
        public int sizeOfPlaceholderArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PLACEHOLDER$2);
            }
        }
        
        /**
         * Sets array of all "placeholder" element
         */
        public void setPlaceholderArray(java.lang.String[] placeholderArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(placeholderArray, PLACEHOLDER$2);
            }
        }
        
        /**
         * Sets ith "placeholder" element
         */
        public void setPlaceholderArray(int i, java.lang.String placeholder)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PLACEHOLDER$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.setStringValue(placeholder);
            }
        }
        
        /**
         * Sets (as xml) array of all "placeholder" element
         */
        public void xsetPlaceholderArray(org.apache.xmlbeans.XmlString[]placeholderArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(placeholderArray, PLACEHOLDER$2);
            }
        }
        
        /**
         * Sets (as xml) ith "placeholder" element
         */
        public void xsetPlaceholderArray(int i, org.apache.xmlbeans.XmlString placeholder)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PLACEHOLDER$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(placeholder);
            }
        }
        
        /**
         * Inserts the value as the ith "placeholder" element
         */
        public void insertPlaceholder(int i, java.lang.String placeholder)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = 
                    (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(PLACEHOLDER$2, i);
                target.setStringValue(placeholder);
            }
        }
        
        /**
         * Appends the value as the last "placeholder" element
         */
        public void addPlaceholder(java.lang.String placeholder)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PLACEHOLDER$2);
                target.setStringValue(placeholder);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "placeholder" element
         */
        public org.apache.xmlbeans.XmlString insertNewPlaceholder(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(PLACEHOLDER$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "placeholder" element
         */
        public org.apache.xmlbeans.XmlString addNewPlaceholder()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PLACEHOLDER$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "placeholder" element
         */
        public void removePlaceholder(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PLACEHOLDER$2, i);
            }
        }
    }
}

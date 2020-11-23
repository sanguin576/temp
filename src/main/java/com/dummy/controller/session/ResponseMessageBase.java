/**
 * ResponseMessageBase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

public class ResponseMessageBase  implements java.io.Serializable {
    
	private static final String URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES = "urn:dummy:WebSecurity:SL:WebService:MessageTypes";

	private boolean noRecordFound;

    private com.dummy.controller.session.ResponseStatusType status;

    private com.dummy.controller.session.Comment[] comments;

    private java.util.Calendar asOfDate;  // attribute

    public ResponseMessageBase() {
    }

    public ResponseMessageBase(
           boolean noRecordFound,
           com.dummy.controller.session.ResponseStatusType status,
           com.dummy.controller.session.Comment[] comments,
           java.util.Calendar asOfDate) {
           this.noRecordFound = noRecordFound;
           this.status = status;
           this.comments = comments;
           this.asOfDate = asOfDate;
    }


    /**
     * Gets the noRecordFound value for this ResponseMessageBase.
     * 
     * @return noRecordFound
     */
    public boolean isNoRecordFound() {
        return noRecordFound;
    }


    /**
     * Sets the noRecordFound value for this ResponseMessageBase.
     * 
     * @param noRecordFound
     */
    public void setNoRecordFound(boolean noRecordFound) {
        this.noRecordFound = noRecordFound;
    }


    /**
     * Gets the status value for this ResponseMessageBase.
     * 
     * @return status
     */
    public com.dummy.controller.session.ResponseStatusType getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ResponseMessageBase.
     * 
     * @param status
     */
    public void setStatus(com.dummy.controller.session.ResponseStatusType status) {
        this.status = status;
    }


    /**
     * Gets the comments value for this ResponseMessageBase.
     * 
     * @return comments
     */
    public com.dummy.controller.session.Comment[] getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this ResponseMessageBase.
     * 
     * @param comments
     */
    public void setComments(com.dummy.controller.session.Comment[] comments) {
        this.comments = comments;
    }


    /**
     * Gets the asOfDate value for this ResponseMessageBase.
     * 
     * @return asOfDate
     */
    public java.util.Calendar getAsOfDate() {
        return asOfDate;
    }


    /**
     * Sets the asOfDate value for this ResponseMessageBase.
     * 
     * @param asOfDate
     */
    public void setAsOfDate(java.util.Calendar asOfDate) {
        this.asOfDate = asOfDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
    	if (obj == null){
    		return false;
    	}
        if (!(obj instanceof ResponseMessageBase)){
        	return false;
        }
        ResponseMessageBase other = (ResponseMessageBase) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = 
            this.noRecordFound == other.isNoRecordFound() &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              java.util.Arrays.equals(this.comments, other.getComments()))) &&
            ((this.asOfDate==null && other.getAsOfDate()==null) || 
             (this.asOfDate!=null &&
              this.asOfDate.equals(other.getAsOfDate())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += (isNoRecordFound() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getComments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getComments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getComments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAsOfDate() != null) {
            _hashCode += getAsOfDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseMessageBase.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "ResponseMessageBase"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("asOfDate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "AsOfDate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noRecordFound");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "NoRecordFound"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "ResponseStatusType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "comments"));
        elemField.setXmlType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "Comment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "comment"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

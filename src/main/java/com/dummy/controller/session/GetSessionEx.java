/**
 * GetSessionEx.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

public class GetSessionEx  implements java.io.Serializable {
	
    private static final String URN_dummy_WEB_SECURITY_WEB_SERVICES = "urn:dummy:WebSecurity:WebServices";

	private java.lang.String sessionId;

    private boolean extendFlag;

    public GetSessionEx() {
    }

    public GetSessionEx(
           java.lang.String sessionId,
           boolean extendFlag) {
           this.sessionId = sessionId;
           this.extendFlag = extendFlag;
    }


    /**
     * Gets the sessionId value for this GetSessionEx.
     * 
     * @return sessionId
     */
    public java.lang.String getSessionId() {
        return sessionId;
    }


    /**
     * Sets the sessionId value for this GetSessionEx.
     * 
     * @param sessionId
     */
    public void setSessionId(java.lang.String sessionId) {
        this.sessionId = sessionId;
    }


    /**
     * Gets the extendFlag value for this GetSessionEx.
     * 
     * @return extendFlag
     */
    public boolean isExtendFlag() {
        return extendFlag;
    }


    /**
     * Sets the extendFlag value for this GetSessionEx.
     * 
     * @param extendFlag
     */
    public void setExtendFlag(boolean extendFlag) {
        this.extendFlag = extendFlag;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
    	if (obj == null){
    		return false;
    	}
        if (!(obj instanceof GetSessionEx)){
        	return false;
        }
        GetSessionEx other = (GetSessionEx) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = 
            ((this.sessionId==null && other.getSessionId()==null) || 
             (this.sessionId!=null &&
              this.sessionId.equals(other.getSessionId()))) &&
            this.extendFlag == other.isExtendFlag();
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
        if (getSessionId() != null) {
            _hashCode += getSessionId().hashCode();
        }
        _hashCode += (isExtendFlag() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSessionEx.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, ">GetSessionEx"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionId");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, "sessionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extendFlag");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, "extendFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
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

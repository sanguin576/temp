/**
 * GetSessionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

public class GetSessionResponse  implements java.io.Serializable {
    private com.dummy.controller.session.ResponseSession responseSession;

    public GetSessionResponse() {
    }

    public GetSessionResponse(
           com.dummy.controller.session.ResponseSession responseSession) {
           this.responseSession = responseSession;
    }


    /**
     * Gets the responseSession value for this GetSessionResponse.
     * 
     * @return responseSession
     */
    public com.dummy.controller.session.ResponseSession getResponseSession() {
        return responseSession;
    }


    /**
     * Sets the responseSession value for this GetSessionResponse.
     * 
     * @param responseSession
     */
    public void setResponseSession(com.dummy.controller.session.ResponseSession responseSession) {
        this.responseSession = responseSession;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
    	if (obj == null){
    		return false;
    	}
        if (!(obj instanceof GetSessionResponse)){
        	return false;
        }
        GetSessionResponse other = (GetSessionResponse) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = 
            ((this.responseSession==null && other.getResponseSession()==null) || 
             (this.responseSession!=null &&
              this.responseSession.equals(other.getResponseSession())));
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
        if (getResponseSession() != null) {
            _hashCode += getResponseSession().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSessionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:dummy:WebSecurity:WebServices", ">GetSessionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseSession");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:dummy:WebSecurity:SL:WebService:MessageTypes", "ResponseSession"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:dummy:WebSecurity:SL:WebService:MessageTypes", "ResponseSession"));
        elemField.setMinOccurs(0);
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

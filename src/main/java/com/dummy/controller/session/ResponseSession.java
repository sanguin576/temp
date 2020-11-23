/**
 * ResponseSession.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

public class ResponseSession  extends com.dummy.controller.session.ResponseSessionBase  implements java.io.Serializable {
    public ResponseSession() {
    }

    public ResponseSession(
           java.util.Calendar asOfDate,
           boolean noRecordFound,
           com.dummy.controller.session.ResponseStatusType status,
           com.dummy.controller.session.Comment[] comments,
           com.dummy.controller.session.UserSession userSession) {
        super(
            asOfDate,
            noRecordFound,
            status,
            comments,
            userSession);
    }

    private java.lang.Object __equalsCalc = null;
    
    @Override
    public synchronized boolean equals(java.lang.Object obj) {
    	if (obj == null){
    		return false;
    	}
        if (!(obj instanceof ResponseSession)){
        	return false;
        }
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    
    @Override
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseSession.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:dummy:WebSecurity:SL:WebService:MessageTypes", "ResponseSession"));
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

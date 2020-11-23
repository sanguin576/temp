/**
 * GetAndExtendSession.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

public class GetAndExtendSession  implements java.io.Serializable {
    private com.dummy.controller.session.RequestForSession requestForSession;

    public GetAndExtendSession() {
    }

    public GetAndExtendSession(
           com.dummy.controller.session.RequestForSession requestForSession) {
           this.requestForSession = requestForSession;
    }


    /**
     * Gets the requestForSession value for this GetAndExtendSession.
     * 
     * @return requestForSession
     */
    public com.dummy.controller.session.RequestForSession getRequestForSession() {
        return requestForSession;
    }


    /**
     * Sets the requestForSession value for this GetAndExtendSession.
     * 
     * @param requestForSession
     */
    public void setRequestForSession(com.dummy.controller.session.RequestForSession requestForSession) {
        this.requestForSession = requestForSession;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
    	if (obj == null){
    		return false;
    	}
        if (!(obj instanceof GetAndExtendSession)){
        	return false;
        }
        GetAndExtendSession other = (GetAndExtendSession) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = 
            ((this.requestForSession==null && other.getRequestForSession()==null) || 
             (this.requestForSession!=null &&
              this.requestForSession.equals(other.getRequestForSession())));
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
        if (getRequestForSession() != null) {
            _hashCode += getRequestForSession().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAndExtendSession.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:dummy:WebSecurity:WebServices", ">GetAndExtendSession"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestForSession");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:dummy:WebSecurity:SL:WebService:MessageTypes", "RequestForSession"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:dummy:WebSecurity:SL:WebService:MessageTypes", "RequestForSession"));
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

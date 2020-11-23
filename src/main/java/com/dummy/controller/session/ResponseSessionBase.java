/**
 * ResponseSessionBase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

public class ResponseSessionBase  extends com.dummy.controller.session.ResponseMessageBase  implements java.io.Serializable {
    
	private static final String URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES = "urn:dummy:WebSecurity:SL:WebService:MessageTypes";
	
	private com.dummy.controller.session.UserSession userSession;

    public ResponseSessionBase() {
    }

    public ResponseSessionBase(
           java.util.Calendar asOfDate,
           boolean noRecordFound,
           com.dummy.controller.session.ResponseStatusType status,
           com.dummy.controller.session.Comment[] comments,
           com.dummy.controller.session.UserSession userSession) {
        super(
            noRecordFound,
            status,
            comments,
            asOfDate);
        this.userSession = userSession;
    }


    /**
     * Gets the userSession value for this ResponseSessionBase.
     * 
     * @return userSession
     */
    public com.dummy.controller.session.UserSession getUserSession() {
        return userSession;
    }


    /**
     * Sets the userSession value for this ResponseSessionBase.
     * 
     * @param userSession
     */
    public void setUserSession(com.dummy.controller.session.UserSession userSession) {
        this.userSession = userSession;
    }

    private java.lang.Object __equalsCalc = null;
    
    @Override
    public synchronized boolean equals(java.lang.Object obj) {
    	if (obj == null){
    		return false;
    	}
        if (!(obj instanceof ResponseSessionBase)){
        	return false;
        }
        ResponseSessionBase other = (ResponseSessionBase) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.userSession==null && other.getUserSession()==null) || 
             (this.userSession!=null &&
              this.userSession.equals(other.getUserSession())));
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
        if (getUserSession() != null) {
            _hashCode += getUserSession().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseSessionBase.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "ResponseSessionBase"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userSession");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "UserSession"));
        elemField.setXmlType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "UserSession"));
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

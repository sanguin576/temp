/**
 * UserSession.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

public class UserSession  implements java.io.Serializable {
    private static final String URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES = "urn:dummy:WebSecurity:SL:WebService:MessageTypes";

	private static final String STRING = "string";

	private static final String HTTP_WWW_W3_ORG_2001_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

	private java.lang.String sessionId;

    private java.lang.String userId;

    private java.util.Calendar logInDateTime;

    private java.util.Calendar lastActivityDateTime;

    private int originGenKey;

    private java.lang.String clientIPAddress;

    private java.lang.String browserType;

    private java.lang.String akaName;

    public UserSession() {
    }

    public UserSession(
           java.lang.String sessionId,
           java.lang.String userId,
           java.util.Calendar logInDateTime,
           java.util.Calendar lastActivityDateTime,
           int originGenKey,
           java.lang.String clientIPAddress,
           java.lang.String browserType,
           java.lang.String akaName) {
           this.sessionId = sessionId;
           this.userId = userId;
           this.logInDateTime = logInDateTime;
           this.lastActivityDateTime = lastActivityDateTime;
           this.originGenKey = originGenKey;
           this.clientIPAddress = clientIPAddress;
           this.browserType = browserType;
           this.akaName = akaName;
    }


    /**
     * Gets the sessionId value for this UserSession.
     * 
     * @return sessionId
     */
    public java.lang.String getSessionId() {
        return sessionId;
    }


    /**
     * Sets the sessionId value for this UserSession.
     * 
     * @param sessionId
     */
    public void setSessionId(java.lang.String sessionId) {
        this.sessionId = sessionId;
    }


    /**
     * Gets the userId value for this UserSession.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this UserSession.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }


    /**
     * Gets the logInDateTime value for this UserSession.
     * 
     * @return logInDateTime
     */
    public java.util.Calendar getLogInDateTime() {
        return logInDateTime;
    }


    /**
     * Sets the logInDateTime value for this UserSession.
     * 
     * @param logInDateTime
     */
    public void setLogInDateTime(java.util.Calendar logInDateTime) {
        this.logInDateTime = logInDateTime;
    }


    /**
     * Gets the lastActivityDateTime value for this UserSession.
     * 
     * @return lastActivityDateTime
     */
    public java.util.Calendar getLastActivityDateTime() {
        return lastActivityDateTime;
    }


    /**
     * Sets the lastActivityDateTime value for this UserSession.
     * 
     * @param lastActivityDateTime
     */
    public void setLastActivityDateTime(java.util.Calendar lastActivityDateTime) {
        this.lastActivityDateTime = lastActivityDateTime;
    }


    /**
     * Gets the originGenKey value for this UserSession.
     * 
     * @return originGenKey
     */
    public int getOriginGenKey() {
        return originGenKey;
    }


    /**
     * Sets the originGenKey value for this UserSession.
     * 
     * @param originGenKey
     */
    public void setOriginGenKey(int originGenKey) {
        this.originGenKey = originGenKey;
    }


    /**
     * Gets the clientIPAddress value for this UserSession.
     * 
     * @return clientIPAddress
     */
    public java.lang.String getClientIPAddress() {
        return clientIPAddress;
    }


    /**
     * Sets the clientIPAddress value for this UserSession.
     * 
     * @param clientIPAddress
     */
    public void setClientIPAddress(java.lang.String clientIPAddress) {
        this.clientIPAddress = clientIPAddress;
    }


    /**
     * Gets the browserType value for this UserSession.
     * 
     * @return browserType
     */
    public java.lang.String getBrowserType() {
        return browserType;
    }


    /**
     * Sets the browserType value for this UserSession.
     * 
     * @param browserType
     */
    public void setBrowserType(java.lang.String browserType) {
        this.browserType = browserType;
    }


    /**
     * Gets the akaName value for this UserSession.
     * 
     * @return akaName
     */
    public java.lang.String getAkaName() {
        return akaName;
    }


    /**
     * Sets the akaName value for this UserSession.
     * 
     * @param akaName
     */
    public void setAkaName(java.lang.String akaName) {
        this.akaName = akaName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
    	if (obj == null){
    		return false;
    	}
        if (!(obj instanceof UserSession)){
        	return false;
        }
        UserSession other = (UserSession) obj;
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
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId()))) &&
            ((this.logInDateTime==null && other.getLogInDateTime()==null) || 
             (this.logInDateTime!=null &&
              this.logInDateTime.equals(other.getLogInDateTime()))) &&
            ((this.lastActivityDateTime==null && other.getLastActivityDateTime()==null) || 
             (this.lastActivityDateTime!=null &&
              this.lastActivityDateTime.equals(other.getLastActivityDateTime()))) &&
            this.originGenKey == other.getOriginGenKey() &&
            ((this.clientIPAddress==null && other.getClientIPAddress()==null) || 
             (this.clientIPAddress!=null &&
              this.clientIPAddress.equals(other.getClientIPAddress()))) &&
            ((this.browserType==null && other.getBrowserType()==null) || 
             (this.browserType!=null &&
              this.browserType.equals(other.getBrowserType()))) &&
            ((this.akaName==null && other.getAkaName()==null) || 
             (this.akaName!=null &&
              this.akaName.equals(other.getAkaName())));
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
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        if (getLogInDateTime() != null) {
            _hashCode += getLogInDateTime().hashCode();
        }
        if (getLastActivityDateTime() != null) {
            _hashCode += getLastActivityDateTime().hashCode();
        }
        _hashCode += getOriginGenKey();
        if (getClientIPAddress() != null) {
            _hashCode += getClientIPAddress().hashCode();
        }
        if (getBrowserType() != null) {
            _hashCode += getBrowserType().hashCode();
        }
        if (getAkaName() != null) {
            _hashCode += getAkaName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserSession.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "UserSession"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionId");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "SessionId"));
        elemField.setXmlType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "UserId"));
        elemField.setXmlType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logInDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "LogInDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastActivityDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "LastActivityDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originGenKey");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "OriginGenKey"));
        elemField.setXmlType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientIPAddress");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "ClientIPAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("browserType");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "BrowserType"));
        elemField.setXmlType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("akaName");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "AkaName"));
        elemField.setXmlType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING));
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

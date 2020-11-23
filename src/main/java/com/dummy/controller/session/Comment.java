/**
 * Comment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

public class Comment  implements java.io.Serializable {
	
    private static final String URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES = "urn:dummy:WebSecurity:SL:WebService:MessageTypes";

	private java.lang.String message;

    private com.dummy.controller.session.CommentLevel level;  // attribute

    public Comment() {
    }

    public Comment(
           java.lang.String message,
           com.dummy.controller.session.CommentLevel level) {
           this.message = message;
           this.level = level;
    }


    /**
     * Gets the message value for this Comment.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this Comment.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the level value for this Comment.
     * 
     * @return level
     */
    public com.dummy.controller.session.CommentLevel getLevel() {
        return level;
    }


    /**
     * Sets the level value for this Comment.
     * 
     * @param level
     */
    public void setLevel(com.dummy.controller.session.CommentLevel level) {
        this.level = level;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
    	if (obj == null){ 
    		return false;
    		}
        if (!(obj instanceof Comment)){ 
        	return false;
        			}
        Comment other = (Comment) obj;
         if (this == obj){
        	return true;
        	}
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = 
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.level==null && other.getLevel()==null) || 
             (this.level!=null &&
              this.level.equals(other.getLevel())));
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
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getLevel() != null) {
            _hashCode += getLevel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Comment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "Comment"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("level");
        attrField.setXmlName(new javax.xml.namespace.QName("", "Level"));
        attrField.setXmlType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "CommentLevel"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "Message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

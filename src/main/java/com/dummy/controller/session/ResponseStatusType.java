/**
 * ResponseStatusType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

public class ResponseStatusType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap table = new java.util.HashMap();

    // Constructor
    protected ResponseStatusType(java.lang.String value) {
        _value_ = value;
        table.put(_value_,this);
    }

    public static final java.lang.String _Success = "Success";
    public static final java.lang.String _Failure = "Failure";
    public static final ResponseStatusType Success = new ResponseStatusType(_Success);
    public static final ResponseStatusType Failure = new ResponseStatusType(_Failure);
    public java.lang.String getValue() { return _value_;}
    public static ResponseStatusType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ResponseStatusType enumeration = (ResponseStatusType)
            table.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ResponseStatusType fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseStatusType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:dummy:WebSecurity:SL:WebService:MessageTypes", "ResponseStatusType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

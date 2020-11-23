/**
 * SessionManagementWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

public interface SessionManagementWebService extends javax.xml.rpc.Service {

/**
 * This Webservice provides method to maintain Session of a provided
 * Session Id
 */
    public java.lang.String getSessionManagementWebServiceSoap12Address();

    public com.dummy.controller.session.SessionManagementWebServiceSoapPortType getSessionManagementWebServiceSoap12() throws javax.xml.rpc.ServiceException;

    public com.dummy.controller.session.SessionManagementWebServiceSoapPortType getSessionManagementWebServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getSessionManagementWebServiceSoapAddress();

    public com.dummy.controller.session.SessionManagementWebServiceSoapPortType getSessionManagementWebServiceSoap() throws javax.xml.rpc.ServiceException;

    public com.dummy.controller.session.SessionManagementWebServiceSoapPortType getSessionManagementWebServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

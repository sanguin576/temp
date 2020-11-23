/**
 * SessionManagementWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

import com.dummy.configuration.EnvironmentManager;

public class SessionManagementWebServiceLocator extends org.apache.axis.client.Service implements com.dummy.controller.session.SessionManagementWebService
{
    private static final String SESSION_MANAGEMENT_WEB_SERVICE_SOAP12 = "SessionManagementWebServiceSoap12";
	private static final String SESSION_MANAGEMENT_WEB_SERVICE_SOAP = "SessionManagementWebServiceSoap";
	private static final String URN_dummy_WEB_SECURITY_WEB_SERVICES = "urn:dummy:WebSecurity:WebServices";

    /**
     * This Webservice provides method to maintain Session of a provided Session Id
     */

    public SessionManagementWebServiceLocator( )
    {
    }

    public SessionManagementWebServiceLocator( org.apache.axis.EngineConfiguration config )
    {
        super( config );
    }

    public SessionManagementWebServiceLocator( java.lang.String wsdlLoc, javax.xml.namespace.QName sName ) throws javax.xml.rpc.ServiceException
    {
        super( wsdlLoc, sName );
    }

    // Use to get a proxy class for SessionManagementWebServiceSoap12
    private java.lang.String SessionManagementWebServiceSoap12_address = ( EnvironmentManager.getEnv( ).equals( "PROD" ) ) ? "https://slwebservices.dummy.com/SessionManagementWebService/SessionManagementWebService.asmx"
            : ( EnvironmentManager.getEnv( ).equals( "QA" ) ) ? "https://qa-slwebservices.dummy.com/SessionManagementWebService/SessionManagementWebService.asmx"
                    : "http://test-slwebservices.dummy.com/SessionManagementWebService/SessionManagementWebService.asmx";

    public java.lang.String getSessionManagementWebServiceSoap12Address( )
    {
        return SessionManagementWebServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SessionManagementWebServiceSoap12WSDDServiceName = SESSION_MANAGEMENT_WEB_SERVICE_SOAP12;

    public java.lang.String getSessionManagementWebServiceSoap12WSDDServiceName( )
    {
        return SessionManagementWebServiceSoap12WSDDServiceName;
    }

    public void setSessionManagementWebServiceSoap12WSDDServiceName( java.lang.String name )
    {
        SessionManagementWebServiceSoap12WSDDServiceName = name;
    }

    public com.dummy.controller.session.SessionManagementWebServiceSoapPortType getSessionManagementWebServiceSoap12( ) throws javax.xml.rpc.ServiceException
    {
        java.net.URL endpoint;
        try
        {
            endpoint = new java.net.URL( SessionManagementWebServiceSoap12_address );
        }
        catch( java.net.MalformedURLException e )
        {
            throw new javax.xml.rpc.ServiceException( e );
        }
        return getSessionManagementWebServiceSoap12( endpoint );
    }

    public com.dummy.controller.session.SessionManagementWebServiceSoapPortType getSessionManagementWebServiceSoap12( java.net.URL portAddress ) throws javax.xml.rpc.ServiceException
    {
        try
        {
            com.dummy.controller.session.SessionManagementWebServiceSoap12Stub _stub = new com.dummy.controller.session.SessionManagementWebServiceSoap12Stub( portAddress, this );
            _stub.setPortName( getSessionManagementWebServiceSoap12WSDDServiceName( ) );
            return _stub;
        }
        catch( org.apache.axis.AxisFault e )
        {
            return null;
        }
    }

    public void setSessionManagementWebServiceSoap12EndpointAddress( java.lang.String address )
    {
        SessionManagementWebServiceSoap12_address = address;
    }

    // Use to get a proxy class for SessionManagementWebServiceSoap
    private java.lang.String SessionManagementWebServiceSoap_address = ( EnvironmentManager.getEnv( ).equals( "PROD" ) ) ? "https://slwebservices.dummy.com/SessionManagementWebService/SessionManagementWebService.asmx"
            : ( EnvironmentManager.getEnv( ).equals( "QA" ) ) ? "https://qa-slwebservices.dummy.com/SessionManagementWebService/SessionManagementWebService.asmx"
                    : "http://test-slwebservices.dummy.com/SessionManagementWebService/SessionManagementWebService.asmx";

    public java.lang.String getSessionManagementWebServiceSoapAddress( )
    {
        return SessionManagementWebServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SessionManagementWebServiceSoapWSDDServiceName = SESSION_MANAGEMENT_WEB_SERVICE_SOAP;

    public java.lang.String getSessionManagementWebServiceSoapWSDDServiceName( )
    {
        return SessionManagementWebServiceSoapWSDDServiceName;
    }

    public void setSessionManagementWebServiceSoapWSDDServiceName( java.lang.String name )
    {
        SessionManagementWebServiceSoapWSDDServiceName = name;
    }

    public com.dummy.controller.session.SessionManagementWebServiceSoapPortType getSessionManagementWebServiceSoap( ) throws javax.xml.rpc.ServiceException
    {
        java.net.URL endpoint;
        try
        {
            endpoint = new java.net.URL( SessionManagementWebServiceSoap_address );
        }
        catch( java.net.MalformedURLException e )
        {
            throw new javax.xml.rpc.ServiceException( e );
        }
        return getSessionManagementWebServiceSoap( endpoint );
    }

    public com.dummy.controller.session.SessionManagementWebServiceSoapPortType getSessionManagementWebServiceSoap( java.net.URL portAddress ) throws javax.xml.rpc.ServiceException
    {
        return null;
    }

    public void setSessionManagementWebServiceSoapEndpointAddress( java.lang.String address )
    {
        SessionManagementWebServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation. If this service has no port for the given interface, then ServiceException is thrown. This service has multiple
     * ports for a given interface; the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort( Class serviceEndpointInterface ) throws javax.xml.rpc.ServiceException
    {
        try
        {
            if( com.dummy.controller.session.SessionManagementWebServiceSoapPortType.class.isAssignableFrom( serviceEndpointInterface ) )
            {
                com.dummy.controller.session.SessionManagementWebServiceSoap12Stub _stub = new com.dummy.controller.session.SessionManagementWebServiceSoap12Stub( new java.net.URL( SessionManagementWebServiceSoap12_address ), this );
                _stub.setPortName( getSessionManagementWebServiceSoap12WSDDServiceName( ) );
                return _stub;
            }
        }
        catch( Exception t )
        {
            throw new javax.xml.rpc.ServiceException( t );
        }
        throw new javax.xml.rpc.ServiceException( "There is no stub implementation for the interface:  " + ( serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName( ) ) );
    }

    /**
     * For the given interface, get the stub implementation. If this service has no port for the given interface, then ServiceException is thrown.
     */
    public java.rmi.Remote getPort( javax.xml.namespace.QName portName, Class serviceEndpointInterface ) throws javax.xml.rpc.ServiceException
    {
        if( portName == null )
        {
            return getPort( serviceEndpointInterface );
        }
        java.lang.String inputPortName = portName.getLocalPart( );
        if( SESSION_MANAGEMENT_WEB_SERVICE_SOAP12.equals( inputPortName ) )
        {
            return getSessionManagementWebServiceSoap12( );
        }
        else if( SESSION_MANAGEMENT_WEB_SERVICE_SOAP.equals( inputPortName ) )
        {
            return getSessionManagementWebServiceSoap( );
        }
        else
        {
            java.rmi.Remote _stub = getPort( serviceEndpointInterface );
            ( ( org.apache.axis.client.Stub )_stub ).setPortName( portName );
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName( )
    {
        return new javax.xml.namespace.QName( URN_dummy_WEB_SECURITY_WEB_SERVICES, "SessionManagementWebService" );
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts( )
    {
        if( ports == null )
        {
            ports = new java.util.HashSet( );
            ports.add( new javax.xml.namespace.QName( URN_dummy_WEB_SECURITY_WEB_SERVICES, SESSION_MANAGEMENT_WEB_SERVICE_SOAP12 ) );
            ports.add( new javax.xml.namespace.QName( URN_dummy_WEB_SECURITY_WEB_SERVICES, SESSION_MANAGEMENT_WEB_SERVICE_SOAP ) );
        }
        return ports.iterator( );
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress( java.lang.String portName, java.lang.String address ) throws javax.xml.rpc.ServiceException
    {

        if( SESSION_MANAGEMENT_WEB_SERVICE_SOAP12.equals( portName ) )
        {
            setSessionManagementWebServiceSoap12EndpointAddress( address );
        }
        else if( SESSION_MANAGEMENT_WEB_SERVICE_SOAP.equals( portName ) )
        {
            setSessionManagementWebServiceSoapEndpointAddress( address );
        }
        else
        { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException( " Cannot set Endpoint Address for Unknown Port" + portName );
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress( javax.xml.namespace.QName portName, java.lang.String address ) throws javax.xml.rpc.ServiceException
    {
        setEndpointAddress( portName.getLocalPart( ), address );
    }

}

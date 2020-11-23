/**
 * SessionManagementWebServiceSoap12Stub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

import java.util.ArrayList;

public class SessionManagementWebServiceSoap12Stub extends org.apache.axis.client.Stub implements com.dummy.controller.session.SessionManagementWebServiceSoapPortType {
   
	private static final String REQUEST_FOR_SESSION = "RequestForSession";
	private static final String URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES = "urn:dummy:WebSecurity:SL:WebService:MessageTypes";
	private static final String RESPONSE_SESSION = "ResponseSession";
	private static final String URN_dummy_WEB_SECURITY_WEB_SERVICES = "urn:dummy:WebSecurity:WebServices";
	private static final String HTTP_WWW_W3_ORG_2001_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	private static final String BOOLEAN = "boolean";
	private static final String STRING = "string";
	private static final String SESSION_ID = "sessionId";
	private ArrayList cachedSerClasses = new ArrayList();
    private ArrayList cachedSerQNames = new ArrayList();
    private ArrayList cachedSerFactories = new ArrayList();
    private ArrayList cachedDeserFactories = new ArrayList();

    static org.apache.axis.description.OperationDesc [] operations;

    static {
        operations = new org.apache.axis.description.OperationDesc[11];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAndExtendSession");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, REQUEST_FOR_SESSION), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, REQUEST_FOR_SESSION), com.dummy.controller.session.RequestForSession.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, RESPONSE_SESSION));
        oper.setReturnClass(com.dummy.controller.session.ResponseSession.class);
        oper.setReturnQName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, RESPONSE_SESSION));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSession");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, REQUEST_FOR_SESSION), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, REQUEST_FOR_SESSION), com.dummy.controller.session.RequestForSession.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, "extendFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, BOOLEAN), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, RESPONSE_SESSION));
        oper.setReturnClass(com.dummy.controller.session.ResponseSession.class);
        oper.setReturnQName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, RESPONSE_SESSION));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("LogOutSession");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, REQUEST_FOR_SESSION), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, REQUEST_FOR_SESSION), com.dummy.controller.session.RequestForSession.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAndExtendSessionEx");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, SESSION_ID), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, RESPONSE_SESSION));
        oper.setReturnClass(com.dummy.controller.session.ResponseSession.class);
        oper.setReturnQName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, RESPONSE_SESSION));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetUserSessionDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", SESSION_ID), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "GetUserSessionDetailsResult"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSessionEx");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, SESSION_ID), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, "extendFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, BOOLEAN), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, RESPONSE_SESSION));
        oper.setReturnClass(com.dummy.controller.session.ResponseSession.class);
        oper.setReturnQName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, RESPONSE_SESSION));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("LogOutSessionEx");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, SESSION_ID), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("BuildPharmacyUserSessionAccess");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", SESSION_ID), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, BOOLEAN));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "BuildPharmacyUserSessionAccessResult"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EmulatePharmacyUserSessionAccess");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "akaName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "emulatedAKAName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "originGenKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, BOOLEAN));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "EmulatePharmacyUserSessionAccessResult"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("BuildEmulationUserSessionAccess");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "akaName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "emulatedAKAName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "originGenKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "BuildEmulationUserSessionAccessResult"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EmulateReconcileMemberRE");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "EmulatedAkaName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSRAkaName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "SessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "PortOfOrigin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "SystemGUID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, STRING), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName(HTTP_WWW_W3_ORG_2001_XML_SCHEMA, BOOLEAN));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "EmulateReconcileMemberREResult"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        operations[10] = oper;

    }

    public SessionManagementWebServiceSoap12Stub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SessionManagementWebServiceSoap12Stub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SessionManagementWebServiceSoap12Stub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
           
            qName = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "ArrayOfComment");
            cachedSerQNames.add(qName);
            cls = com.dummy.controller.session.Comment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "Comment");
            qName2 = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "comment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "Comment");
            cachedSerQNames.add(qName);
            cls = com.dummy.controller.session.Comment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "CommentLevel");
            cachedSerQNames.add(qName);
            cls = com.dummy.controller.session.CommentLevel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, REQUEST_FOR_SESSION);
            cachedSerQNames.add(qName);
            cls = com.dummy.controller.session.RequestForSession.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "RequestForSessionBase");
            cachedSerQNames.add(qName);
            cls = com.dummy.controller.session.RequestForSessionBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "ResponseMessageBase");
            cachedSerQNames.add(qName);
            cls = com.dummy.controller.session.ResponseMessageBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, RESPONSE_SESSION);
            cachedSerQNames.add(qName);
            cls = com.dummy.controller.session.ResponseSession.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "ResponseSessionBase");
            cachedSerQNames.add(qName);
            cls = com.dummy.controller.session.ResponseSessionBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "ResponseStatusType");
            cachedSerQNames.add(qName);
            cls = com.dummy.controller.session.ResponseStatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_SL_WEB_SERVICE_MESSAGE_TYPES, "UserSession");
            cachedSerQNames.add(qName);
            cls = com.dummy.controller.session.UserSession.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, sanitize(super.cachedProperties.get(key)));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (Exception t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", t);
        }
    }

    public com.dummy.controller.session.ResponseSession getAndExtendSession(com.dummy.controller.session.RequestForSession requestForSession) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:dummy:WebSecurity:WebServices/GetAndExtendSession");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAndExtendSession"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requestForSession});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dummy.controller.session.ResponseSession) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dummy.controller.session.ResponseSession) org.apache.axis.utils.JavaUtils.convert(_resp, com.dummy.controller.session.ResponseSession.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dummy.controller.session.ResponseSession getSession(com.dummy.controller.session.RequestForSession requestForSession, boolean extendFlag) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:dummy:WebSecurity:WebServices/GetSession");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetSession"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requestForSession, Boolean.valueOf(extendFlag)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dummy.controller.session.ResponseSession) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dummy.controller.session.ResponseSession) org.apache.axis.utils.JavaUtils.convert(_resp, com.dummy.controller.session.ResponseSession.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void logOutSession(com.dummy.controller.session.RequestForSession requestForSession) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:dummy:WebSecurity:WebServices/LogOutSession");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "LogOutSession"));

        setRequestHeaders(_call);
        setAttachments(_call);
        _call.invokeOneWay(new java.lang.Object[] {requestForSession});

    }

    public com.dummy.controller.session.ResponseSession getAndExtendSessionEx(java.lang.String sessionId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:dummy:WebSecurity:WebServices/GetAndExtendSessionEx");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAndExtendSessionEx"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dummy.controller.session.ResponseSession) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dummy.controller.session.ResponseSession) org.apache.axis.utils.JavaUtils.convert(_resp, com.dummy.controller.session.ResponseSession.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String getUserSessionDetails(java.lang.String sessionId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:dummy:WebSecurity:WebServices/GetUserSessionDetails");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, "GetUserSessionDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.dummy.controller.session.ResponseSession getSessionEx(java.lang.String sessionId, boolean extendFlag) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:dummy:WebSecurity:WebServices/GetSessionEx");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetSessionEx"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sessionId, Boolean.valueOf(extendFlag)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.dummy.controller.session.ResponseSession) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.dummy.controller.session.ResponseSession) org.apache.axis.utils.JavaUtils.convert(_resp, com.dummy.controller.session.ResponseSession.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void logOutSessionEx(java.lang.String sessionId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:dummy:WebSecurity:WebServices/LogOutSessionEx");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "LogOutSessionEx"));

        setRequestHeaders(_call);
        setAttachments(_call);
        _call.invokeOneWay(new java.lang.Object[] {sessionId});

    }

    public boolean buildPharmacyUserSessionAccess(java.lang.String userId, java.lang.String sessionId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:dummy:WebSecurity:WebServices/BuildPharmacyUserSessionAccess");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, "BuildPharmacyUserSessionAccess"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userId, sessionId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean emulatePharmacyUserSessionAccess(java.lang.String akaName, java.lang.String emulatedAKAName, java.lang.String sessionID, int originGenKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:dummy:WebSecurity:WebServices/EmulatePharmacyUserSessionAccess");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, "EmulatePharmacyUserSessionAccess"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {akaName, emulatedAKAName, sessionID, Integer.valueOf(originGenKey)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int buildEmulationUserSessionAccess(java.lang.String akaName, java.lang.String emulatedAKAName, java.lang.String sessionID, int originGenKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:dummy:WebSecurity:WebServices/BuildEmulationUserSessionAccess");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, "BuildEmulationUserSessionAccess"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {akaName, emulatedAKAName, sessionID, Integer.valueOf(originGenKey)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean emulateReconcileMemberRE(java.lang.String emulatedAkaName, java.lang.String CSRAkaName, java.lang.String sessionID, int portOfOrigin, java.lang.String systemGUID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:dummy:WebSecurity:WebServices/EmulateReconcileMemberRE");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(URN_dummy_WEB_SECURITY_WEB_SERVICES, "EmulateReconcileMemberRE"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {emulatedAkaName, CSRAkaName, sessionID, Integer.valueOf(portOfOrigin), systemGUID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    private Object sanitize(Object input )
    {
    	try {
        	String strInput = (String) input;
            return strInput.replaceAll( "[^a-zA-Z0-9!@#$&()-`.+,/\"?~%{}|' ]*$", "" );			
		} catch (Exception e) {
			return input;
		}
    }
    
}

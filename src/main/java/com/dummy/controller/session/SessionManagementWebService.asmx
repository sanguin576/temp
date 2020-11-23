<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="urn:dummy:WebSecurity:WebServices" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:s1="urn:dummy:WebSecurity:SL:WebService:MessageTypes" xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" targetNamespace="urn:dummy:WebSecurity:WebServices" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">This Webservice provides method to maintain Session of a provided Session Id</wsdl:documentation>
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="urn:dummy:WebSecurity:WebServices">
      <s:import namespace="urn:dummy:WebSecurity:SL:WebService:MessageTypes" />
      <s:element name="GetAndExtendSession">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s1:RequestForSession" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetAndExtendSessionResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s1:ResponseSession" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSession">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s1:RequestForSession" />
            <s:element minOccurs="1" maxOccurs="1" name="extendFlag" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSessionResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s1:ResponseSession" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetAndExtendSessionEx">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="sessionId" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetAndExtendSessionExResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s1:ResponseSession" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSessionEx">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="sessionId" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="extendFlag" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSessionExResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" ref="s1:ResponseSession" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="sessionId" type="s:string" />
      <s:element name="string" nillable="true" type="s:string" />
      <s:element name="boolean" type="s:boolean" />
      <s:element name="int" type="s:int" />
    </s:schema>
    <s:schema elementFormDefault="qualified" targetNamespace="urn:dummy:WebSecurity:SL:WebService:MessageTypes">
      <s:element name="RequestForSession" type="s1:RequestForSession" />
      <s:complexType name="RequestForSession">
        <s:complexContent mixed="false">
          <s:extension base="s1:RequestForSessionBase" />
        </s:complexContent>
      </s:complexType>
      <s:complexType name="RequestForSessionBase">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="SessionId" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="ResponseSession" type="s1:ResponseSession" />
      <s:complexType name="ResponseSession">
        <s:complexContent mixed="false">
          <s:extension base="s1:ResponseSessionBase" />
        </s:complexContent>
      </s:complexType>
      <s:complexType name="ResponseSessionBase">
        <s:complexContent mixed="false">
          <s:extension base="s1:ResponseMessageBase">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="1" name="UserSession" type="s1:UserSession" />
            </s:sequence>
          </s:extension>
        </s:complexContent>
      </s:complexType>
      <s:complexType name="ResponseMessageBase">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="NoRecordFound" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="Status" type="s1:ResponseStatusType" />
          <s:element minOccurs="0" maxOccurs="1" name="comments" type="s1:ArrayOfComment" />
        </s:sequence>
        <s:attribute form="unqualified" name="AsOfDate" type="s:dateTime" use="required" />
      </s:complexType>
      <s:simpleType name="ResponseStatusType">
        <s:restriction base="s:string">
          <s:enumeration value="Success" />
          <s:enumeration value="Failure" />
        </s:restriction>
      </s:simpleType>
      <s:complexType name="ArrayOfComment">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="comment" type="s1:Comment" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="Comment">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="Message" type="s:string" />
        </s:sequence>
        <s:attribute form="unqualified" name="Level" type="s1:CommentLevel" use="required" />
      </s:complexType>
      <s:simpleType name="CommentLevel">
        <s:restriction base="s:string">
          <s:enumeration value="Information" />
          <s:enumeration value="Error" />
          <s:enumeration value="Warning" />
        </s:restriction>
      </s:simpleType>
      <s:complexType name="UserSession">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="SessionId" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="UserId" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="LogInDateTime" type="s:dateTime" />
          <s:element minOccurs="1" maxOccurs="1" name="LastActivityDateTime" type="s:dateTime" />
          <s:element minOccurs="1" maxOccurs="1" name="OriginGenKey" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="ClientIPAddress" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="BrowserType" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="AkaName" type="s:string" />
        </s:sequence>
      </s:complexType>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="GetAndExtendSessionSoapIn">
    <wsdl:part name="parameters" element="tns:GetAndExtendSession" />
  </wsdl:message>
  <wsdl:message name="GetAndExtendSessionSoapOut">
    <wsdl:part name="parameters" element="tns:GetAndExtendSessionResponse" />
  </wsdl:message>
  <wsdl:message name="GetSessionSoapIn">
    <wsdl:part name="parameters" element="tns:GetSession" />
  </wsdl:message>
  <wsdl:message name="GetSessionSoapOut">
    <wsdl:part name="parameters" element="tns:GetSessionResponse" />
  </wsdl:message>
  <wsdl:message name="LogOutSessionSoapIn">
    <wsdl:part name="requestForSession" element="s1:RequestForSession" />
  </wsdl:message>
  <wsdl:message name="GetAndExtendSessionExSoapIn">
    <wsdl:part name="parameters" element="tns:GetAndExtendSessionEx" />
  </wsdl:message>
  <wsdl:message name="GetAndExtendSessionExSoapOut">
    <wsdl:part name="parameters" element="tns:GetAndExtendSessionExResponse" />
  </wsdl:message>
  <wsdl:message name="GetUserSessionDetailsSoapIn">
    <wsdl:part name="sessionId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetUserSessionDetailsSoapOut">
    <wsdl:part name="GetUserSessionDetailsResult" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetSessionExSoapIn">
    <wsdl:part name="parameters" element="tns:GetSessionEx" />
  </wsdl:message>
  <wsdl:message name="GetSessionExSoapOut">
    <wsdl:part name="parameters" element="tns:GetSessionExResponse" />
  </wsdl:message>
  <wsdl:message name="LogOutSessionExSoapIn">
    <wsdl:part name="sessionId" element="tns:sessionId" />
  </wsdl:message>
  <wsdl:message name="BuildPharmacyUserSessionAccessSoapIn">
    <wsdl:part name="userId" type="s:string" />
    <wsdl:part name="sessionId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="BuildPharmacyUserSessionAccessSoapOut">
    <wsdl:part name="BuildPharmacyUserSessionAccessResult" type="s:boolean" />
  </wsdl:message>
  <wsdl:message name="EmulatePharmacyUserSessionAccessSoapIn">
    <wsdl:part name="akaName" type="s:string" />
    <wsdl:part name="emulatedAKAName" type="s:string" />
    <wsdl:part name="sessionID" type="s:string" />
    <wsdl:part name="originGenKey" type="s:int" />
  </wsdl:message>
  <wsdl:message name="EmulatePharmacyUserSessionAccessSoapOut">
    <wsdl:part name="EmulatePharmacyUserSessionAccessResult" type="s:boolean" />
  </wsdl:message>
  <wsdl:message name="BuildEmulationUserSessionAccessSoapIn">
    <wsdl:part name="akaName" type="s:string" />
    <wsdl:part name="emulatedAKAName" type="s:string" />
    <wsdl:part name="sessionID" type="s:string" />
    <wsdl:part name="originGenKey" type="s:int" />
  </wsdl:message>
  <wsdl:message name="BuildEmulationUserSessionAccessSoapOut">
    <wsdl:part name="BuildEmulationUserSessionAccessResult" type="s:int" />
  </wsdl:message>
  <wsdl:message name="EmulateReconcileMemberRESoapIn">
    <wsdl:part name="EmulatedAkaName" type="s:string" />
    <wsdl:part name="CSRAkaName" type="s:string" />
    <wsdl:part name="SessionID" type="s:string" />
    <wsdl:part name="PortOfOrigin" type="s:int" />
    <wsdl:part name="SystemGUID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="EmulateReconcileMemberRESoapOut">
    <wsdl:part name="EmulateReconcileMemberREResult" type="s:boolean" />
  </wsdl:message>
  <wsdl:message name="GetAndExtendSessionExHttpGetIn">
    <wsdl:part name="sessionId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetAndExtendSessionExHttpGetOut">
    <wsdl:part name="Body" element="s1:ResponseSession" />
  </wsdl:message>
  <wsdl:message name="GetUserSessionDetailsHttpGetIn">
    <wsdl:part name="sessionId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetUserSessionDetailsHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetSessionExHttpGetIn">
    <wsdl:part name="sessionId" type="s:string" />
    <wsdl:part name="extendFlag" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetSessionExHttpGetOut">
    <wsdl:part name="Body" element="s1:ResponseSession" />
  </wsdl:message>
  <wsdl:message name="LogOutSessionExHttpGetIn">
    <wsdl:part name="sessionId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="LogOutSessionExHttpGetOut" />
  <wsdl:message name="BuildPharmacyUserSessionAccessHttpGetIn">
    <wsdl:part name="userId" type="s:string" />
    <wsdl:part name="sessionId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="BuildPharmacyUserSessionAccessHttpGetOut">
    <wsdl:part name="Body" element="tns:boolean" />
  </wsdl:message>
  <wsdl:message name="EmulatePharmacyUserSessionAccessHttpGetIn">
    <wsdl:part name="akaName" type="s:string" />
    <wsdl:part name="emulatedAKAName" type="s:string" />
    <wsdl:part name="sessionID" type="s:string" />
    <wsdl:part name="originGenKey" type="s:string" />
  </wsdl:message>
  <wsdl:message name="EmulatePharmacyUserSessionAccessHttpGetOut">
    <wsdl:part name="Body" element="tns:boolean" />
  </wsdl:message>
  <wsdl:message name="BuildEmulationUserSessionAccessHttpGetIn">
    <wsdl:part name="akaName" type="s:string" />
    <wsdl:part name="emulatedAKAName" type="s:string" />
    <wsdl:part name="sessionID" type="s:string" />
    <wsdl:part name="originGenKey" type="s:string" />
  </wsdl:message>
  <wsdl:message name="BuildEmulationUserSessionAccessHttpGetOut">
    <wsdl:part name="Body" element="tns:int" />
  </wsdl:message>
  <wsdl:message name="EmulateReconcileMemberREHttpGetIn">
    <wsdl:part name="EmulatedAkaName" type="s:string" />
    <wsdl:part name="CSRAkaName" type="s:string" />
    <wsdl:part name="SessionID" type="s:string" />
    <wsdl:part name="PortOfOrigin" type="s:string" />
    <wsdl:part name="SystemGUID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="EmulateReconcileMemberREHttpGetOut">
    <wsdl:part name="Body" element="tns:boolean" />
  </wsdl:message>
  <wsdl:message name="GetAndExtendSessionExHttpPostIn">
    <wsdl:part name="sessionId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetAndExtendSessionExHttpPostOut">
    <wsdl:part name="Body" element="s1:ResponseSession" />
  </wsdl:message>
  <wsdl:message name="GetUserSessionDetailsHttpPostIn">
    <wsdl:part name="sessionId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetUserSessionDetailsHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetSessionExHttpPostIn">
    <wsdl:part name="sessionId" type="s:string" />
    <wsdl:part name="extendFlag" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetSessionExHttpPostOut">
    <wsdl:part name="Body" element="s1:ResponseSession" />
  </wsdl:message>
  <wsdl:message name="LogOutSessionExHttpPostIn">
    <wsdl:part name="sessionId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="LogOutSessionExHttpPostOut" />
  <wsdl:message name="BuildPharmacyUserSessionAccessHttpPostIn">
    <wsdl:part name="userId" type="s:string" />
    <wsdl:part name="sessionId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="BuildPharmacyUserSessionAccessHttpPostOut">
    <wsdl:part name="Body" element="tns:boolean" />
  </wsdl:message>
  <wsdl:message name="EmulatePharmacyUserSessionAccessHttpPostIn">
    <wsdl:part name="akaName" type="s:string" />
    <wsdl:part name="emulatedAKAName" type="s:string" />
    <wsdl:part name="sessionID" type="s:string" />
    <wsdl:part name="originGenKey" type="s:string" />
  </wsdl:message>
  <wsdl:message name="EmulatePharmacyUserSessionAccessHttpPostOut">
    <wsdl:part name="Body" element="tns:boolean" />
  </wsdl:message>
  <wsdl:message name="BuildEmulationUserSessionAccessHttpPostIn">
    <wsdl:part name="akaName" type="s:string" />
    <wsdl:part name="emulatedAKAName" type="s:string" />
    <wsdl:part name="sessionID" type="s:string" />
    <wsdl:part name="originGenKey" type="s:string" />
  </wsdl:message>
  <wsdl:message name="BuildEmulationUserSessionAccessHttpPostOut">
    <wsdl:part name="Body" element="tns:int" />
  </wsdl:message>
  <wsdl:message name="EmulateReconcileMemberREHttpPostIn">
    <wsdl:part name="EmulatedAkaName" type="s:string" />
    <wsdl:part name="CSRAkaName" type="s:string" />
    <wsdl:part name="SessionID" type="s:string" />
    <wsdl:part name="PortOfOrigin" type="s:string" />
    <wsdl:part name="SystemGUID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="EmulateReconcileMemberREHttpPostOut">
    <wsdl:part name="Body" element="tns:boolean" />
  </wsdl:message>
  <wsdl:portType name="SessionManagementWebServiceSoap">
    <wsdl:operation name="GetAndExtendSession">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Get And ExtendSession</wsdl:documentation>
      <wsdl:input message="tns:GetAndExtendSessionSoapIn" />
      <wsdl:output message="tns:GetAndExtendSessionSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSession">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Get Session Details</wsdl:documentation>
      <wsdl:input message="tns:GetSessionSoapIn" />
      <wsdl:output message="tns:GetSessionSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="LogOutSession">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">End Session</wsdl:documentation>
      <wsdl:input message="tns:LogOutSessionSoapIn" />
    </wsdl:operation>
    <wsdl:operation name="GetAndExtendSessionEx">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Get And ExtendSession</wsdl:documentation>
      <wsdl:input message="tns:GetAndExtendSessionExSoapIn" />
      <wsdl:output message="tns:GetAndExtendSessionExSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetUserSessionDetails">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Get user session detail along with user and entity info in XML format. This method uses RPC protocol</wsdl:documentation>
      <wsdl:input message="tns:GetUserSessionDetailsSoapIn" />
      <wsdl:output message="tns:GetUserSessionDetailsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSessionEx">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Get Session Details</wsdl:documentation>
      <wsdl:input message="tns:GetSessionExSoapIn" />
      <wsdl:output message="tns:GetSessionExSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="LogOutSessionEx">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">End Session</wsdl:documentation>
      <wsdl:input message="tns:LogOutSessionExSoapIn" />
    </wsdl:operation>
    <wsdl:operation name="BuildPharmacyUserSessionAccess">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Build Pharmacy User Session Access</wsdl:documentation>
      <wsdl:input message="tns:BuildPharmacyUserSessionAccessSoapIn" />
      <wsdl:output message="tns:BuildPharmacyUserSessionAccessSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="EmulatePharmacyUserSessionAccess">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Emulate Pharmacy User Session Access</wsdl:documentation>
      <wsdl:input message="tns:EmulatePharmacyUserSessionAccessSoapIn" />
      <wsdl:output message="tns:EmulatePharmacyUserSessionAccessSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="BuildEmulationUserSessionAccess">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Emulate User Session Access for Member/Provider/Employer</wsdl:documentation>
      <wsdl:input message="tns:BuildEmulationUserSessionAccessSoapIn" />
      <wsdl:output message="tns:BuildEmulationUserSessionAccessSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="EmulateReconcileMemberRE">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Run Rules Engine reconciliation and insert into USA Table</wsdl:documentation>
      <wsdl:input message="tns:EmulateReconcileMemberRESoapIn" />
      <wsdl:output message="tns:EmulateReconcileMemberRESoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="SessionManagementWebServiceHttpGet">
    <wsdl:operation name="GetAndExtendSessionEx">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Get And ExtendSession</wsdl:documentation>
      <wsdl:input message="tns:GetAndExtendSessionExHttpGetIn" />
      <wsdl:output message="tns:GetAndExtendSessionExHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetUserSessionDetails">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Get user session detail along with user and entity info in XML format. This method uses RPC protocol</wsdl:documentation>
      <wsdl:input message="tns:GetUserSessionDetailsHttpGetIn" />
      <wsdl:output message="tns:GetUserSessionDetailsHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSessionEx">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Get Session Details</wsdl:documentation>
      <wsdl:input message="tns:GetSessionExHttpGetIn" />
      <wsdl:output message="tns:GetSessionExHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="LogOutSessionEx">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">End Session</wsdl:documentation>
      <wsdl:input message="tns:LogOutSessionExHttpGetIn" />
      <wsdl:output message="tns:LogOutSessionExHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="BuildPharmacyUserSessionAccess">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Build Pharmacy User Session Access</wsdl:documentation>
      <wsdl:input message="tns:BuildPharmacyUserSessionAccessHttpGetIn" />
      <wsdl:output message="tns:BuildPharmacyUserSessionAccessHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="EmulatePharmacyUserSessionAccess">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Emulate Pharmacy User Session Access</wsdl:documentation>
      <wsdl:input message="tns:EmulatePharmacyUserSessionAccessHttpGetIn" />
      <wsdl:output message="tns:EmulatePharmacyUserSessionAccessHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="BuildEmulationUserSessionAccess">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Emulate User Session Access for Member/Provider/Employer</wsdl:documentation>
      <wsdl:input message="tns:BuildEmulationUserSessionAccessHttpGetIn" />
      <wsdl:output message="tns:BuildEmulationUserSessionAccessHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="EmulateReconcileMemberRE">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Run Rules Engine reconciliation and insert into USA Table</wsdl:documentation>
      <wsdl:input message="tns:EmulateReconcileMemberREHttpGetIn" />
      <wsdl:output message="tns:EmulateReconcileMemberREHttpGetOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="SessionManagementWebServiceHttpPost">
    <wsdl:operation name="GetAndExtendSessionEx">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Get And ExtendSession</wsdl:documentation>
      <wsdl:input message="tns:GetAndExtendSessionExHttpPostIn" />
      <wsdl:output message="tns:GetAndExtendSessionExHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetUserSessionDetails">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Get user session detail along with user and entity info in XML format. This method uses RPC protocol</wsdl:documentation>
      <wsdl:input message="tns:GetUserSessionDetailsHttpPostIn" />
      <wsdl:output message="tns:GetUserSessionDetailsHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSessionEx">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Get Session Details</wsdl:documentation>
      <wsdl:input message="tns:GetSessionExHttpPostIn" />
      <wsdl:output message="tns:GetSessionExHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="LogOutSessionEx">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">End Session</wsdl:documentation>
      <wsdl:input message="tns:LogOutSessionExHttpPostIn" />
      <wsdl:output message="tns:LogOutSessionExHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="BuildPharmacyUserSessionAccess">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Build Pharmacy User Session Access</wsdl:documentation>
      <wsdl:input message="tns:BuildPharmacyUserSessionAccessHttpPostIn" />
      <wsdl:output message="tns:BuildPharmacyUserSessionAccessHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="EmulatePharmacyUserSessionAccess">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Emulate Pharmacy User Session Access</wsdl:documentation>
      <wsdl:input message="tns:EmulatePharmacyUserSessionAccessHttpPostIn" />
      <wsdl:output message="tns:EmulatePharmacyUserSessionAccessHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="BuildEmulationUserSessionAccess">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Emulate User Session Access for Member/Provider/Employer</wsdl:documentation>
      <wsdl:input message="tns:BuildEmulationUserSessionAccessHttpPostIn" />
      <wsdl:output message="tns:BuildEmulationUserSessionAccessHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="EmulateReconcileMemberRE">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Run Rules Engine reconciliation and insert into USA Table</wsdl:documentation>
      <wsdl:input message="tns:EmulateReconcileMemberREHttpPostIn" />
      <wsdl:output message="tns:EmulateReconcileMemberREHttpPostOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="SessionManagementWebServiceSoap" type="tns:SessionManagementWebServiceSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetAndExtendSession">
      <soap:operation soapAction="urn:dummy:WebSecurity:WebServices/GetAndExtendSession" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSession">
      <soap:operation soapAction="urn:dummy:WebSecurity:WebServices/GetSession" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LogOutSession">
      <soap:operation soapAction="urn:dummy:WebSecurity:WebServices/LogOutSession" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
    </wsdl:operation>
    <wsdl:operation name="GetAndExtendSessionEx">
      <soap:operation soapAction="urn:dummy:WebSecurity:WebServices/GetAndExtendSessionEx" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetUserSessionDetails">
      <soap:operation soapAction="urn:dummy:WebSecurity:WebServices/GetUserSessionDetails" style="rpc" />
      <wsdl:input>
        <soap:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSessionEx">
      <soap:operation soapAction="urn:dummy:WebSecurity:WebServices/GetSessionEx" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LogOutSessionEx">
      <soap:operation soapAction="urn:dummy:WebSecurity:WebServices/LogOutSessionEx" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
    </wsdl:operation>
    <wsdl:operation name="BuildPharmacyUserSessionAccess">
      <soap:operation soapAction="urn:dummy:WebSecurity:WebServices/BuildPharmacyUserSessionAccess" style="rpc" />
      <wsdl:input>
        <soap:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="EmulatePharmacyUserSessionAccess">
      <soap:operation soapAction="urn:dummy:WebSecurity:WebServices/EmulatePharmacyUserSessionAccess" style="rpc" />
      <wsdl:input>
        <soap:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="BuildEmulationUserSessionAccess">
      <soap:operation soapAction="urn:dummy:WebSecurity:WebServices/BuildEmulationUserSessionAccess" style="rpc" />
      <wsdl:input>
        <soap:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="EmulateReconcileMemberRE">
      <soap:operation soapAction="urn:dummy:WebSecurity:WebServices/EmulateReconcileMemberRE" style="rpc" />
      <wsdl:input>
        <soap:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="SessionManagementWebServiceSoap12" type="tns:SessionManagementWebServiceSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetAndExtendSession">
      <soap12:operation soapAction="urn:dummy:WebSecurity:WebServices/GetAndExtendSession" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSession">
      <soap12:operation soapAction="urn:dummy:WebSecurity:WebServices/GetSession" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LogOutSession">
      <soap12:operation soapAction="urn:dummy:WebSecurity:WebServices/LogOutSession" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
    </wsdl:operation>
    <wsdl:operation name="GetAndExtendSessionEx">
      <soap12:operation soapAction="urn:dummy:WebSecurity:WebServices/GetAndExtendSessionEx" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetUserSessionDetails">
      <soap12:operation soapAction="urn:dummy:WebSecurity:WebServices/GetUserSessionDetails" style="rpc" />
      <wsdl:input>
        <soap12:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://www.w3.org/2003/05/soap-encoding" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://www.w3.org/2003/05/soap-encoding" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSessionEx">
      <soap12:operation soapAction="urn:dummy:WebSecurity:WebServices/GetSessionEx" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LogOutSessionEx">
      <soap12:operation soapAction="urn:dummy:WebSecurity:WebServices/LogOutSessionEx" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
    </wsdl:operation>
    <wsdl:operation name="BuildPharmacyUserSessionAccess">
      <soap12:operation soapAction="urn:dummy:WebSecurity:WebServices/BuildPharmacyUserSessionAccess" style="rpc" />
      <wsdl:input>
        <soap12:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://www.w3.org/2003/05/soap-encoding" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://www.w3.org/2003/05/soap-encoding" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="EmulatePharmacyUserSessionAccess">
      <soap12:operation soapAction="urn:dummy:WebSecurity:WebServices/EmulatePharmacyUserSessionAccess" style="rpc" />
      <wsdl:input>
        <soap12:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://www.w3.org/2003/05/soap-encoding" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://www.w3.org/2003/05/soap-encoding" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="BuildEmulationUserSessionAccess">
      <soap12:operation soapAction="urn:dummy:WebSecurity:WebServices/BuildEmulationUserSessionAccess" style="rpc" />
      <wsdl:input>
        <soap12:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://www.w3.org/2003/05/soap-encoding" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://www.w3.org/2003/05/soap-encoding" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="EmulateReconcileMemberRE">
      <soap12:operation soapAction="urn:dummy:WebSecurity:WebServices/EmulateReconcileMemberRE" style="rpc" />
      <wsdl:input>
        <soap12:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://www.w3.org/2003/05/soap-encoding" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="encoded" namespace="urn:dummy:WebSecurity:WebServices" encodingStyle="http://www.w3.org/2003/05/soap-encoding" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="SessionManagementWebServiceHttpGet" type="tns:SessionManagementWebServiceHttpGet">
    <http:binding verb="GET" />
    <wsdl:operation name="GetAndExtendSessionEx">
      <http:operation location="/GetAndExtendSessionEx" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetUserSessionDetails">
      <http:operation location="/GetUserSessionDetails" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSessionEx">
      <http:operation location="/GetSessionEx" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LogOutSessionEx">
      <http:operation location="/LogOutSessionEx" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
    <wsdl:operation name="BuildPharmacyUserSessionAccess">
      <http:operation location="/BuildPharmacyUserSessionAccess" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="EmulatePharmacyUserSessionAccess">
      <http:operation location="/EmulatePharmacyUserSessionAccess" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="BuildEmulationUserSessionAccess">
      <http:operation location="/BuildEmulationUserSessionAccess" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="EmulateReconcileMemberRE">
      <http:operation location="/EmulateReconcileMemberRE" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="SessionManagementWebServiceHttpPost" type="tns:SessionManagementWebServiceHttpPost">
    <http:binding verb="POST" />
    <wsdl:operation name="GetAndExtendSessionEx">
      <http:operation location="/GetAndExtendSessionEx" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetUserSessionDetails">
      <http:operation location="/GetUserSessionDetails" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSessionEx">
      <http:operation location="/GetSessionEx" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="LogOutSessionEx">
      <http:operation location="/LogOutSessionEx" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
    <wsdl:operation name="BuildPharmacyUserSessionAccess">
      <http:operation location="/BuildPharmacyUserSessionAccess" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="EmulatePharmacyUserSessionAccess">
      <http:operation location="/EmulatePharmacyUserSessionAccess" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="BuildEmulationUserSessionAccess">
      <http:operation location="/BuildEmulationUserSessionAccess" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="EmulateReconcileMemberRE">
      <http:operation location="/EmulateReconcileMemberRE" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="SessionManagementWebService">
    <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">This Webservice provides method to maintain Session of a provided Session Id</wsdl:documentation>
    <wsdl:port name="SessionManagementWebServiceSoap" binding="tns:SessionManagementWebServiceSoap">
      <soap:address location="http://test-slwebservices.dummy.com/SessionManagementWebService/SessionManagementWebService.asmx" />
    </wsdl:port>
    <wsdl:port name="SessionManagementWebServiceSoap12" binding="tns:SessionManagementWebServiceSoap12">
      <soap12:address location="http://test-slwebservices.dummy.com/SessionManagementWebService/SessionManagementWebService.asmx" />
    </wsdl:port>
    <wsdl:port name="SessionManagementWebServiceHttpGet" binding="tns:SessionManagementWebServiceHttpGet">
      <http:address location="http://test-slwebservices.dummy.com/SessionManagementWebService/SessionManagementWebService.asmx" />
    </wsdl:port>
    <wsdl:port name="SessionManagementWebServiceHttpPost" binding="tns:SessionManagementWebServiceHttpPost">
      <http:address location="http://test-slwebservices.dummy.com/SessionManagementWebService/SessionManagementWebService.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>
/**
 * SessionManagementWebServiceSoapPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dummy.controller.session;

public interface SessionManagementWebServiceSoapPortType extends java.rmi.Remote {

    /**
     * Get And ExtendSession
     */
    public com.dummy.controller.session.ResponseSession getAndExtendSession(com.dummy.controller.session.RequestForSession requestForSession) throws java.rmi.RemoteException;

    /**
     * Get Session Details
     */
    public com.dummy.controller.session.ResponseSession getSession(com.dummy.controller.session.RequestForSession requestForSession, boolean extendFlag) throws java.rmi.RemoteException;

    /**
     * End Session
     */
    public void logOutSession(com.dummy.controller.session.RequestForSession requestForSession) throws java.rmi.RemoteException;

    /**
     * Get And ExtendSession
     */
    public com.dummy.controller.session.ResponseSession getAndExtendSessionEx(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * Get user session detail along with user and entity info in
     * XML format. This method uses RPC protocol
     */
    public java.lang.String getUserSessionDetails(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * Get Session Details
     */
    public com.dummy.controller.session.ResponseSession getSessionEx(java.lang.String sessionId, boolean extendFlag) throws java.rmi.RemoteException;

    /**
     * End Session
     */
    public void logOutSessionEx(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * Build Pharmacy User Session Access
     */
    public boolean buildPharmacyUserSessionAccess(java.lang.String userId, java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * Emulate Pharmacy User Session Access
     */
    public boolean emulatePharmacyUserSessionAccess(java.lang.String akaName, java.lang.String emulatedAKAName, java.lang.String sessionID, int originGenKey) throws java.rmi.RemoteException;

    /**
     * Emulate User Session Access for Member/Provider/Employer
     */
    public int buildEmulationUserSessionAccess(java.lang.String akaName, java.lang.String emulatedAKAName, java.lang.String sessionID, int originGenKey) throws java.rmi.RemoteException;

    /**
     * Run Rules Engine reconciliation and insert into USA Table
     */
    public boolean emulateReconcileMemberRE(java.lang.String emulatedAkaName, java.lang.String csrAkaName, java.lang.String sessionID, int portOfOrigin, java.lang.String systemGUID) throws java.rmi.RemoteException;
}

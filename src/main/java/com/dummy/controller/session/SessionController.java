package com.dummy.controller.session;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;import com.dummy.controller.acl.AccessControlDriverWebServiceLocator;
import com.dummy.controller.acl.AccessControlDriverWebServiceSoap_PortType;
import com.dummy.controller.acl.ResponseBFForUser;
import com.dummy.exception.dummyBusinessException;
import com.dummy.utlities.StringUtils;

/**
 * Created by CXG8646 on 7/7/2015.
 */
@Controller
@RequestMapping("rest/session")
public class SessionController
{
    private static final Logger logger = Logger.getLogger( SessionController.class );
    
    @RequestMapping(value = "azure", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<UserInfoAzure> azure( @CookieValue("token") String token )
    {
        logger.info("Azure Session Token Value - " + token);
    	if(token == "" || token == null){
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
        try
        {            
            TrustManager[] trustAllCerts = new TrustManager[]{ new X509TrustManager( )
            {
                public X509Certificate[] getAcceptedIssuers( )
                {
                    return new X509Certificate[0];
                }
                public void checkClientTrusted( java.security.cert.X509Certificate[] certs, String authType )
                {
                	//Do nothing.  Exists to satisfy X509TrustManager interface.
                }
                public void checkServerTrusted( java.security.cert.X509Certificate[] certs, String authType )
                {
                	//Do nothing.  Exists to satisfy X509TrustManager interface.
                }
            } };
            
            try
            {
                SSLContext sc = SSLContext.getInstance( "TLSv1.2" );
                sc.init( null, trustAllCerts, new java.security.SecureRandom( ) );
                HttpsURLConnection.setDefaultSSLSocketFactory( sc.getSocketFactory( ) );
            }
            catch( GeneralSecurityException e )
            {
                logger.error( e.getMessage( ) );
            }
            HttpHeaders headers = new HttpHeaders();
            
            logger.info("User token: " + token);
            headers.set("Authorization", "Bearer " + token);
            
            RestTemplate rt = new RestTemplate();
            ResponseEntity<UserInfoAzure> userDetails = rt.exchange("https://graph.microsoft.com/v1.0/me/?$Select=displayName,employeeId,onPremisesSamAccountName", HttpMethod.GET, new HttpEntity<Object>(headers), UserInfoAzure.class);
            
            logger.info("User logged in Azure is "+ userDetails.getBody().getDisplayName() + " , userID: " + userDetails.getBody().getOnPremisesSamAccountName());
            
            if(userDetails.getStatusCode() == HttpStatus.OK){
            	return new ResponseEntity<>(userDetails.getBody(), HttpStatus.OK);
            }else{
            	return new ResponseEntity<>(userDetails.getStatusCode());
            }

         }catch(Exception e){
            logger.error("Exception caught", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
        
    }
    
    
    /*
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public ResponseEntity<String> noIdsession( @CookieValue("SessionID") String sessionID)
    {
        String response = getSessionInfoFromSessionID( sessionID )

        if( response != null )
        {
            return new ResponseEntity<>( response, HttpStatus.OK )
        }
        else
        {
            return new ResponseEntity<>( "", HttpStatus.INTERNAL_SERVER_ERROR )
        }
    }*/

   /* @RequestMapping(method = RequestMethod.GET, value = { "/{sessionID}" }, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public ResponseEntity<String> sessionById( @PathVariable("sessionID") String sessionID)
    {
        String response = getSessionInfoFromSessionID( sessionID );

        if( response != null )
        {
            return new ResponseEntity<>( response, HttpStatus.OK );
        }
        else
        {
            return new ResponseEntity<>( "", HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    public static String getSessionInfoFromSessionID( String sessionID )
    {
        try
        {
            com.dummy.controller.session.SessionManagementWebServiceLocator locator = new com.dummy.controller.session.SessionManagementWebServiceLocator( );
            SessionManagementWebServiceSoapPortType service = locator.getSessionManagementWebServiceSoap12( );

            return service.getUserSessionDetails( sessionID );
        }
        catch( Exception e )
        {
            logger.error( "Error: " + e.toString( ) );
            return null;
        }
    }

    public static Map<String, String> getUserDetailsFromSessionID( String sessionID ) throws dummyBusinessException
    {
        logger.info( "Checking user details for session: \"" + StringUtils.encode( sessionID ) + "\"" );
        HashMap<String, String> response = new HashMap<>( );
        try{
        	String sessionData = SessionController.getSessionInfoFromSessionID( sessionID );

        	if(sessionData == null)
        	{
            	throw new dummyBusinessException(" null SessionData");
        	}
        	
        	int indexBegin = sessionData.lastIndexOf( "<NoRecordFound>" );
        	int indexEnd = sessionData.lastIndexOf( "</NoRecordFound>" );
        	String sessionRecord = sessionData.substring( indexBegin + 15, indexEnd );

        	indexBegin = sessionData.lastIndexOf( "<ResponseStatus>" );
        	indexEnd = sessionData.lastIndexOf( "</ResponseStatus>" );
        	String sessionStatus = sessionData.substring( indexBegin + 16, indexEnd );

	        if( sessionRecord.equals( "False" ) && sessionStatus.equals( "Success" ) )
	        {
	            indexBegin = sessionData.lastIndexOf( "<FirstName>" );
	            indexEnd = sessionData.lastIndexOf( "</FirstName>" );
	            String resultName = sessionData.substring( indexBegin + 11, indexEnd );
	
	            indexBegin = sessionData.lastIndexOf( "<LastName>" );
	            indexEnd = sessionData.lastIndexOf( "</LastName>" );
	            String resultLastName = sessionData.substring( indexBegin + 10, indexEnd );
	
	            indexBegin = sessionData.lastIndexOf( "<UserID>" );
	            indexEnd = sessionData.lastIndexOf( "</UserID>" );
	            String resultUserID = sessionData.substring( indexBegin + 8, indexEnd );
	
	            indexBegin = sessionData.lastIndexOf( "<EntityUserAttribute Identifier=\"HR_TSOID\" value=\"" );
	            indexEnd = sessionData.lastIndexOf( "\" /></EntityUserAttributes>" );
	            String resultHumadUserID = "";
	            if( indexBegin != -1 )
	            {
	                resultHumadUserID = sessionData.substring( indexBegin + 50, indexEnd );
	            }
	            else
	            {
	                resultHumadUserID = resultUserID;
	            }
	
	            indexBegin = sessionData.lastIndexOf( "<AkaName>" );
	            indexEnd = sessionData.lastIndexOf( "</AkaName>" );
	            String akaName = sessionData.substring( indexBegin + 9, indexEnd );
	
	            response.put( "firstname", resultName );
	            response.put( "lastname", resultLastName );
	            response.put( "username", resultHumadUserID );
	            response.put( "akaName", akaName );
	        }
	        logger.info( "User logged in is " + StringUtils.encode( response.get( "username" ) ) + ": " + StringUtils.encode( response.get( "firstname" ) ) + " " + StringUtils.encode( response.get( "lastname" ) ) + " AKA "
	                + StringUtils.encode( response.get( "akaName" ) ) );
        }catch(NullPointerException e)
        {
        	logger.error(e.getMessage(), e);
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = { "/{sessionID}/{akaName}" }, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseBFForUser> businessFunction( @PathVariable("sessionID") String sessionID, @PathVariable("akaName") String akaName )
    {
        AccessControlDriverWebServiceLocator locator = new AccessControlDriverWebServiceLocator( );
        try
        {
            AccessControlDriverWebServiceSoap_PortType portType = locator.getAccessControlDriverWebServiceSoap12( );
            return new ResponseEntity<>( portType.getACLAccessIdsForUserEx( akaName, sessionID ), HttpStatus.OK );
        }
        catch( Exception e )
        {
            logger.error( "Error: " + e.toString( ) );
            return null;
        }
    }*/
} 
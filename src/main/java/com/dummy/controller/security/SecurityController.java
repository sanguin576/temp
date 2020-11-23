package com.dummy.controller.security;

import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.auth.InvalidCredentialsException;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.dummy.configuration.EnvironmentManager;
import com.dummy.configuration.VaultManager;
import com.dummy.controller.acl.AclController;
import com.dummy.controller.acl.Function;
import com.dummy.controller.session.MemberOfResponse;
import com.dummy.controller.session.MemberOfResponseValue;
import com.dummy.controller.session.SessionController;
import com.dummy.controller.session.SessionManagementWebServiceSoapPortType;
import com.dummy.exception.dummyBusinessException;
import com.dummy.model.reportsfavorites.ReportFavoritesModel;
import com.dummy.model.security.PortalReportsTreeModel;
import com.dummy.model.security.RequiredRoleModel;
import com.dummy.services.reportfavorites.ReportFavoritesService;
import com.dummy.services.security.PortalReportsTreeService;
import com.dummy.services.security.RequiredRoleService;
import com.dummy.utlities.Constants;
import com.dummy.utlities.EncryptionUtils;
import com.dummy.utlities.StringUtils;

@Controller
@RequestMapping("rest/security")
@PropertySource("classpath:dummyAppportal.properties")
public class SecurityController
{
    private static final String USER_SESSION_DETAIL = "UserSessionDetail";

	private static final String AUTHORIZATION_CONS = "authorization";

	private static final String NO_ROLES_MESSAGE = "No roles found for user ";

	private static final String USERNAME = "username";

	private static final String GLOBAL_LDAP_CONNECTIONPASS = "GLOBAL.LDAP.CONNECTIONPASS";

	private static final String GLOBAL_LDAP_CONNECTIONNAME = "GLOBAL.LDAP.CONNECTIONNAME";

	private static final String GLOBAL_LDAP_CONNECTIONURL = "GLOBAL.LDAP.CONNECTIONURL";

	private static final String GLOBAL_LDAP_CONTEXTFACTORY = "GLOBAL.LDAP.CONTEXTFACTORY";

	public static final String ROLES_KEY = "roles";

    public static final String ROLES_WITHOUT_BF_KEY = "roles_without_bf_key";

    public static final String TREE_SESSION_KEY = "tree";

    private static final Logger logger = Logger.getLogger( SecurityController.class );

    private ResourceBundle rb = ResourceBundle.getBundle( "dummyAppportal" );

    
    @Autowired
    RequiredRoleService requiredRoleService;

    @Autowired
    private PortalReportsTreeService treeService;

    @Autowired
    ReportFavoritesService reportFavoritesService;

    @Autowired
    ExcelBuilderUserInfo excelUserInfo;

    public static <T> List<T> intersection( List<T> list1, List<T> list2 )
    {
        List<T> list = new ArrayList<>( );

        for( T t : list1 )
        {
            if( list2.contains( t ) )
            {
                list.add( t );
            }
        }

        return list;
    }
    
    // Optional
    private static final String MEMBER_OF = "memberOf";
    private static final String[] attrIdsToSearch = new String[]{ MEMBER_OF };
    public static final String SEARCH_BY_SAM_ACCOUNT_NAME = "(sAMAccountName=%s)";
    public static final String SEARCH_GROUP_BY_GROUP_CN = "(&(objectCategory=group)(cn={0}))";
    private static String userBase = "DC=humad,DC=com";
    public static final String VAULT_MANAGER = "vaultManager";

    @RequestMapping(value = "authorization/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String, String>> cookieAuthentication( HttpServletRequest request, @PathVariable("userName") String userName, @CookieValue("token") String token ) throws NamingException, dummyBusinessException 
    {
    	userName = userName.replaceAll( Constants.ALPHA_NUMERIC_ONEORMORE, "" );
        logger.info("Accessing LDAP Roles for " +userName + token);
    	ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext( ContextLoaderListener.getCurrentWebApplicationContext( ).getServletContext( ) );
        VaultManager vaultManager = ( VaultManager )applicationContext.getBean( VAULT_MANAGER );

        HttpSession session = request.getSession();
        if (session.getAttribute(USERNAME) != null){
        	session.removeAttribute(USERNAME);
        }
        if (session.getAttribute(AUTHORIZATION_CONS) != null){
        	session.removeAttribute(AUTHORIZATION_CONS);
        } 
        Hashtable<String, String> env = new Hashtable<>( );
   

        // Configure our directory context environment.

        env.put( Context.INITIAL_CONTEXT_FACTORY, rb.getString( GLOBAL_LDAP_CONTEXTFACTORY ) );
        env.put( Context.PROVIDER_URL, rb.getString( GLOBAL_LDAP_CONNECTIONURL ) );
        env.put( Context.SECURITY_PRINCIPAL, rb.getString( GLOBAL_LDAP_CONNECTIONNAME ) );
        env.put( Context.SECURITY_CREDENTIALS, EncryptionUtils.decrypt( vaultManager.getConnect( GLOBAL_LDAP_CONNECTIONPASS)) );

        InitialDirContext context = new InitialDirContext( env );
        String filter = String.format( SEARCH_BY_SAM_ACCOUNT_NAME, userName );
        SearchControls constraints = new SearchControls( );
        constraints.setSearchScope( SearchControls.SUBTREE_SCOPE );
        constraints.setReturningAttributes( attrIdsToSearch );
        NamingEnumeration<SearchResult> results = context.search( userBase, filter, constraints );

        // Fail if no entries found
        if( results == null || !results.hasMore( ) )
        {
            logger.error( NO_ROLES_MESSAGE + StringUtils.encode(userName));
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

        // Get result for the first entry found
        SearchResult result = results.next( );

        // Get the entry's attributes
        Attributes attrs = result.getAttributes( );
        Attribute attr = attrs.get( attrIdsToSearch[ 0 ] );

        NamingEnumeration<?> e = attr.getAll( );
        String value = null;
        HashSet<String> roles = new HashSet<>( );
        while( e.hasMore( ) )
        {
            value = ( String )e.next( );
            if( value != null )
            {
                // get only Group name (Ex: G_VAS_WebDevelopers)
                roles.add( value.substring( value.indexOf( '=' ) + 1, value.indexOf( ',' ) ) );
            }
        }
        request.getSession( ).setAttribute( ROLES_WITHOUT_BF_KEY, new HashSet<>( roles ) );

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
            catch( GeneralSecurityException ex )
            {
                logger.error( ex.getMessage( ) );
            }
            
            HttpHeaders headers = new HttpHeaders();
            
            logger.info("User token: " + token);
            headers.set("Authorization", "Bearer " + token);
            RestTemplate rt = new RestTemplate();
            ResponseEntity<MemberOfResponse> memberOf = rt.exchange("https://graph.microsoft.com/v1.0/me/memberOf?$select=displayName", HttpMethod.GET, new HttpEntity<Object>(headers), MemberOfResponse.class);
            
            if(memberOf.getStatusCode() == HttpStatus.OK){
                for(MemberOfResponseValue v : memberOf.getBody().getValue()){
                    String groupName = v.getDisplayName();
                    if(groupName!= null && groupName != "" && groupName.contains("g_Azure_SL_Test_dummyApp")) {
                        String[] groupParams = groupName.split("_");
                        roles.add(groupParams[groupParams.length-1]);
                        logger.info(groupParams[groupParams.length-1]);
                    }
                    // if(v.getDisplayName() != null && v.getDisplayName() != ""){
                    // 	roles.add( v.getDisplayName() );
                    // }
                }
            }
            request.getSession( ).setAttribute( "ACL_BF_KEY", new HashSet<>( roles ) );
            
        
        
        // Add Business functions as roles for Security
        /*Function[] businessFunctions = AclController.getACLAccessIdsForUserEx( userDetails.get( "akaName" ), saneSessionID, request );

        if( businessFunctions != null )
        {
            for( Function function : businessFunctions )
            {
                roles.add( function.getName( ) );
            }
        }*/

        // Get the required roles from DB
        List<RequiredRoleModel> requiredRoles = requiredRoleService.findActiveRequiredRoles( );

        // Match roles and requirements
        HashMap<String, String> authorization = new HashMap<>( );
        for( RequiredRoleModel requiredRoleRow : requiredRoles )
        {
            List<String> requiredRolesList = java.util.Arrays.asList( requiredRoleRow.getEditRoles( ).split( "," ) );
            for( String requiredRole : requiredRolesList )
            {
                logger.info("Required Roles Bro - " + requiredRole);
                if( roles.contains( requiredRole ) )
                {
                    authorization.put( requiredRoleRow.getReportName( ), "edit" );
                    break;
                }
            }
        }

    	session.setAttribute( USERNAME, userName.replaceAll( Constants.ALPHA_NUMERIC_ONEORMORE, "" ) );	
        session.setAttribute( AUTHORIZATION_CONS, authorization );

        return new ResponseEntity<>( authorization, HttpStatus.OK );
    }

    /*@RequestMapping(value = "authorization/{sessionID}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String, String>> authorization( HttpServletRequest request, @PathVariable("sessionID") String sessionID ) throws NamingException, dummyBusinessException
    {
    	String saneSessionID = sessionID.replaceAll( Constants.ALPHA_NUMERIC_ONEORMORE, "" );
        HashMap<String, String> userDetails = (HashMap<String, String>) SessionController.getUserDetailsFromSessionID( saneSessionID );
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext( ContextLoaderListener.getCurrentWebApplicationContext( ).getServletContext( ) );
        VaultManager vaultManager = ( VaultManager )applicationContext.getBean( VAULT_MANAGER );

        HttpSession session = request.getSession();  
        if (session.getAttribute(USERNAME) != null){
        	session.removeAttribute(USERNAME);
        }
        if (session.getAttribute(AUTHORIZATION_CONS) != null){
        	session.removeAttribute(AUTHORIZATION_CONS);
        }
        Hashtable<String, String> env = new Hashtable<>( );

        // Configure our directory context environment.

        env.put( Context.INITIAL_CONTEXT_FACTORY, rb.getString( GLOBAL_LDAP_CONTEXTFACTORY ) );
        env.put( Context.PROVIDER_URL, rb.getString( GLOBAL_LDAP_CONNECTIONURL ) );
        env.put( Context.SECURITY_PRINCIPAL, rb.getString( GLOBAL_LDAP_CONNECTIONNAME ) );
        env.put( Context.SECURITY_CREDENTIALS, EncryptionUtils.decrypt( vaultManager.getConnect( GLOBAL_LDAP_CONNECTIONPASS)) );

        InitialDirContext context = new InitialDirContext( env );
        String filter = String.format( SEARCH_BY_SAM_ACCOUNT_NAME, userDetails.get( USERNAME ) );
        SearchControls constraints = new SearchControls( );
        constraints.setSearchScope( SearchControls.SUBTREE_SCOPE );
        constraints.setReturningAttributes( attrIdsToSearch );
        NamingEnumeration<SearchResult> results = context.search( userBase, filter, constraints );

        // Fail if no entries found
        if( results == null || !results.hasMore( ) )
        {
            logger.error( NO_ROLES_MESSAGE + StringUtils.encode(userDetails.get( USERNAME )));
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

        // Get result for the first entry found
        SearchResult result = results.next( );

        // Get the entry's attributes
        Attributes attrs = result.getAttributes( );
        Attribute attr = attrs.get( attrIdsToSearch[ 0 ] );

        NamingEnumeration<?> e = attr.getAll( );
        String value = null;
        HashSet<String> roles = new HashSet<>( );
        while( e.hasMore( ) )
        {
            value = ( String )e.next( );
            if( value != null )
            {
                // get only Group name (Ex: G_VAS_WebDevelopers)
                roles.add( value.substring( value.indexOf( '=' ) + 1, value.indexOf( ',' ) ) );
            }
        }

        request.getSession( ).setAttribute( ROLES_WITHOUT_BF_KEY, new HashSet<>( roles ) );

        // Add Business functions as roles for Security
        Function[] businessFunctions = AclController.getACLAccessIdsForUserEx( userDetails.get( "akaName" ), sessionID, request );

        if( businessFunctions != null )
        {
            for( Function function : businessFunctions )
            {
                roles.add( function.getName( ) );
            }
        }

        // Get the required roles from DB
        List<RequiredRoleModel> requiredRoles = requiredRoleService.findActiveRequiredRoles( );

        // Match roles and requirements
        HashMap<String, String> authorization = new HashMap<>( );
        for( RequiredRoleModel requiredRoleRow : requiredRoles )
        {
            List<String> requiredRolesList = java.util.Arrays.asList( requiredRoleRow.getEditRoles( ).split( "," ) );
            for( String requiredRole : requiredRolesList )
            {
                if( roles.contains( requiredRole ) )
                {
                    authorization.put( requiredRoleRow.getReportName( ), "edit" );
                    break;
                }
            }
        }

        session.setAttribute( USERNAME, userDetails.get( USERNAME ) );
        session.setAttribute( AUTHORIZATION_CONS, authorization );

        return new ResponseEntity<>( authorization, HttpStatus.OK );
    }*/
/*
    @RequestMapping(value = "roles/{username}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashSet<String>> roles( HttpServletRequest request, @PathVariable(USERNAME) String username ) throws NamingException
    {
        // Sanitized input to allow only alphanumeric values without spaces
        String sUsername = username.replaceAll( Constants.ALPHA_NUMERIC_UNDERS_ONEORMORE, "" );
        
        HashSet<String> roles;
        try
        {
            roles = (HashSet<String>) getRoles( request, sUsername );
        }
        catch( InvalidCredentialsException e )
        {
        	logger.error(e.getMessage(), e);
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

        return new ResponseEntity<>( roles, HttpStatus.OK );
    }

    public Set<String> getRoles( HttpServletRequest request, String username ) throws NamingException, InvalidCredentialsException
    {
        HashSet<String> roles = new HashSet<>( );
        Hashtable<String, String> env = new Hashtable<>( );
        
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext( ContextLoaderListener.getCurrentWebApplicationContext( ).getServletContext( ) );
        VaultManager vaultManager = ( VaultManager )applicationContext.getBean( VAULT_MANAGER );

        // Configure our directory context environment.
        env.put( Context.INITIAL_CONTEXT_FACTORY, rb.getString( GLOBAL_LDAP_CONTEXTFACTORY ) );
        env.put( Context.PROVIDER_URL, rb.getString( GLOBAL_LDAP_CONNECTIONURL ) );
        env.put( Context.SECURITY_PRINCIPAL, rb.getString( GLOBAL_LDAP_CONNECTIONNAME ) );
        env.put( Context.SECURITY_CREDENTIALS, EncryptionUtils.decrypt( vaultManager.getConnect( GLOBAL_LDAP_CONNECTIONPASS)) );

        InitialDirContext context = new InitialDirContext( env );
        String filter = String.format( SEARCH_BY_SAM_ACCOUNT_NAME, username );
        SearchControls constraints = new SearchControls( );
        constraints.setSearchScope( SearchControls.SUBTREE_SCOPE );
        constraints.setReturningAttributes( attrIdsToSearch );
        NamingEnumeration<SearchResult> results = context.search( userBase, filter, constraints );

        // Fail if no entries found
        if( results == null || !results.hasMore( ) )
        {
            logger.error( NO_ROLES_MESSAGE + StringUtils.encode(username));
            throw new InvalidCredentialsException( "" );
        }

        // Get result for the first entry found
        SearchResult result = results.next( );

        // Get the entry's attributes
        Attributes attrs = result.getAttributes( );
        Attribute attr = attrs.get( attrIdsToSearch[ 0 ] );

        NamingEnumeration<?> e = attr.getAll( );
        String value = null;

        while( e.hasMore( ) )
        {
            value = ( String )e.next( );
            if( value != null )
            {
                // get only Group name (Ex: G_VAS_WebDevelopers)
                roles.add( value.substring( value.indexOf('=' ) + 1, value.indexOf( ',' ) ) );
            }
        }

        request.getSession( ).setAttribute( ROLES_WITHOUT_BF_KEY, new HashSet<>( roles ) );

        // Add Business functions as roles for Security
        Function[] businessFunctions = ( Function[] )request.getSession( ).getAttribute( AclController.ACL_BUSINESS_FUNCTIONS_KEY );

        if( businessFunctions != null )
        {

            for( Function function : businessFunctions )
            {
                roles.add( function.getName( ).replaceAll(Constants.ALPHA_NUMERIC_SPECIAL_CHAR, "") );
            }
        }

        request.getSession( ).setAttribute( ROLES_KEY, roles );

        return roles;
    }

    @RequestMapping(value = "tree/{username}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, List<?>>> tree( HttpServletRequest request, @PathVariable(USERNAME) String username )
    {
        // Sanitized input to allow only alphanumeric values without spaces
        String sUsername = username.replaceAll( "[^A-Za-z0-9_]+", "" );

        List<PortalReportsTreeModel> nodes = null;
        Map<String, List<?>> json = new HashMap<>( );
        try
        {
            nodes = treeService.findOne( PortalReportsTreeModel.ROOT ).getChildren( );
            List<String> roles = new ArrayList<>( getRoles( request, sUsername ) );

            @SuppressWarnings("unchecked")
            java.util.HashMap<String, String> auth = ( HashMap<String, String> )request.getSession( ).getAttribute( AUTHORIZATION_CONS );
            
            if( auth == null || auth.isEmpty( ) )
            {
            	//authorization( request, sUsername );
            }
                
            List<ReportFavoritesModel> favorites = reportFavoritesService.findReportFavoritesByUserId( sUsername );

            List<ReportFavoritesModel> favoritesTwo = new ArrayList<>( );

            apply( nodes, roles, favorites, favoritesTwo );

            json.put( "tree", nodes );
            json.put( "favorites", favoritesTwo );
        }
        catch( Exception e )
        {
        	logger.error(e.getMessage(), e);
        	logger.error( "Error getting tree = ", e );
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

        return new ResponseEntity<>( json, HttpStatus.OK );
    }
*/
    @RequestMapping(value = "userInfo", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> userInfo( HttpServletRequest request )
    {
        JSONObject json = new JSONObject( );

        @SuppressWarnings("unchecked")
        HashSet<String> roles = ( HashSet<String> )request.getSession( ).getAttribute( ROLES_WITHOUT_BF_KEY );
        List<String> rolesList = new ArrayList<>( roles );

        Collections.sort( rolesList );

        json.put( ROLES_KEY, rolesList );

        HashSet<String> businessFunctions = ( HashSet<String> )request.getSession( ).getAttribute( "ACL_BF_KEY");

        List<String> bf = new ArrayList<>( businessFunctions );

       /* if( businessFunctions != null )
        {
            for( Function function : businessFunctions )
            {
                bf.add( function.getName( ) );
            }
        }*/

        Collections.sort( bf );
        json.put( "business", bf );

        return new ResponseEntity<>( json.toString( ), HttpStatus.OK );
    }
/*
    private void apply( List<PortalReportsTreeModel> nodes, List<String> roles, List<ReportFavoritesModel> favorites, List<ReportFavoritesModel> favoritesTwo )
    {
        if( !CollectionUtils.isEmpty( nodes ) )
        {
            if( nodes.get( 0 ).getParent( ).getPortalReportsTreeId( ).equals( PortalReportsTreeModel.ROOT ) )
            {
                Collections.sort( nodes, new Comparator<PortalReportsTreeModel>( )
                {
                    @Override
                    public int compare( PortalReportsTreeModel o1, PortalReportsTreeModel o2 )
                    {
                        Integer o1Order = o1.getOrder( ) != null ? o1.getOrder( ) : -1;
                        Integer o2Order = o2.getOrder( ) != null ? o2.getOrder( ) : -1;

                        return Integer.compare( o1Order, o2Order );
                    }
                } );
            }
            else
            {
                Collections.sort( nodes, new Comparator<PortalReportsTreeModel>( )
                {
                    @Override
                    public int compare( PortalReportsTreeModel o1, PortalReportsTreeModel o2 )
                    {
                        return o1.getDescription( ).compareToIgnoreCase( o2.getDescription( ) );
                    }
                } );

                List<PortalReportsTreeModel> tempOrder = new ArrayList<>( nodes );
                List<PortalReportsTreeModel> nodesWithChildren = new ArrayList<>( );

                for( PortalReportsTreeModel node1 : nodes )
                {
                    if( PortalReportsTreeModel.HIDDEN.equals( node1.getHidden( ) ) || ( PortalReportsTreeModel.INACTIVE.equals( node1.getActive( ) ) ) )
                    {
                        tempOrder.remove( node1 );
                    }
                    else
                    {
                        List<PortalReportsTreeModel> tempChildren = new ArrayList<>( node1.getChildren( ) );

                        for( PortalReportsTreeModel node2 : node1.getChildren( ) )
                        {
                            if( PortalReportsTreeModel.HIDDEN.equals( node2.getHidden( ) ) || ( PortalReportsTreeModel.INACTIVE.equals( node2.getActive( ) ) ) )
                            {
                                tempChildren.remove( node2 );
                            }
                        }

                        node1.setChildren( tempChildren );

                        if( !CollectionUtils.isEmpty( node1.getChildren( ) ) )
                        {
                            nodesWithChildren.add( node1 );
                            tempOrder.remove( node1 );
                        }
                    }
                }
                nodesWithChildren.addAll( tempOrder );
                nodes.clear( );
                nodes.addAll( nodesWithChildren );
            }
        }

        List<PortalReportsTreeModel> temp = new ArrayList<>( nodes );
        List<ReportFavoritesModel> tempFavs = new ArrayList<>( favorites );

        for( PortalReportsTreeModel node : temp )
        {
            if( CollectionUtils.isEmpty( node.getChildren( ) ) )
            {
                if( node.getSecurityRole( ) != null )
                {
                    List<String> securityRoles = Arrays.asList( node.getSecurityRole( ).split( "," ) );

                    List<String> insersection = intersection( securityRoles, roles );

                    if( CollectionUtils.isEmpty( insersection ) )
                    {
                        if( !CollectionUtils.isEmpty( tempFavs ) )
                        {
                            for( ReportFavoritesModel favorite : tempFavs )
                            {
                                if( node.getPortalReportsTreeId( ).equals( favorite.getReportId( ).getPortalReportsTreeId( ) ) )
                                {
                                    favorites.remove( favorite );
                                    break;
                                }
                            }
                        }

                        nodes.remove( node );
                    }
                    else
                    {
                        if( !CollectionUtils.isEmpty( tempFavs ) )
                        {
                            for( ReportFavoritesModel favorite : tempFavs )
                            {
                                if( node.getPortalReportsTreeId( ).equals( favorite.getReportId( ).getPortalReportsTreeId( ) ) )
                                {
                                    node.getData( ).setFavorite( true );
                                    favoritesTwo.add( favorite );
                                    favorites.remove( favorite );
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            else
            {
                apply( node.getChildren( ), roles, favorites, favoritesTwo );
            }

            if( ( CollectionUtils.isEmpty( node.getChildren( ) ) && node.getSecurityRole( ) == null ) )
            {
                nodes.remove( node );
            }
        }
    }
*/
   
/*
    @RequestMapping(method = RequestMethod.GET, value = { "exportUserInfo" })
    @ResponseBody
    public ModelAndView downloadUserInfo( HttpServletRequest request, HttpServletResponse response, @CookieValue("SessionID") String sessionID )
    {
        // Sanitized input to allow only alphanumeric values without spaces
        String saneSessionID = sessionID.replaceAll( "[^A-Z0-9]+", "" );

        // Main Data Object
        Map<String, Object> data = new HashMap<>( );

        // User Data by Session
        try
        {
            com.dummy.controller.session.SessionManagementWebServiceLocator locator = new com.dummy.controller.session.SessionManagementWebServiceLocator( );
            SessionManagementWebServiceSoapPortType service = locator.getSessionManagementWebServiceSoap12( );
            String userData = service.getUserSessionDetails( saneSessionID );

            // Convert To XML
            JSONObject userJsonObj = XML.toJSONObject( userData );

            // Only Session Valid
            if( ( boolean )userJsonObj.getJSONObject( USER_SESSION_DETAIL ).get( "NoRecordFound" ))
            {
                return new ModelAndView( "reports/AccessDenied" );
            }

            // Fill User Information and User Session
            JSONObject userInfo = userJsonObj.getJSONObject( USER_SESSION_DETAIL ).getJSONObject( "userInfo" );
            JSONObject userSession = userJsonObj.getJSONObject( USER_SESSION_DETAIL ).getJSONObject( "userSession" );

            userInfo.put( "BrowserType", userSession.get( "BrowserType" ) );
            userInfo.put( "ClientIPAddress", userSession.get( "ClientIPAddress" ) );

            // Load to data <map>
            data.put( "userInfo", userInfo );
        }
        catch( Exception e )
        {
            logger.error( "Error: " + e.toString( ) );
        }
        // Session ID
        data.put( "sessionID", saneSessionID );

        // Environment
        String environment = EnvironmentManager.getEnv( ).toUpperCase( );
        data.put( "environment", environment );

        // Build Request URL
        String requestUrl = request.getScheme( ) + "://" + request.getServerName( ) + ":" + request.getServerPort( );
        data.put( "requestUrl", requestUrl );

        // User Roles
        @SuppressWarnings("unchecked")
        HashSet<String> roles = ( HashSet<String> )request.getSession( ).getAttribute( ROLES_WITHOUT_BF_KEY );
        List<String> rolesList = new ArrayList<>( roles );
        for (int i = 0; i < rolesList.size(); i++) {
        	rolesList.set(i, rolesList.get(i).replaceAll( "[^a-zA-Z0-9!@#$&()-`.+,/\"?~%{}|' ]*$", "" ));
		}
        Collections.sort( rolesList );
        data.put( ROLES_KEY, rolesList );

        // User Business Functions
        Function[] businessFunctions = ( Function[] )request.getSession( ).getAttribute( AclController.ACL_BUSINESS_FUNCTIONS_KEY );
        List<String> bf = new ArrayList<>( );
        if( businessFunctions != null )
        {
            for( Function function : businessFunctions )
            {
                bf.add( function.getName().replaceAll( "[^a-zA-Z0-9!@#$&()-`.+,/\"?~%{}|' ]*$", "" ) );
            }
        }
        Collections.sort( bf );
        data.put( "business", bf );

        logger.info( "exportUserInfoExcel" );

        return new ModelAndView( excelUserInfo, data );
    }*/
}
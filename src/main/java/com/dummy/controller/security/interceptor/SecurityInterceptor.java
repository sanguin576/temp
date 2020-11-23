package com.dummy.controller.security.interceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dummy.controller.security.SecurityController;
import com.dummy.model.security.PortalReportsTreeModel;
import com.dummy.services.security.PortalReportsTreeService;
import com.dummy.utlities.Constants;

public class SecurityInterceptor extends HandlerInterceptorAdapter
{
    private static final String DONT_HAVE_ACCESS_VIEW = "reports/AccessDenied";

    private static final Logger log = Logger.getLogger( SecurityInterceptor.class );

    @Autowired
    private PortalReportsTreeService service;

    @SuppressWarnings("unchecked")
    public static String getRolesStringDelimitedByComma( HttpServletRequest request )
    {
        String rolesString = null;
        ArrayList<String> coll = (ArrayList<String>) SecurityInterceptor.getRolesList( request );

        rolesString = StringUtils.collectionToCommaDelimitedString( coll );
        
        return rolesString;
    }

    public static List<String> getRolesList( HttpServletRequest request )
    {
        HashSet<String> roles = ( HashSet<String> )request.getSession( ).getAttribute( SecurityController.ROLES_KEY );

        if( roles == null )
        {
            roles = new HashSet<>( );
        }

        ArrayList<String> coll = new ArrayList<>( );

        for( String role : roles )
        {
            String roleUpper = role.toUpperCase( );

            if( roleUpper.contains( "dummyApp" ) || roleUpper.contains( "MEDICARE" ) || roleUpper.contains( "PORTAL" ) )
            {
                coll.add( role.replaceAll(Constants.ALPHA_NUMERIC_SPECIAL_CHAR, "") );
            }

        }

        return coll;
    }

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception
    {

        String viewName = null;

        String rolesString = SecurityInterceptor.getRolesStringDelimitedByComma( request );

        String url = request.getRequestURL( ).toString( );

        int start = url.lastIndexOf( '/' );
        url = url.substring( start + 1 );

        if( !"".equals( rolesString ) )
        {
            try
            {
                PortalReportsTreeModel node = null;

                // The solution not fixed. Pending...
                String reportName = request.getParameter( "id" );


                node = ( reportName == null ) ? service.findByUrl( url ) : service.findFirstByUrlAndDescription( url, reportName );

                List<String> securityRoles = Arrays.asList( node.getSecurityRole( ).split( "," ) );

                List<String> check = SecurityController.intersection( securityRoles, Arrays.asList( rolesString.split( "," ) ) );

                if( CollectionUtils.isEmpty( check ) || PortalReportsTreeModel.INACTIVE.equals( node.getActive( ) ) )
                {

                    viewName = DONT_HAVE_ACCESS_VIEW;
                }
            }
            catch( Exception e )
            {
                log.error( "Error", e );
                viewName = DONT_HAVE_ACCESS_VIEW;
            }
        }
        //incident # 8615029 else block for rolesString empty( the case of domains not in dummyApp, MEDICARE, PORTAL)
        else{
            viewName = DONT_HAVE_ACCESS_VIEW;
        }

        if( viewName != null )
        {
            ModelAndView mav = new ModelAndView( viewName );
            throw new ModelAndViewDefiningException( mav );
        }
        else
        {

            log.debug( "preHandle" );
            return super.preHandle( request, response, handler );
        }

    }

    @Override
    public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) throws Exception
    {
        log.debug( "postHandle" );
        super.postHandle( request, response, handler, modelAndView );
    }

    @Override
    public void afterCompletion( HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex ) throws Exception
    {
        log.debug( "afterCompletion" );
        super.afterCompletion( request, response, handler, ex );
    }

}

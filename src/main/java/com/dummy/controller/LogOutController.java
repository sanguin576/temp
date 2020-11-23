package com.dummy.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("rest/logout")
public class LogOutController {

	private static final Logger LOGGER = Logger.getLogger( LogOutController.class );

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> logOut(HttpServletRequest request)
    {
    	LOGGER.info("Logout");
    	request.getSession().invalidate();
    	LOGGER.info("Cleared Session");
    	return new ResponseEntity<>( HttpStatus.OK );
    }

}

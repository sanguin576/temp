package com.dummy.controller.session;

import static org.junit.Assert.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import com.dummy.configuration.AppConfigApplicationContext;
import com.dummy.configuration.WebMvcConfig;
import com.dummy.exception.dummyBusinessException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppConfigApplicationContext.class, WebMvcConfig.class })
public class SessionControllerTest {

	@Autowired
	 private WebApplicationContext wac;
	 
	@Mock
	private MockHttpServletRequest request;
	
	 private MockMvc mockMvc;
	 
	 private MockHttpSession mockHttpSession;

	 @Before
		public void setUp() throws Exception {
			this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
			MockServletContext sc = new MockServletContext("");
	        ServletContextListener listener = new ContextLoaderListener(wac);
	        ServletContextEvent event = new ServletContextEvent(sc);
	        listener.contextInitialized(event);
		}
	 
	@Test
	public void testnoIdsession() throws Exception {
		mockHttpSession = new MockHttpSession(wac.getServletContext());
		this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/session/").session(mockHttpSession).cookie(new Cookie("SessionID","123")))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testsessionById() throws Exception {
		mockHttpSession = new MockHttpSession(wac.getServletContext());
		this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/session/123").session(mockHttpSession).cookie(new Cookie("SessionID","123")))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testbusinessFunction() throws Exception {
		mockHttpSession = new MockHttpSession(wac.getServletContext());
		this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/session/123/BIM0550").session(mockHttpSession).cookie(new Cookie("SessionID","123")))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testgetUserDetailsFromSessionID() throws dummyBusinessException{
		SessionController sessionController = new SessionController();
		//assertNotNull(sessionController.getUserDetailsFromSessionID("123"));
	}

}

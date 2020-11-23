package com.dummy.controller.security;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.ResourceBundle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import com.dummy.configuration.AppConfig;
import com.dummy.configuration.AppConfigApplicationContext;
import com.dummy.configuration.EnvironmentManager;
import com.dummy.configuration.WebMvcConfig;
import com.dummy.controller.acl.AccessIdentifier;
import com.dummy.controller.acl.AclController;
import com.dummy.controller.acl.CodeDescriptionType;
import com.dummy.controller.acl.Function;
import com.dummy.controller.pde.RxPDEController;
import com.dummy.controller.pde.RxPDEThread;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppConfigApplicationContext.class, WebMvcConfig.class })
public class SecurityControllerTest {

	@Autowired
	 private WebApplicationContext wac;
	
	@Mock
	private MockHttpServletRequest request;
	
	 private MockMvc mockMvc;
	 
	 private MockHttpSession mockHttpSession;
	 
	 private RxPDEController rxPDEController;
	
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		MockServletContext sc = new MockServletContext("");
        ServletContextListener listener = new ContextLoaderListener(wac);
        ServletContextEvent event = new ServletContextEvent(sc);
        listener.contextInitialized(event);
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testuserInfo() throws Exception {
		mockHttpSession = new MockHttpSession(wac.getServletContext());
		HashSet<String> roles = new HashSet<>();
		roles.add("role1");
		roles.add("role2");
		roles.add("role3");
		roles.add("role4");
		
		CodeDescriptionType codeDescriptionType = new CodeDescriptionType();
		codeDescriptionType.setCode("123");
		codeDescriptionType.setDescription("N/A");
		
		AccessIdentifier accessIdentifier = new AccessIdentifier();
		accessIdentifier.setAccessId("abc");
		accessIdentifier.setAccessIdType(codeDescriptionType);
		accessIdentifier.setClassCode("324");
		accessIdentifier.setComment("comment");
		accessIdentifier.setCreatedByAkaName("bm554");
		accessIdentifier.setEntityGenKey(123);
		accessIdentifier.setGenKey(123);
		accessIdentifier.setLongDescription("description");
		accessIdentifier.setParent(1);
		accessIdentifier.setShortDescription("describe");
		accessIdentifier.setSource("source");
		accessIdentifier.setSourceTypeCode("sourcecode");
		
		AccessIdentifier accessIdentifier1 = new AccessIdentifier();
		accessIdentifier1.setAccessId("abc");
		accessIdentifier1.setAccessIdType(codeDescriptionType);
		accessIdentifier1.setClassCode("324");
		accessIdentifier1.setComment("comment");
		accessIdentifier1.setCreatedByAkaName("bm554");
		accessIdentifier1.setEntityGenKey(123);
		accessIdentifier1.setGenKey(123);
		accessIdentifier1.setLongDescription("description");
		accessIdentifier1.setParent(1);
		accessIdentifier1.setShortDescription("describe");
		accessIdentifier1.setSource("source");
		accessIdentifier1.setSourceTypeCode("sourcecode");
		
		AccessIdentifier[] accessID = {accessIdentifier,accessIdentifier1};
		
		Function function = new Function();
		function.setAccessIds(accessID);
		function.setDefaultNavigationName("defaultNavigationName");
		function.setDelegationTypeCd("delegationTypeCd");
		function.setDescription("description");
		function.setGenKey(123);
		function.setInitialURL("initialURL");
		function.setName("name");
		function.setOriginGenKey(123);
		function.setSegment(true);
		function.setSystemApplicationId(123);
		
		Function function1 = new Function();
		function1.setAccessIds(accessID);
		function1.setDefaultNavigationName("defaultNavigationName");
		function1.setDelegationTypeCd("delegationTypeCd");
		function1.setDescription("description");
		function1.setGenKey(123);
		function1.setInitialURL("initialURL");
		function1.setName("name");
		function1.setOriginGenKey(123);
		function1.setSegment(true);
		function1.setSystemApplicationId(123);
		
		Function[] functionlist = {function,function1};
	    mockHttpSession.setAttribute(SecurityController.ROLES_WITHOUT_BF_KEY, roles);
	    mockHttpSession.setAttribute(AclController.ACL_BUSINESS_FUNCTIONS_KEY, functionlist);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/security/userInfo").session(mockHttpSession))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testTree() throws Exception{
		mockHttpSession = new MockHttpSession(wac.getServletContext());
		this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/security/tree/SRB9018"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testcookieAuthorization() throws Exception{
		mockHttpSession = new MockHttpSession(wac.getServletContext());
		this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/security/authorization").cookie(new Cookie("SessionID","123")))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testdownloadUserInfo() throws Exception{
		this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/security/exportUserInfo").cookie(new Cookie("SessionID","123")))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}

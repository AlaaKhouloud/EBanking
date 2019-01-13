package com.back;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.back.dao.UserRepository;
import com.back.entities.Compte;
import com.back.entities.User;
import com.back.entities.Virement;
import com.back.service.UserRestService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles( profiles={"test"})
public class UserTestRest {

	private MockMvc mockMvc;
	
	@Mock
	public UserRepository userrepo;
	
	@InjectMocks
	private UserRestService userservice;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(userservice).build();
	}
	
	@Test
	public void testgetVirement() throws Exception {
		User user = userrepo.save(new User("hello@gmail.com", "hellotest")); 
		MvcResult mvcResult=null;
		MultiValueMap<String, String> parametres=new LinkedMultiValueMap<String, String>();
		parametres.add("email","hello@gmail.com");
		RequestBuilder builder =  MockMvcRequestBuilders.post("/me").params(parametres);
	     try {
				  mvcResult= this.mockMvc.perform(builder).andReturn();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 int status = mvcResult.getResponse().getStatus();
	     Assert.assertEquals(200, status);
	}
	
}

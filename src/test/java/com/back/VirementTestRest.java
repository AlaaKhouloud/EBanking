package com.back;

 
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.*;

import com.back.dao.CompteRepository;
import com.back.dao.RechargeRepository;
import com.back.dao.VirementRepository;
import com.back.entities.*;
import com.back.metier.*;
import com.back.service.*;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles( profiles={"test"})

public class VirementTestRest {

		private MockMvc mockMvc;
		@Mock
		public CompteRepository compteRepository; 
		@Mock
		private VirementRepository virementRepository;
		@InjectMocks
		private VirementRestService virementRestService;
		@Before
		public void setUp(){
			mockMvc = MockMvcBuilders.standaloneSetup(virementRestService).build();
		}
		
		
		@Test
		public void testgetVirement() throws Exception {
			Compte c = compteRepository.save(new Compte(new User("test@gmail.com", "test") , "KKK" , 4500.0));
			virementRepository.save(new Virement(c , "JJJJJ" , 500.3));
			MvcResult mvcResult=null;
			MultiValueMap<String, String> parametres=new LinkedMultiValueMap<String, String>();
			parametres.add("email","test@gmail.com");
			RequestBuilder builder =  MockMvcRequestBuilders.post("/Virements").params(parametres);
		     try {
					  mvcResult= this.mockMvc.perform(builder).andReturn();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 int status = mvcResult.getResponse().getStatus();
		     Assert.assertEquals(200, status);
		}
		
		@Test
		public void testaddVirement() {
		List<Compte> comptes=new ArrayList<Compte>();
		Compte comptemanage=Mockito.mock(Compte.class);
		//Mockito.when(comptemanage.getUser_cpt().getEmail()).thenReturn("fouzialaajili@gmail.com");
		    Mockito.when(comptemanage.getMoney()).thenReturn(20000.00);
			User user_cpt=new User();
			User user_cpt1=new User();
			user_cpt.setRole(Role_values.ROLE_CLIENT);
			user_cpt.setEmail("fouzialaajili@gmail.com");
			Compte compte=new Compte(user_cpt,"44444444",20000.00);
			compte.setMoney_for_transactions(0.00);
			compte.setMoney(220.00);
			comptes.add(compte);
			user_cpt1.setRole(Role_values.ROLE_CLIENT);
			user_cpt1.setEmail("laajilimeriem3@gmail.com");
			Compte compte2=new Compte(user_cpt1,"55555555",00.00);
			compte.setMoney_for_transactions(0.00);
			compte.setMoney(220.00);
			comptes.add(compte2);
		    Virement virement=new Virement();
		    virement.setId_virement(1L);
		    
		
		
	       Mockito.when(compteRepository.findAll()).thenReturn(comptes);
	       Mockito.when(virementRepository.save((Virement)org.mockito.Matchers.any(Virement.class))).thenReturn(virement);
	 
	   
	       Mockito.when(compteRepository.saveAndFlush((Compte)org.mockito.Matchers.any(Compte.class))).thenReturn(compte);
		   
			MultiValueMap<String, String> parametres=new LinkedMultiValueMap<String, String>();
			parametres.add("email","fouzialaajili@gmail.com");
			parametres.add("from","44444444");
			parametres.add("to","55555555");
			parametres.add("montant","20");
				MvcResult mvcResult=null;
			RequestBuilder builder =
	          MockMvcRequestBuilders.put("/addVirement").params(parametres);


	                                
			  try {
				  mvcResult= this.mockMvc.perform(builder)
				  .andReturn();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  int status = mvcResult.getResponse().getStatus();
			   Assert.assertEquals(200, status);
	          
		}
	}

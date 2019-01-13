package com.back;

import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.back.dao.*;
import com.back.entities.*;
import com.back.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles( profiles={"test"})
public class TestRestApis {

	
	private MockMvc mockMvc;
	@Mock
	public CompteRepository compteRepository;
	@Mock
	private RechargeRepository rechRepository;
	@InjectMocks
	private RechargeRestService rechargeRestService;
       
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(rechargeRestService).build();
	}
	
	@Test
	public void testgetRecharges() throws Exception {
		Compte c = compteRepository.save(new Compte(new User("test@gmail.com", "test") , "KKK" , 4500.0));
		rechRepository.save(new Recharge(c, "0653214581", new Date(), Montant_rehcarge.S20DH));
		MvcResult mvcResult=null;
		MultiValueMap<String, String> parametres=new LinkedMultiValueMap<String, String>();
		parametres.add("email","test@gmail.com");
		RequestBuilder builder =  MockMvcRequestBuilders.post("/Recharges").params(parametres);
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
	public void testaddRecharge() {
		List<Compte> comptes=new ArrayList<Compte>();
		Compte comptemanage=Mockito.mock(Compte.class);
		//Mockito.when(comptemanage.getUser_cpt().getEmail()).thenReturn("fouzialaajili@gmail.com");
		Mockito.when(comptemanage.getMoney()).thenReturn(20000.00);
		User user_cpt=new User();
		user_cpt.setRole(Role_values.ROLE_CLIENT);
		user_cpt.setEmail("bhbh@gmail.com");
		Compte compte=new Compte(user_cpt,"EEE",20000.00);
		compte.setMoney_for_transactions(0.00);
		compte.setMoney(220.00);
		comptes.add(compte);
		
		 Recharge recharge=new Recharge();
		 recharge.setId_recharge(1L);
	
	
       Mockito.when(compteRepository.findAll()).thenReturn(comptes);
       Mockito.when(rechRepository.save((Recharge)org.mockito.Matchers.any(Recharge.class))).thenReturn(recharge);
 
   
       Mockito.when(compteRepository.saveAndFlush((Compte)org.mockito.Matchers.any(Compte.class))).thenReturn(compte);
	   
       	String uri = "/addRecharge";
		MultiValueMap<String, String> parametres=new LinkedMultiValueMap<String, String>();
		parametres.add("email","bhbh@gmail.com");
		parametres.add("from","EEE");
		parametres.add("to","0661628384");
		parametres.add("montant","20");
			MvcResult mvcResult=null;
		RequestBuilder builder =
          MockMvcRequestBuilders.put("/addRecharge").params(parametres);
                              
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
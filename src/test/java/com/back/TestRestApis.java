package com.back;

import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.awt.PageAttributes.MediaType;

import org.junit.*;
import org.mockito.InjectMocks; 
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.back.service.UserRestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles( profiles={"test"})
public class TestRestApis {

	private MockMvc mockMvc;
	
	@InjectMocks
	private UserRestService usercontroller;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(usercontroller).build();
	}
	
	@Test
	public void name() {
		/*mockMvc.perform(
				MockMvcRequestBuilders.post("/me")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.*" , org.hamcrest.Matchers.hasSize(1))
				);
				/*.andExpect(jsonPath("$.nom", Matchers.isNotNull()))
				.andExpect(jsonPath("$.rib", Matchers.contains("RIBAAA")));*/
	}

}
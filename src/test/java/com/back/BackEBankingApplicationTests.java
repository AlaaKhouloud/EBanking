package com.back;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

 
import com.back.dao.UserRepository;
import com.back.entities.Adresse; 
import com.back.entities.Role_values;
import com.back.entities.Telephone;
import com.back.entities.User;
import com.back.service.UserRestService;

@RunWith(SpringRunner.class)
public class BackEBankingApplicationTests {

	 @TestConfiguration
	    static class UserServiceImplTestContextConfiguration {
	  
	        @Bean
	        public UserRestService employeeService() {
	            return new UserRestService();
	        }
	    }
	 
	 @Autowired
	 private UserRestService service;
	 
	 @MockBean
	 private UserRepository userRepository;
	
	 
	 @org.junit.Before
	 public void setUp() {  
	     User user1 = new User("XXX", "XX@gmail.com",false,Role_values.ROLE_CLIENT);
	  
	     Mockito.when(userRepository.findByUsername(user1.getEmail())).thenReturn(user1);
	 }
	 
	 @Test
	 public void whenValidName_thenUserShouldBeFound() {
	     String name = "khouloud";
	     User found = null;
	     //userRepository.findByName(name); 
	     assertEquals(found.getNom() , name); 
	  }
	 
}

package com.back2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.back.dao.UserRepository;
import com.back.entities.Adresse;
import com.back.entities.Role_values;
import com.back.entities.Telephone;
import com.back.entities.User;
import com.back.metier.UserMetier;
import com.back.metier.UserMetierImpl;

import io.jsonwebtoken.lang.Assert;


@RunWith(SpringRunner.class)

public class JavaFXTest {
	/*
	 @MockBean
	 private UserRepository userRepository;
*/
	 UserRepository ur;
	
	 @org.junit.Before
	 public void setUp() {  
		User u = new User("khaoula@gmail.com", "1234", "SENANE");
		ur = mock(UserRepository.class);
		 when(ur.findByName(u.getNom())).thenReturn(u);
	   
	 }
	 
	 @Test
	 public void testfindById(){
		 String name = "SENANE";
		 User u2 = ur.findByName(name);
		assertEquals(u2.getNom(), name);
		 
	 }
	
	 @Test
	 public void testauthentify(){
		User utest = new User(null, "khaoula@gmail.com", "1234", null,  null,  null,  null,
				false,  null, null, null,
				null, null);
		 
		 String email = "khaoula@gmail.com";
		 String pass = "1234";
		 User u2 = ur.authentify(utest.getEmail(), utest.getPassword());
		assertEquals(u2,utest);
		 
	 }
	
}

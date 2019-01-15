package com.back2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.back.dao.AgenceRepository;
import com.back.dao.CompteRepository;
import com.back.dao.UserRepository;
import com.back.entities.Adresse;
import com.back.entities.Agence;
import com.back.entities.Compte;
import com.back.entities.Role_values;
import com.back.entities.Telephone;
import com.back.entities.User;
import com.back.entities.Virement;
import com.back.metier.AgenceMetierImpl;
import com.back.metier.UserMetier;
import com.back.metier.UserMetierImpl;

import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;

 

@RunWith(SpringRunner.class)
@ActiveProfiles( profiles={"test"})
public class JavaFXTest {
	
	@InjectMocks
	private UserMetierImpl um ;
	
	@InjectMocks
	private AgenceMetierImpl am ;
	
	@Mock
	 private UserMetier uminter;
	
	 @Mock
	 private UserRepository ur;
	 
	 @Mock
	 private AgenceRepository ar;
	 
	
	 
	 
	 @Mock
	 private User user;

	 @Mock
	 private Agence agences;

	// UserRepository ur;
	
	 @org.junit.Before
	 public void setUp() {  
		
		 
		User u = new User("khaoula@gmail.com", "1234", "SENANE");
		ur = mock(UserRepository.class);
		 when(ur.findByName(u.getNom())).thenReturn(u);
	   
	 }
	 
	 @Before
	 public void init(){
		MockitoAnnotations.initMocks(this);
     	um = new UserMetierImpl();
        um.setUserRepository(ur);
        
      
	 }
	 
	 @Test
	 public void testfindByName(){
		 User u = new User("khaoula@gmail.com", "1234", "SENANE");
		 when(ur.findByName(u.getNom())).thenReturn(u);
		
		 String name = "SENANE";
		 User u2 = ur.findByName(name);
		assertEquals(u2.getNom(), name);
	
	 }
	
	 @Test
	 public void testauthentify(){
		 User u = new User( 1, "khaoula@gmail.com", "1234");
		 when(ur.getOne((long) 1)).thenReturn(u);
		 
		 User userTest = um.getUser((long) 1);
		 
		 assertEquals("khaoula@gmail.com", userTest.getEmail());
		 assertEquals("1234", userTest.getPassword());
		 
	/*	User utest = new User(null, "khaoula@gmail.com", "1234", null,  null,  null,  null,
				false,  null, null, null,
				null, null);
		 
		 String email = "khaoula@gmail.com";
		 String pass = "1234";
		 User u2 = ur.authentify(utest.getEmail(), utest.getPassword());
		assertEquals(u2,utest);
	*/ 
	 }
	 
	 @Test
	 public void testaddUser()throws Exception{
		/*  user = new User("khaoulasenane@gmail.com", "12345", "SENANE");
		 // user = new User();
		  
		 when(ur.addUser(user)).thenReturn(user);
		 
		 User savedUser = ur.addUser(user);
		 System.out.println("*************************" + user.getNom());
		 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$" + savedUser.getNom());
		 assertThat(savedUser, is(equalTo(user)));
	 
		/* 
		 User u = new User("khaoulasenane@gmail.com", "passd", "senane", "khaoula");
		
 
		 um.addUser(u);
		 
		 verify(ur, times(1)).addUser(u);
		 */
	 }
	 
	@Test
	 public void testdeleteUser()throws Exception{
		 
		/*doNothing().when(ur).deleteUser((long) 23);
		//UserRepository my = Mockito.mock(UserRepository.class);
		ur.deleteUser((long) 23);
		
		verify(ur, times(1)).deleteUser((long) 23);*/
		 
	 }
	
	 @Test
	 public void testListUser()throws Exception{
		 
		 List<User> users = ur.findAll();
		 assertThat(users.size(), is(greaterThanOrEqualTo(0)));
		 
	 }
	 
	 @Test
	 public void testmodifUser()throws Exception{
		  user = new User("khaoulasenane@gmail.com", "12345", "SENANEEEEEEEE");
		 // user = new User();
		  
		/* when(ur.modifUser(user)).thenReturn(user);
		 
		 User modifiedUser = ur.modifUser(user);
		 System.out.println("*************************" + user.getNom());
		
		 assertThat(modifiedUser, is(equalTo(user)));*/
	 
	 }
	 
	 
	 // Tests Agances
	 
	 @Test
	 public void testgetAgence()throws Exception{
		 agences = new Agence((long) 1,"Agence1", "Maroc", "Safi");
		
		//when(ar.getOne(agences.getId_agence())).thenReturn(agences);
		 
		 when(ar.findByName(agences.getNom())).thenReturn(agences);

		 String name = "Agence1";
		 
		 Agence ag = ar.findByName(name);
 
		 assertEquals(ag.getNom(), name);
 
	
	 }
	 
	 
	 @Test
	 public void testListAgence()throws Exception{
		 
		 List<Agence> agences = ar.findAll();
		 assertThat(agences.size(), is(greaterThanOrEqualTo(0)));
		 
	 }
	 
	 @Test
	 public void testcreerAgence()throws Exception{
		  agences = new Agence((long) 1,"Agence", "Maroc", "Safi");
		
		/* when(ar.creerAgence(agences)).thenReturn(agences);
		 
		 Agence savedAgence = ar.creerAgence(agences);
		 
		 assertThat(savedAgence, is(equalTo(agences)));*/
			
	 }
	 
	 @Test
	 public void testfindAllAgence()throws Exception{
		 
		 List<Agence> agences = ar.findAllAgence("BMCE Banque");
		 assertThat(agences.size(), is(greaterThanOrEqualTo(0)));
		 
	 }
	 
	 @Test
	 public void testgetidcompte()throws Exception{
		 User user_cpt = new User(1, "khaoula@gmail.com", "5787");
		 Compte cmp = new Compte(user_cpt, "72836327", (double) 30000);
		 when(ur.getidcomte(cmp.getUser_cpt().getId_user())).thenReturn(cmp);
		 System.out.println("*****************************************" + ur.getidcomte(cmp.getUser_cpt().getId_user()));
		 
		 int id = 1;
		 String rib = "72836327";
		 Compte cmpte = ur.getidcomte((long) id);
		assertEquals(cmpte.getRIB(),rib);
		 
	
	 }
	 
	 
	@Test 
	public void testgetMontant()throws Exception{
		User user_cpt = new User(1, "khaoula@gmail.com", "5787");
		Compte cpt = new Compte( user_cpt, "627627672372", (double) 20000);
		
		Virement vr = new Virement(cpt, "123456", (double) 500);
		
		when(ur.getMontant(cpt.getId_compte())).thenReturn(vr);
		
		double mnt = 19500;
		int id = 1;
		Virement vr2 = ur.getMontant((long)id);
	//double mnt1=(double)cpt.getMoney() - (double) vr2.getMontant();
		assertEquals(vr2.getFrom_RIB().getMoney(),cpt.getMoney());
		
	}
}

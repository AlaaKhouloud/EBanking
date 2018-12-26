package com.back.service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.back.dao.UserRepository;
import com.back.domain.Response;
import com.back.entities.User;
import com.back.util.PasswordUtil;
 
@RestController
public class UserRestService {

	@Autowired
	private UserRepository userRepository;
	 
	@PostMapping(value="/registration")
	public ResponseEntity<Response> registration(@RequestBody User user){
		String password = PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
		user.setDate_adhesion(new Date());
		User dbuser = userRepository.save(user);
		if(dbuser !=null)  return new ResponseEntity<Response>(new Response("User is savec successfully") , HttpStatus.OK);
		else return null; 
	}
	
	@GetMapping(value="/users")
	@PreAuthorize("hasRole('AGENT') or hasRole('ADMIN')")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userRepository.findAll();
	    return new ResponseEntity<List<User>>(users , HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getuser")
	@PreAuthorize("hasRole('AGENT') or hasRole('ADMIN')")
	public ResponseEntity<User> getUser(Principal principal){
		User user = userRepository.findByEmailIgnoreCase(principal.getName());
		return new ResponseEntity<User>(user , HttpStatus.OK);
	}
	

	/////////////////////////////////////////
	
	public User getUserByName(String name) {
        return userRepository.findByName(name);
    }
	
	 
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER')") //or hasRole('ADMIN')
	public String userAccess() {
		return ">>> User contents !";
	}
	
	@GetMapping("/api/test/agent or hasRole('ADMIN')")
	@PreAuthorize("hasRole('AGENT') or hasRole('ADMIN')")
	public String agentAccess() {
		return ">>> Agent contents !";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin contents !";
	}
	
}

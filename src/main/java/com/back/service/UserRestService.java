package com.back.service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.back.dao.UserRepository; 
import com.back.entities.User;  
 
@RestController
public class UserRestService {

	@Autowired
	private UserRepository userRepository;
	 
	 
	@GetMapping(value="/users")
	@PreAuthorize("hasRole('AGENT') or hasRole('ADMIN')")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userRepository.findAll();
	    return new ResponseEntity<List<User>>(users , HttpStatus.OK);
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

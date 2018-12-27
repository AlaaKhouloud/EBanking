package com.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.UserRepository;
import com.back.entities.User;
import com.back.metier.UserMetier;

@RestController
public class UserRestService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserByName(String name) {
        return userRepository.findByName(name);
    }
	
	@Autowired
	private UserMetier userMetier;

	
	@RequestMapping(value="/users/{id}" , method=RequestMethod.GET)
	public User getUser(@RequestBody Long id) {
		return userMetier.getUser(id);
	}

	@RequestMapping(value="/users" , method=RequestMethod.POST)
	public User addUser(@RequestBody User u) {
		return userMetier.addUser(u);
	}

	@RequestMapping(value="/users/{id}" , method=RequestMethod.DELETE)
	public void deleteUser(@RequestBody Long id) {
		userMetier.deleteUser(id);
	}

	@RequestMapping(value="/users" , method=RequestMethod.GET)
	public List<User> listUsert() {
		return userMetier.listUser();
	}
	
	
}

package com.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.UserRepository;
import com.back.entities.User;

@RestController
public class UserRestService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserByName(String name) {
        return userRepository.findByName(name);
    }
}

package com.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.RoleRepository;

@RestController
public class RoleRestService {

	@Autowired
	private RoleRepository roleRepository;
	
	 
}

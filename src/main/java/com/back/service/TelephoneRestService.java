package com.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.TelephoneRepository;

@RestController
public class TelephoneRestService {

	@Autowired
	private  TelephoneRepository telRepository;
}

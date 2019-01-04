package com.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.AdresseRepository;

@RestController
public class AdresseRestService {

	@Autowired
	private AdresseRepository adrsRepository;
}

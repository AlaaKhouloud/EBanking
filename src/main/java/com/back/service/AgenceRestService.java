package com.back.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.AgenceRepository;
import com.back.entities.Agence;
import com.back.metier.AgenceMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.AgenceRepository;


@RestController
public class AgenceRestService {

	@Autowired
	private AgenceRepository agenceRepository;

	
	public Agence getAgence(String name){
		return agenceRepository.findByName(name);
	}
	
	public Optional<Agence> getAgenceById(Long id){
		return agenceRepository.findById(id);
	}
	
	@Autowired
	private AgenceMetier agenceMetier;
    
	@RequestMapping(value="/agences",method=RequestMethod.POST)
	public Agence creerAgence(@RequestBody Agence a) {
		return agenceMetier.creerAgence(a);
	}
	
    @RequestMapping(value="/agences",method=RequestMethod.GET)
	public List<Agence> listAgence() {
		return agenceMetier.listAgence();
	}
	
	

}

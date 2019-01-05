package com.back.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.back.dao.CompteRepository;
import com.back.entities.*;

@RestController
public class CompteRestService {

	@Autowired
	private CompteRepository compteRepository;
	
	@PostMapping(value="/Comptes")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<List<Compte>> getAllCpts(@RequestParam("email")String pseudo){
		List<Compte> compteOUT = new ArrayList<Compte>();
		List<Compte> compteIN = compteRepository.findAll();
		for(Compte c : compteIN) {
			if(c.getUser_cpt().getEmail().equals(pseudo)) {
				compteOUT.add(c);
			}
		}
	    return new ResponseEntity<List<Compte>>(compteOUT , HttpStatus.OK);
	}
	
	
}

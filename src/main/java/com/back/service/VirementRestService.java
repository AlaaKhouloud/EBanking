package com.back.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.CompteRepository;
import com.back.dao.VirementRepository;
import com.back.entities.*;

@RestController
public class VirementRestService {

	@Autowired
	private VirementRepository virRepository;
	@Autowired
	private CompteRepository compteRepository;
	
	@PostMapping(value="/Virements")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<List<Virement>> getAllVirements(@RequestParam("email")String pseudo){ 
		List<Compte> compteIN = compteRepository.findAll();
		List<Virement> virementOUT = new ArrayList<Virement>();
		List<Virement> virementIN = virRepository.findAll();
		for(Compte c : compteIN) {	
			for(Virement v : virementIN) {
				if(v.getFrom_RIB().getRIB().equals(c.getRIB()) && v.getFrom_RIB().getUser_cpt().getEmail().equals(pseudo)) {
					virementOUT.add(v);
				}
			}
		}
		
		
	    return new ResponseEntity<List<Virement>>(virementOUT , HttpStatus.OK);
	}
	
	
	@PutMapping(value="/addVirement")
	//@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<Virement> addVirement(@RequestParam("email")String pseudo , @RequestParam("from")String ribfrom, @RequestParam("to")String ribto , @RequestParam("montant")String montant){ 
		List<Compte> compteIN = compteRepository.findAll(); 
		Virement virement = null;
		Compte lecompte = null;
		Compte lecompteTo = null;
		for(Compte c : compteIN) {
			if(c.getUser_cpt().getEmail().equals(pseudo) && c.getRIB().equals(ribfrom)) {
				lecompte = c;
			}
			else if(c.getRIB().equals(ribto)) {
				lecompteTo = c;
			}
		}
		if(lecompte != null) {
			if(lecompte.getMoney()>Double.valueOf(montant)) {
				virement = virRepository.save(new Virement(lecompte ,ribto , new Date() , Double.valueOf(montant) , Etat_virement.IN_VERIFICATION_PROCESS));
				lecompte.setMoney(lecompte.getMoney() - Double.valueOf(montant));
				lecompte.setMoney_for_transactions(lecompte.getMoney_for_transactions() + Double.valueOf(montant));
			    compteRepository.saveAndFlush(lecompte); 
			}
		}
		
        if(virement !=null) {
        	if(lecompteTo!=null) {
        		lecompteTo.setMoney(lecompteTo.getMoney() + Double.valueOf(montant));
        		compteRepository.saveAndFlush(lecompteTo); 
        	}
	        return new ResponseEntity<Virement>(virement , HttpStatus.OK);
	    }
        else return new ResponseEntity<Virement>(virement , HttpStatus.NO_CONTENT);
	}
}

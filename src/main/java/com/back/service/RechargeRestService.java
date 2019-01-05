package com.back.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.*;
import com.back.entities.*;

@RestController
public class RechargeRestService {

	@Autowired
	private RechargeRepository rechRepository;
	@Autowired
	private CompteRepository compteRepository;
	
	@PostMapping(value="/Recharges")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<List<Recharge>> getAllVirements(@RequestParam("email")String pseudo){ 
		List<Compte> compteIN = compteRepository.findAll();
		List<Recharge> rechargeOUT = new ArrayList<Recharge>();
		List<Recharge> rechargeIN = rechRepository.findAll();
		for(Compte c : compteIN) {	
			for(Recharge r : rechargeIN) {
				if(r.getSender().getRIB().equals(c.getRIB()) && r.getSender().getUser_cpt().getEmail().equals(pseudo)) {
					rechargeOUT.add(r);
				}
			}
		}
		
		
	    return new ResponseEntity<List<Recharge>>(rechargeOUT , HttpStatus.OK);
	}
	
	@PutMapping(value="/addRecharge")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ResponseEntity<Recharge> addVirement(@RequestParam("email")String pseudo , @RequestParam("from")String ribfrom, @RequestParam("to")String tel , @RequestParam("montant")String montant){ 
		List<Compte> compteIN = compteRepository.findAll(); 
		Recharge recharge = null;
		Compte lecompte = null;
		for(Compte c : compteIN) {
			if(c.getUser_cpt().getEmail().equals(pseudo)  && c.getRIB().equals(ribfrom)) {
				lecompte = c;
			}
		}
		if(lecompte != null) {
			if(lecompte.getMoney()>Double.valueOf(montant)) {
				if(montant.equals("20"))recharge = rechRepository.save(new Recharge(lecompte ,tel , new Date() , Montant_rehcarge.S20DH));
				
				else if(montant.equals("50"))recharge = rechRepository.save(new Recharge(lecompte ,tel , new Date() , Montant_rehcarge.S50DH ));
				
				else if(montant.equals("100"))recharge = rechRepository.save(new Recharge(lecompte ,tel , new Date() , Montant_rehcarge.S100DH));
				
				else if(montant.equals("150"))recharge = rechRepository.save(new Recharge(lecompte ,tel , new Date() , Montant_rehcarge.S150DH));
				
				lecompte.setMoney(lecompte.getMoney() - Double.valueOf(montant));
				lecompte.setMoney_for_transactions(lecompte.getMoney_for_transactions() + Double.valueOf(montant));
			    compteRepository.saveAndFlush(lecompte);
			}
		}
		
        if(recharge !=null)
	    return new ResponseEntity<Recharge>(recharge , HttpStatus.OK);
        else return new ResponseEntity<Recharge>(recharge , HttpStatus.NO_CONTENT);
	}
}

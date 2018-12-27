package com.back.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.dao.CompteRepository;
import com.back.entities.Compte;

@Service
public class CompteMetierImpl implements CompteMetier {

	@Autowired
	private CompteRepository compteRepository; 
	
	
	@Override
	public Compte getCompte(Long id) {
		// TODO Auto-generated method stub
		return compteRepository.getOne(id);
	}

	@Override
	public List<Compte> listCompt() {
		// TODO Auto-generated method stub
		return compteRepository.findAll();
	}

	@Override
	public Compte creerCompte(Compte c) {
		// TODO Auto-generated method stub
		return compteRepository.saveAndFlush(c);
	}

	@Override
	public void SupprimerCompte(Long id) {
		// TODO Auto-generated method stub
		compteRepository.deleteById(id);
	}

}

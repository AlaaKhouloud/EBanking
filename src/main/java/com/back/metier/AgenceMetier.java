package com.back.metier;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.back.entities.Agence;

public interface AgenceMetier {

	public Agence getAgence(Long id);
	public Agence creerAgence(Agence a);
	public List<Agence> listAgence();
	public Agence findByName(String name);
	public List<Agence> findAllAgence(String banque);
	
}

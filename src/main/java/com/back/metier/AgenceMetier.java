package com.back.metier;

import java.util.List;

import com.back.entities.Agence;

public interface AgenceMetier {

	public Agence getAgence(Long id);
	public Agence creerAgence(Agence a);
	public List<Agence> listAgence();
	
}

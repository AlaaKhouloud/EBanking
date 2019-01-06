package com.back.metier;

import java.util.List;

import com.back.entities.Compte;

public interface CompteMetier {
	
	public Compte getCompte(Long id);
	public List<Compte> listCompt();
    public Compte creerCompte(Compte c);
    public void SupprimerCompte(Long id);
    
}

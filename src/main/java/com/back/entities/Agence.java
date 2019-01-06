package com.back.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Agence implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_agence;
	private String nom;
	private String banque;
	private String pays;
	private String ville;
	private String adresse;
	private Date date_creation;
	private Compte creator;
	
	
	public Agence(String nom, String pays, String ville, String adresse, Date date_creation,
			Compte creator) {
		super(); 
		this.nom = nom;
		this.pays = pays;
		this.ville = ville;
		this.adresse = adresse;
		this.date_creation = date_creation;
		this.creator = creator;
	}

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

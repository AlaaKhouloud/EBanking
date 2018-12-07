package com.back.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Agence implements Serializable{

	@Id @GeneratedValue
	private Long id_agence;
	private String nom;
	private String pays;
	private String ville;
	private String adresse;
	private Date date_creation;
	private Compte creator;
	
	public Agence(Long id_agence, String nom, String pays, String ville, String adresse, Date date_creation,
			Compte creator) {
		super();
		this.id_agence = id_agence;
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

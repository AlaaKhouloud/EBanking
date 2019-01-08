package com.back.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;

@Entity
public @Data class Agence implements Serializable{


	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_agence;
	private String nom;
	private String banque;
	private String pays;
	private String ville;
	private String adresse;
    @JsonFormat(pattern="yyyy-MM-dd")  
	private Date date_creation;
	@JoinColumn(name = "id_compte")
	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JsonIgnore
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
	
	public Agence(Long id_agence, String nom, String pays, String ville) {
		super(); 
		this.id_agence = id_agence;
		this.nom = nom;
		this.pays = pays;
		this.ville = ville;
		
	}

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

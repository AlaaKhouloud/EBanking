package com.back.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "Compte",  uniqueConstraints = @UniqueConstraint(columnNames = {"email" , "CIN"}))
public @Data class Compte implements Serializable{

	@Id @GeneratedValue
	private Long id_compte;
	private String CIN;
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String pays;
	private String ville;
	private String adresse;
	private String telephone;
	private Date date_naissance;
	private Date date_adhesion;
	private String RIB;
	private Etat_compte etat;
	private Agence agence;
	
	
	public Compte(Long id_compte, String cIN, String password, String nom, String prenom, String pays, String ville,
			String adresse, String telephone, Date date_naissance, Date date_adhesion, String rIB, Etat_compte etat,
			Agence agence) {
		super();
		this.id_compte = id_compte;
		CIN = cIN;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.pays = pays;
		this.ville = ville;
		this.adresse = adresse;
		this.telephone = telephone;
		this.date_naissance = date_naissance;
		this.date_adhesion = date_adhesion;
		RIB = rIB;
		this.etat = etat;
		this.agence = agence;
	}


	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

}

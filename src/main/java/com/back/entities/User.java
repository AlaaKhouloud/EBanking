package com.back.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email" , "CIN"}))
public @Data class User implements Serializable{

	@Id @GeneratedValue
	private Long id_user;
	private String CIN;
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String pays;
	private String ville;
	@OneToMany(mappedBy="adrs"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
    private List<Adresse> adresses;
	@OneToMany(mappedBy="tels"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
    private List<Telephone> telephones;
	private Date date_naissance;
	private Date date_adhesion;  
	private Role role;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String cIN, String email, String password, String nom, String prenom, String pays,
			String ville, List<Adresse> adresses, List<Telephone> telephones, Date date_naissance, Date date_adhesion,
			Role role) {
		super(); 
		CIN = cIN;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.pays = pays;
		this.ville = ville;
		this.adresses = adresses;
		this.telephones = telephones;
		this.date_naissance = date_naissance;
		this.date_adhesion = date_adhesion;
		this.role = role;
	}
	
	
}

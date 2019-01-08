package com.back.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email" , "CIN"}))
public @Data class User implements Serializable{


	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_user; 
	@JoinColumn(name="id_agence")
	private Long id_agence;
	private String CIN; 
	private String email; 
	private String password; 
	private String nom;	 
	private String prenom; 
	private String pays; 
	private String ville; 
	private boolean enabled;
	@OneToMany(mappedBy="adrs"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
    private List<Adresse> adresses;
	@OneToMany(mappedBy="tels"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
    private List<Telephone> telephones; 
	@JsonFormat(pattern="yyyy-MM-dd") 
	private Date date_naissance; 
	@JsonFormat(pattern="yyyy-MM-dd") 
	private Date date_ouverture; 
	@JsonFormat(pattern="yyyy-MM-dd") 
	private Date date_adhesion;  
	//@OneToMany(mappedBy="user_role"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
	//private Role role;
	@Enumerated(EnumType.STRING) 
	@JsonFormat(shape = JsonFormat.Shape.STRING) 
	private Role_values role;
	@OneToMany(mappedBy="user_cpt"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
	@JsonIgnore
	private List<Compte> comptes;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long id_user, String email, String password, boolean enabled, Role_values role) {
		super();
		this.id_user = id_user;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}


	public User( String email, String password, boolean enabled, Role_values role) {
		super(); 
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}
	
	public User( String email, String password) {
		super(); 
		this.email = email;
		this.password = password; 
	}
	
	public User(long id_user, String email, String password) {
		super(); 
		this.id_user = id_user;
		this.email = email;
		this.password = password; 
	}

	public User( String email, String password, String nom) {
		super(); 
		this.email = email;
		this.password = password;
		this.nom = nom;
	}

	public User(String cIN, String email, String password, String nom, String prenom, String pays, String ville,
			boolean enabled, List<Adresse> adresses, List<Telephone> telephones, Date date_naissance,
			Date date_ouverture, Date date_adhesion) {
		super();
		CIN = cIN;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.pays = pays;
		this.ville = ville;
		this.enabled = enabled;
		this.adresses = adresses;
		this.telephones = telephones;
		this.date_naissance = date_naissance;
		this.date_ouverture = date_ouverture;
		this.date_adhesion = date_adhesion;
	}

	public User(String cIN, String email, String password, String nom, String prenom, String pays, String ville,
			boolean enabled, Date date_naissance,
			Date date_ouverture, Date date_adhesion) {
		super();
		CIN = cIN;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.pays = pays;
		this.ville = ville;
		this.enabled = enabled;
		this.date_naissance = date_naissance;
		this.date_ouverture = date_ouverture;
		this.date_adhesion = date_adhesion;
	}



	public User(String email, String password, String nom, String prenom) {
		super();
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}


}

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


	public User(String email, String password, String nom, String prenom) {
		super();
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}


	public Long getId_user() {
		return id_user;
	}


	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}


	public String getCIN() {
		return CIN;
	}


	public void setCIN(String cIN) {
		CIN = cIN;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public List<Adresse> getAdresses() {
		return adresses;
	}


	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}


	public List<Telephone> getTelephones() {
		return telephones;
	}


	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}


	public Date getDate_naissance() {
		return date_naissance;
	}


	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}


	public Date getDate_ouverture() {
		return date_ouverture;
	}


	public void setDate_ouverture(Date date_ouverture) {
		this.date_ouverture = date_ouverture;
	}


	public Date getDate_adhesion() {
		return date_adhesion;
	}


	public void setDate_adhesion(Date date_adhesion) {
		this.date_adhesion = date_adhesion;
	}


	public Role_values getRole() {
		return role;
	}


	public void setRole(Role_values role) {
		this.role = role;
	}


	public List<Compte> getComptes() {
		return comptes;
	}


	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	

 
}

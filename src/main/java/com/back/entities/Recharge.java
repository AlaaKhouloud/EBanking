package com.back.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
public @Data class Recharge implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_recharge;
	@ManyToOne
	@JoinColumn(name = "id_compte")
	@JsonIgnore
	private Compte sender;
	private String Totelephone;
	@JsonFormat(pattern="yyyy-MM-dd")  
	private Date date_recharge; 
	@Enumerated(EnumType.STRING)
	@JsonFormat(shape = JsonFormat.Shape.STRING)  
	private Montant_rehcarge montant;
	
	
	public Recharge(Compte from, String totelephone, Date date_recharge, Montant_rehcarge montant) {
		super(); 
		this.sender = from;
		Totelephone = totelephone;
		this.date_recharge = date_recharge;
		this.montant = montant;
	}
	
	
	public Recharge() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId_recharge() {
		return id_recharge;
	}


	public void setId_recharge(Long id_recharge) {
		this.id_recharge = id_recharge;
	}


	public Compte getSender() {
		return sender;
	}


	public void setSender(Compte sender) {
		this.sender = sender;
	}


	public String getTotelephone() {
		return Totelephone;
	}


	public void setTotelephone(String totelephone) {
		Totelephone = totelephone;
	}


	public Date getDate_recharge() {
		return date_recharge;
	}


	public void setDate_recharge(Date date_recharge) {
		this.date_recharge = date_recharge;
	}


	public Montant_rehcarge getMontant() {
		return montant;
	}


	public void setMontant(Montant_rehcarge montant) {
		this.montant = montant;
	}
 
	
}

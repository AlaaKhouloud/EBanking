package com.back.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
public @Data class Recharge implements Serializable{

	@Id @GeneratedValue
	private Long id_recharge;
	@ManyToOne
	@JoinColumn(name = "id_compte")
	private Compte sender;
	private String Totelephone;
	private Date date_recharge;
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
 
	
}

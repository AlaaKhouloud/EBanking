package com.back.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Recharge implements Serializable{

	@Id @GeneratedValue
	private Long id_recharge;
	private Compte from;
	private String Totelephone;
	private Date date_recharge;
	private Montant_rehcarge montant;
	
	
	public Recharge(Long id_recharge, Compte from, String totelephone, Date date_recharge, Montant_rehcarge montant) {
		super();
		this.id_recharge = id_recharge;
		this.from = from;
		Totelephone = totelephone;
		this.date_recharge = date_recharge;
		this.montant = montant;
	}
	
	
	public Recharge() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

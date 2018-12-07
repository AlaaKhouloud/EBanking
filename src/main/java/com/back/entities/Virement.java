package com.back.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Virement implements Serializable{

	@Id @GeneratedValue
	private Long id_virement;
	private Compte from;
	private Compte to;
	private Date date_virement;
	private Double montant;
	private Etat_virement etat_virement;
	
	public Virement(Long id_virement, Compte from, Compte to, Date date_virement, Double montant,
			Etat_virement etat_virement) {
		super();
		this.id_virement = id_virement;
		this.from = from;
		this.to = to;
		this.date_virement = date_virement;
		this.montant = montant;
		this.etat_virement = etat_virement;
	}

	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

package com.back.entities;

import java.io.Serializable;
import java.util.Date; 
import java.util.Map;

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
public @Data class Virement implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_virement; 
	@ManyToOne
	@JoinColumn(name = "id_compte")
	@JsonIgnore
	private Compte from_RIB;
	private String to_RIB;
	@JsonFormat(pattern="yyyy-MM-dd")  
	private Date date_virement;
	private Double montant;
	@Enumerated(EnumType.STRING)
	@JsonFormat(shape = JsonFormat.Shape.STRING)  
	private Etat_virement etat_virement;
	
 
	public Long getId_virement() {
		return id_virement;
	}


	public void setId_virement(Long id_virement) {
		this.id_virement = id_virement;
	}


	public Compte getFrom_RIB() {
		return from_RIB;
	}


	public void setFrom_RIB(Compte from_RIB) {
		this.from_RIB = from_RIB;
	}


	public String getTo_RIB() {
		return to_RIB;
	}


	public void setTo_RIB(String to_RIB) {
		this.to_RIB = to_RIB;
	}


	public Date getDate_virement() {
		return date_virement;
	}


	public void setDate_virement(Date date_virement) {
		this.date_virement = date_virement;
	}


	public Double getMontant() {
		return montant;
	}


	public void setMontant(Double montant) {
		this.montant = montant;
	}


	public Etat_virement getEtat_virement() {
		return etat_virement;
	}


	public void setEtat_virement(Etat_virement etat_virement) {
		this.etat_virement = etat_virement;
	}


	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Virement(Compte from, String to_RIB, Date date_virement, Double montant,
			Etat_virement etat_virement) {
		super(); 
		this.from_RIB = from;
		this.to_RIB = to_RIB;
		this.date_virement = date_virement;
		this.montant = montant;
		this.etat_virement = etat_virement;
	}

}

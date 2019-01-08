
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
	
	public Virement(Compte from, String to_RIB, Double montant) {
		super(); 
		this.from_RIB = from;
		this.to_RIB = to_RIB;
		
		this.montant = montant;
		
	}

}

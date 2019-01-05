package com.back.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn; 
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne; 

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity 
public @Data class Compte implements Serializable{

	@Id @GeneratedValue 
	private Long id_compte;
	@ManyToOne
	@JoinColumn(name = "id_user") 
	@JsonIgnore
	private User user_cpt; 
	@JsonFormat(pattern="yyyy-MM-dd")  
	private Date date_creation_compte;  
	private String RIB;
	@JsonFormat(shape = JsonFormat.Shape.STRING)  
	@Enumerated(EnumType.STRING)
	private Etat_compte etat;
	@JoinColumn(name = "id_agence")
	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	private Agence agence;
	@OneToMany(mappedBy="sender"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
	@JsonIgnore
    private List<Recharge> recharges;
	@OneToMany(mappedBy="from_RIB"  , fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
	@JsonIgnore
    private List<Virement> virements;
	 
    
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Compte(User utilisateur, Date date_creation_compte, String rIB,
			Etat_compte etat, Agence agence, List<Recharge> recharges, List<Virement> virements) {
		super(); 
		this.user_cpt = utilisateur; 
		this.date_creation_compte = date_creation_compte;
		RIB = rIB;
		this.etat = etat;
		this.agence = agence;
		this.recharges = recharges;
		this.virements = virements;
	}

    
}

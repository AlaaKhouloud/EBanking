package com.back.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CascadeType;

import lombok.Data;

@Entity 
public @Data class Compte implements Serializable{

	@Id @GeneratedValue
	private Long id_compte;
	private User utilisateur; 
	private Date date_ouverture;
	private Date date_creation_compte;
	private String RIB;
	private Etat_compte etat;
	private Agence agence;
	@OneToMany(mappedBy="sender"  , fetch = FetchType.LAZY , cascade = javax.persistence.CascadeType.ALL)
    private List<Recharge> recharges;
	@OneToMany(mappedBy="from_RIB"  , fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
    private List<Virement> virements;
	 
    
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Compte(User utilisateur, Date date_ouverture, Date date_creation_compte, String rIB,
			Etat_compte etat, Agence agence, List<Recharge> recharges, List<Virement> virements) {
		super(); 
		this.utilisateur = utilisateur;
		this.date_ouverture = date_ouverture;
		this.date_creation_compte = date_creation_compte;
		RIB = rIB;
		this.etat = etat;
		this.agence = agence;
		this.recharges = recharges;
		this.virements = virements;
	}

    
}

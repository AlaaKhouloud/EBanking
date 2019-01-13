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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CascadeType;

import javax.persistence.JoinColumn; 
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;

@Entity 
public @Data class Compte implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_compte;
	@ManyToOne
	@JoinColumn(name = "id_user") 
	@JsonIgnore
	private User user_cpt; 
	@JsonFormat(pattern="yyyy-MM-dd")  
	private Date date_creation_compte;  
	private String RIB;
	@ColumnDefault("0")
	private Double money;
	@ColumnDefault("0")
	private Double money_for_transactions;
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
	}


	public Compte(User user_cpt, Date date_creation_compte, String rIB, Double money, Double money_for_transactions,
			Etat_compte etat, Agence agence, List<Recharge> recharges, List<Virement> virements) {
		super();
		this.user_cpt = user_cpt;
		this.date_creation_compte = date_creation_compte;
		RIB = rIB;
		this.money = money;
		this.money_for_transactions = money_for_transactions;
		this.etat = etat;
		this.agence = agence;
		this.recharges = recharges;
		this.virements = virements;
	}
	
	
	public Compte(User user_cpt, String rIB, Double money) {
		super();
		
		RIB = rIB;
		this.money = money; 
		this.user_cpt = user_cpt;
	}


}

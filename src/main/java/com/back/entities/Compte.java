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
		// TODO Auto-generated constructor stub
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


	public Long getId_compte() {
		return id_compte;
	}


	public void setId_compte(Long id_compte) {
		this.id_compte = id_compte;
	}


	public User getUser_cpt() {
		return user_cpt;
	}


	public void setUser_cpt(User user_cpt) {
		this.user_cpt = user_cpt;
	}


	public Date getDate_creation_compte() {
		return date_creation_compte;
	}


	public void setDate_creation_compte(Date date_creation_compte) {
		this.date_creation_compte = date_creation_compte;
	}


	public String getRIB() {
		return RIB;
	}


	public void setRIB(String rIB) {
		RIB = rIB;
	}


	public Double getMoney() {
		return money;
	}


	public void setMoney(Double money) {
		this.money = money;
	}


	public Double getMoney_for_transactions() {
		return money_for_transactions;
	}


	public void setMoney_for_transactions(Double money_for_transactions) {
		this.money_for_transactions = money_for_transactions;
	}


	public Etat_compte getEtat() {
		return etat;
	}


	public void setEtat(Etat_compte etat) {
		this.etat = etat;
	}


	public Agence getAgence() {
		return agence;
	}


	public void setAgence(Agence agence) {
		this.agence = agence;
	}


	public List<Recharge> getRecharges() {
		return recharges;
	}


	public void setRecharges(List<Recharge> recharges) {
		this.recharges = recharges;
	}


	public List<Virement> getVirements() {
		return virements;
	}


	public void setVirements(List<Virement> virements) {
		this.virements = virements;
	}

    
}

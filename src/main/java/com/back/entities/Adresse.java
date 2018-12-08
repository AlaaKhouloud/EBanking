package com.back.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity 
public @Data class Adresse {

	@Id @GeneratedValue
	private Long id_adresse;
	private String adrs;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	public Adresse(String adrs, User user) {
		super(); 
		this.adrs = adrs;
		this.user = user;
	}
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

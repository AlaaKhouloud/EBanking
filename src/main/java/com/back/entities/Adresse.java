package com.back.entities;


import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity 
public @Data class Adresse implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_adresse;
	private String adrs;
	@ManyToOne
	@JoinColumn(name = "id_user")
	@JsonIgnore
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

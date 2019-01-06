package com.back.entities;

 

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity 
public @Data class Telephone implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_tel;
	private String tels;
	@ManyToOne
	@JoinColumn(name = "id_user")
	@JsonIgnore
	private User user;
	
	public Telephone(String tels, User user) {
		super(); 
		this.tels = tels;
		this.user = user;
	}
	public Telephone() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

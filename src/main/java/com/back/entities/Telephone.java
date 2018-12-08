package com.back.entities;

 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity 
public @Data class Telephone {

	@Id @GeneratedValue
	private Long id_tel;
	private String tels;
	@ManyToOne
	@JoinColumn(name = "id_user")
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

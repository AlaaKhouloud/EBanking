package com.back.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Role implements Serializable{

	@Id @GeneratedValue
	private Long id_role;
	private Role_values role;
	private String description;
	
	public Role(Role_values role, String description) {
		super(); 
		this.role = role;
		this.description = description;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
 
}

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
	private String role;
	private String description;
	
	public Role(Long id_role, String role, String description) {
		super();
		this.id_role = id_role;
		this.role = role;
		this.description = description;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

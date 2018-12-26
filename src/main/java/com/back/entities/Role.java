package com.back.entities;

import java.io.Serializable;

import javax.persistence.*; 

import lombok.Data;

@Entity
public @Data class Role implements Serializable{

	@Id @GeneratedValue
	private Long id_role;
	@Enumerated(EnumType.STRING)
	private Role_values role;
	private String description;
	/*@ManyToOne
	@JoinColumn(name = "id_user")
	private User user_role;*/
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

 
}

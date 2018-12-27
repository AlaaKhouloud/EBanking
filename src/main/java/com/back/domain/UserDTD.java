package com.back.domain;

import java.io.Serializable;

import com.back.entities.User;

import lombok.Data;

public @Data class UserDTD implements Serializable{

	private User user;
	private String token;
	
	public UserDTD(User user, String token) {
		super();
		this.user = user;
		this.token = token;
	};
	
	
	
	
}

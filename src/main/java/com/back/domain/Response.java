package com.back.domain;

import java.io.Serializable;

import lombok.Data;

public @Data class Response implements Serializable{

	private String message;

	public Response(String message) {
		super();
		this.message = message;
	}
	
	
}

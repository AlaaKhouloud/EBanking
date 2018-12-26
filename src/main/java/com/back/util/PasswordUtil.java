package com.back.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public static String getPasswordHash(String password) {
		// TODO Auto-generated method stub
		return encoder.encode(password);
	}

}

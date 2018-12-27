package com.back.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.back.entities.User;

public class JwtUserFactory {

	public static JwtUser create(User user) {
		// TODO Auto-generated method stub
		return new JwtUser(user.getId_user() , user.getEmail() , user.getPassword(),user , maptoGrantedAuthorities(new ArrayList<String>(Arrays.asList(""+user.getRole()))) , user.isEnabled());
	}

	private static Collection<? extends GrantedAuthority> maptoGrantedAuthorities(ArrayList<String> authorities) {		
		return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
	}

}

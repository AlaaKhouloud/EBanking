package com.back.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.back.dao.UserRepository;


@Service
public class MyAppUserDetailsService  implements UserDetailsService{
	@Autowired
	private   UserRepository userrep;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.back.entities.User activeUserInfo = (com.back.entities.User) userrep.findByUsername(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole().toString());
		UserDetails userDetails = (UserDetails)new User(activeUserInfo.getEmail(),
				activeUserInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}

}

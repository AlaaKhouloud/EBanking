package com.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.cors.CorsConfiguration;
import  org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.back.dao.*;
import com.back.entities.*;
import com.back.entities.Role_values; 

@SpringBootApplication
public class BackEBankingApplication {

	@Autowired
	private   RoleRepository rolerep ; 
	@Autowired 
	private   UserRepository userrep;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BackEBankingApplication.class, args);



		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("khouloud"));

	}
	
	public  void run(String...args) {
		/*rolerep.save(new Role(Role_values.ROLE_CLIENT,"client role")); 
		rolerep.flush();
		userrep.save(new User("ffff","fefefe"));
		userrep.flush();
	    List<Role> roles = rolerep.findAll();
	    roles.forEach(r->System.out.println(r.getRole()));*/
    }
	

	@Bean
	public CorsFilter corsfFilter() {
		final UrlBasedCorsConfigurationSource source = new  UrlBasedCorsConfigurationSource();
		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedHeader("*");
		configuration.addAllowedOrigin("*");
		configuration.addAllowedMethod("OPTIONS");
		configuration.addAllowedMethod("POST");
		configuration.addAllowedMethod("GET");
		configuration.addAllowedMethod("PUT");
		configuration.addAllowedMethod("DELETE"); 
		source.registerCorsConfiguration("/**", configuration);
		return new CorsFilter(source);

	}


}

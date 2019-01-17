package com.back;
 
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
 
@SpringBootApplication
public class BackEBankingApplication implements CommandLineRunner{

	private static final Logger Log = LoggerFactory.getLogger(BackEBankingApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BackEBankingApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("khouloud"));
	}
	
	@Value("${application.name}")
	private String applicationName;
	@Value("${usename}")
	private String Username;
	
	public void run(String...args) {
		
		Log.info("Application name : {} , Username : {}"  , applicationName , Username);
	}
	
}

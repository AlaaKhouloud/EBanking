package com.back;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.back.rmi.EBankingRmiRemote;

@Configuration
public class MyConfig {
	
	@Bean
	public RmiServiceExporter getRmiService(ApplicationContext ctx){
		
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setService(ctx.getBean("myRmiService"));
		exporter.setRegistryPort(1098);
		exporter.setServiceName("BK");
		exporter.setServiceInterface(EBankingRmiRemote.class);
		return exporter;
	}

}

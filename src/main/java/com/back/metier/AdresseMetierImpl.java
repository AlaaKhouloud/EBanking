package com.back.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.dao.AdresseRepository;


@Service
public class AdresseMetierImpl implements AdresseMetier {

	
	@Autowired
	private AdresseRepository adresseRepository;
	
	
	@Override
	public String getAdresse(Long id_user) {
		// TODO Auto-generated method stub
		
		
		return adresseRepository.findByIdUser(id_user) ;
	}

}

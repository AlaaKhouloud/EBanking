package com.back.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.dao.AgenceRepository;
import com.back.entities.Agence;

@Service
public class AgenceMetierImpl implements AgenceMetier{

	@Autowired
	private AgenceRepository agenceRepository;
	
	@Override
	public Agence creerAgence(Agence a) {
		// TODO Auto-generated method stub
		return agenceRepository.saveAndFlush(a);
	}

	@Override
	public List<Agence> listAgence() {
		// TODO Auto-generated method stub
		return agenceRepository.findAll();
	}

	@Override
	public Agence getAgence(Long id) {
		// TODO Auto-generated method stub
		return agenceRepository.getOne(id);
	}

}

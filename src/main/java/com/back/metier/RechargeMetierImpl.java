package com.back.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.dao.RechargeRepository;
import com.back.entities.Recharge;

@Service
public class RechargeMetierImpl implements RechargeMetier{

	@Autowired
	private RechargeRepository rechargeRepository;
	
	
	@Override
	public Recharge recharge(Long id) {
		// TODO Auto-generated method stub
		return rechargeRepository.getOne(id);
	}

	
	@Override
	public List<Recharge> listRecharge() {
		// TODO Auto-generated method stub
		return rechargeRepository.findAll();
	}

}

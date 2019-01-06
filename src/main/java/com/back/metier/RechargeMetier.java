package com.back.metier;


import java.util.List;
import com.back.entities.Recharge;

public interface RechargeMetier {

	public Recharge recharge(Long id);
	//public List<Compte> listCmptRechargeDate(Long id, Date d);
	public List<Recharge> listRecharge();
	
}

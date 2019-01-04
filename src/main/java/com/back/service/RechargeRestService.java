package com.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.RechargeRepository;

@RestController
public class RechargeRestService {

	@Autowired
	private RechargeRepository rechRepository;
	
}

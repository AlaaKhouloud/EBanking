package com.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.VirementRepository;

@RestController
public class VirementRestService {

	@Autowired
	private VirementRepository virRepository;
}

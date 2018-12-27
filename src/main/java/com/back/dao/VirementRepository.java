package com.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.entities.Virement;


public interface VirementRepository  extends JpaRepository<Virement, Long> {

}

package com.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.entities.Compte;

public interface CompteRepository  extends JpaRepository<Compte, Long>{

}

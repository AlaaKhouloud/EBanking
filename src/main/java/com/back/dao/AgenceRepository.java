package com.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.entities.Agence; 

public interface AgenceRepository  extends JpaRepository<Agence, Integer>{

}

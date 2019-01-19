package com.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 

import com.back.entities.Compte;

public interface CompteRepository  extends JpaRepository<Compte, Long>{

	@Query("SELECT c FROM Compte c where c.id_compte = :x1")
	public Compte findCompteById(@Param("x1") Long id);
}

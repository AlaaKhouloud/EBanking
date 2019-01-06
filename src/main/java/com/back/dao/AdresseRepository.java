package com.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.entities.Adresse;

public interface AdresseRepository  extends JpaRepository<Adresse, Long>{

	
	@Query("SELECT ad.adrs  FROM Adresse ad where id_user = :x1")
	public String findByIdUser(@Param("x1") Long id);
}



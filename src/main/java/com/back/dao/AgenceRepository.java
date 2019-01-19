package com.back.dao;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.entities.Agence;
import com.back.entities.Compte;
import com.back.entities.User; 

public interface AgenceRepository  extends JpaRepository<Agence, Long>{
	
	@Query("SELECT ag FROM Agence ag where id_agence = :id")
	public Optional<Agence> findById(@Param("id") Long id);
	
	@Query("SELECT ag FROM Agence ag where nom = :x1")
	public Agence findByName(@Param("x1") String name);
	
	@Query("SELECT ag FROM Agence ag where banque = :x1")
	public List<Agence> findAllAgence(@Param("x1") String banque);
	
	@Query("SELECT ag.nom FROM Agence ag")
	public List<String> findAllAgenceNames();
	
	@Query("SELECT ag.id_agence FROM Agence ag where nom = :x1")
	public Long findagenceidByName(@Param("x1") String name);
     
	//@Query("INSERT INTO agence (nom, pays, ville, adresse, date_creation) VALUES (:nom, :pays, :ville, :adresse, :date_creation);")
	/*public Agence addAgence (@Param("nom") String nom,
			                 @Param("pays") String pays,
			                 @Param("ville") String ville,
			                 @Param("adresse") String adresse,
		                 @Param("date_creation") Date date_creation);
*/	
 
}

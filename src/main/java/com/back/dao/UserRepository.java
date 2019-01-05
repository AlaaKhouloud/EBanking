package com.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.entities.User; 

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	@Query("SELECT u FROM User u where email = :x1 and password = :x2")
	public User findByEmail(@Param("x1") String email,@Param("x2")  String mot_de_passe);
	
	
	@Query("SELECT u FROM User u where email = :x1")
	public Object findByUsername(String email);
	
	
	
}

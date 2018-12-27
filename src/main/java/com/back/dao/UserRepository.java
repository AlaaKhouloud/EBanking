package com.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	
	
	@Query("SELECT u FROM User u where nom = :x1")
	public User findByName(@Param("x1") String name);
}

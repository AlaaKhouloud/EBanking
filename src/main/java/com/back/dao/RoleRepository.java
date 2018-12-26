package com.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.entities.Role; 

public interface RoleRepository  extends JpaRepository<Role, Long>{

}

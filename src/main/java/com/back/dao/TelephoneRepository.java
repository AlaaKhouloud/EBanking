package com.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.entities.Telephone;

 
public interface TelephoneRepository  extends JpaRepository<Telephone, Long>{

}

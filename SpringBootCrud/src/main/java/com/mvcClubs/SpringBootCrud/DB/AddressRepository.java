package com.mvcClubs.SpringBootCrud.DB;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvcClubs.SpringBootCrud.model.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {
	 
	
	}

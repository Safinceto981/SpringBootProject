package com.mvcClubs.SpringBootCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvcClubs.SpringBootCrud.DB.RoleRepository;
import com.mvcClubs.SpringBootCrud.model.Address;
import com.mvcClubs.SpringBootCrud.model.Role;



@Service
@Transactional
public class RoleService {

	
	@Autowired
	private RoleRepository rRepo;
	
	public List<Role>roleListAll(){
		return rRepo.findAll();
		
	}
	public void save(Role role) {

		rRepo.save(role);
		
	}
	public void delete(long id) {
		rRepo.deleteById(id);
		
	}
	public Optional <Role>findById(Long id) {
		return rRepo.findById(id);
		
	}


	
	
}

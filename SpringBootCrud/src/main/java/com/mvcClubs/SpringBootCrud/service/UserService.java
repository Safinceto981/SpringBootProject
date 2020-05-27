package com.mvcClubs.SpringBootCrud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcClubs.SpringBootCrud.DB.UserRepository;
import com.mvcClubs.SpringBootCrud.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	public List<User>userListAll(){
		return uRepo.findAll();
		
	}
	public void save(User user) {

		uRepo.save(user);
		 
	}
	public void delete(long id) {
		uRepo.deleteById(id);
		
	}
	public Optional <User>findById(Long id) {
		return uRepo.findById(id);
		
	}

}

package com.mvcClubs.SpringBootCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvcClubs.SpringBootCrud.DB.PersonRepository;
import com.mvcClubs.SpringBootCrud.model.Person;
@Service
@Transactional
public class PersonService {
 
    @Autowired
    private PersonRepository pRepo;
    
     
    public List<Person> peopleListAll() {
        return pRepo.findAll();
    }
     
    public void save(Person person) {
    	pRepo.save(person);
    	
    }
     
   
     
    public void delete(long id) {
    	pRepo.deleteById(id);
    }

	public Optional<Person> findById(Long id) {
	return pRepo.findById(id);
	}
    
   
	
}
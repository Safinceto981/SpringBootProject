package com.mvcClubs.SpringBootCrud.DB;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mvcClubs.SpringBootCrud.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {
 
}

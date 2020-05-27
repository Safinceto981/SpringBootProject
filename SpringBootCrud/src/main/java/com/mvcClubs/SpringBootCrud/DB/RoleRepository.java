package com.mvcClubs.SpringBootCrud.DB;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvcClubs.SpringBootCrud.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}

package com.mvcClubs.SpringBootCrud.model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Transient
	public String getPasswordConfirm() {
	    return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
	    this.passwordConfirm = passwordConfirm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getMiddleName() {
		return middleName;
	}

	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "USERNAME", nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	private String passwordConfirm;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "MIDDLE_NAME", nullable = false)
	private String middleName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "ROLE_ID", nullable = false)
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "ADDRESS_ID", nullable = false)
	private Address address;


}

package com.mvcClubs.SpringBootCrud.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLUB")
public class Club {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@ManyToMany(mappedBy = "clubs")
	private Set<Person> owners;

//	@OneToOne
//	@JoinColumn(name = "ADDRESS_ID")
//	private Address address;

//		@Column(name = "NAME", nullable = false)
//		private Set<Person> employees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getOwners() {
		return owners;
	}

	public void setOwners(Set<Person> owners) {
		this.owners = owners;
	}

	

//		public Set<Person> getEmployees() {
//			return employees;
//		}
	//
//		public void setEmployees(Set<Person> employees) {
//			this.employees = employees;
//		}

}

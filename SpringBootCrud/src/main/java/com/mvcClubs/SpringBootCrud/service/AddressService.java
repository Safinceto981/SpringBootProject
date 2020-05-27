package com.mvcClubs.SpringBootCrud.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvcClubs.SpringBootCrud.DB.AddressRepository;
import com.mvcClubs.SpringBootCrud.model.Address;

@Service
@Transactional
public class AddressService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private AddressRepository aRepo;

	public List<Address> addressListAll() {
		return aRepo.findAll();
	}

	public void save(Address address) {
		aRepo.save(address);
	}

	

	public void delete(long id) {
		aRepo.deleteById(id);
	}

	public Optional<Address> findById(Long id) {
		return aRepo.findById(id);
	}

//	public Set<Address> findAddressByName(String street) {
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Address> query = builder.createQuery(Address.class);
//		Root<Address> root = query.from(Address.class);
//
//		query.select(root).where(builder.and(builder.equal(root.get("street"), street)));
//
//		return new LinkedHashSet<Address>(entityManager.createQuery(query).getResultList());
//	}

}
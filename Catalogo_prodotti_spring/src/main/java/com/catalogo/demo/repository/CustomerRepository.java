package com.catalogo.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.demo.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	@Query(value = "select * from customer a where a.email like ?1", nativeQuery = true)
	Customer findByEmail(String email);

	
	

}

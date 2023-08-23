package com.prenotazioni.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prenotazioni.demo.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	
	@Query(value = "select \"user_role\" from customer a where a.email like ?1", nativeQuery = true)
	List<String> findRoles(String username);

	@Query(value = "select \"password\"  from customer a where a.email like ?1", nativeQuery = true)
	String findPassword(String username);

}

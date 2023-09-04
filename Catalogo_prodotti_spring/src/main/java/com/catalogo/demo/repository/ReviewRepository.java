package com.catalogo.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.demo.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer>{

	Review save(Review review);
	
	ArrayList<Review> findAll();
	
	@Query(value = "select * from review r where r.customer_id = ?1 and r.number_code = ?2", nativeQuery = true)
	Review findCustomerProduct(int customer, int product);
}

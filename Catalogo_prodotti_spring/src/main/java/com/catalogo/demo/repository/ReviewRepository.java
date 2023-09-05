package com.catalogo.demo.repository;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.demo.model.Product;
import com.catalogo.demo.model.Review;
import com.catalogo.demo.response.EmailReviewResponse;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer>{

	Review save(Review review);
	
	Review findById(int id);
	
	ArrayList<Review> findAll();
	
	@Query(value = "select * from review r where r.customer_id = ?1 and r.number_code = ?2", nativeQuery = true)
	Review findCustomerProduct(int customer, int product);
	
	/*@Query(value = "select c.email, rew.comment from customer c join "
			+ "(select * from review r where r.number_code = ?1) as rew "
			+ "on(c.customer_id = rew.customer_id)", nativeQuery = true)
	ArrayList<EmailReviewResponse> findByProduct(int id); */
	
	@Query(value = "select * from review r where r.number_code = ?1", nativeQuery = true)
	ArrayList<Review> findByProduct(int id);
	
	
	@Query(value = "select * from review r where r.number_code = ?1 and r.customer_id != ?2", nativeQuery = true)
	ArrayList<Review> findOthersByProduct(int idProduct, int idCustomer);
}

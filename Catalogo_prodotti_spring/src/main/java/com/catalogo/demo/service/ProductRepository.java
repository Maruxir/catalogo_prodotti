package com.catalogo.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.demo.model.Customer;
import com.catalogo.demo.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	@Query(value = "select * from product", nativeQuery = true)
	List<Product> getProduct();

}

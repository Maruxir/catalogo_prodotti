package com.catalogo.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.demo.model.Customer;
import com.catalogo.demo.model.Product;
import com.catalogo.demo.model.Supplier;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	ArrayList<Product> findAll();

	@Query(value = "select id_ps from product_supplier ps where ps.number_code = ?1", nativeQuery = true)
	List<Integer> getSuppliers(int productId);
	
	void deleteById(int id);
	
}

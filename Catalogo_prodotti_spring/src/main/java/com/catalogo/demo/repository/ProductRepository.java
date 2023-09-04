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

	@Query(value = "select * from product p where p.name LIKE %?1%", nativeQuery = true)
	List<Product> getByName(String name);
	
	@Query(value = "SELECT * from product p join \r\n"
			+ "(select ps.number_code AS prod_number_code from product_supplier ps join supplier s ON ps.supplier_id = s.supplier_id WHERE s.name LIKE %?1%) f\r\n"
			+ "On p.number_code = f.prod_number_code", nativeQuery = true)
	List<Product> getByFornitore(String name);
	
	Product findById(int id);
}

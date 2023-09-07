package com.catalogo.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.demo.model.Product_supplier;
import com.catalogo.demo.model.Roles;
import com.catalogo.demo.service.ProductService;

@Repository
public interface ProductSupplierRepository extends CrudRepository<Product_supplier, Integer>{
	
	@Query(value = "select * from product_supplier ps where ps.number_code = ?1", nativeQuery = true)
	Product_supplier findByProduct(int id);

	Product_supplier save(Product_supplier productSupplier);
}

package com.catalogo.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.demo.model.Supplier;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Integer>{
	@Query(value = "select * from supplier a where a.supplier_id like ?1", nativeQuery = true)
	List<Supplier> findById(int id);
	
	ArrayList<Supplier> findAll();
	
	Supplier save(Supplier supplier);
	
}

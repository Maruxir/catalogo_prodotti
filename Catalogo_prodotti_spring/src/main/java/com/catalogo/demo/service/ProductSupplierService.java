package com.catalogo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.catalogo.demo.model.Product_supplier;
import com.catalogo.demo.repository.ProductSupplierRepository;

@Service
public class ProductSupplierService {
	@Autowired
	private ProductSupplierRepository productSupplierRepository;

	public void delete(int id) {
		productSupplierRepository.deleteById(id);
	}

	public Product_supplier findByProduct(int id) {
		
		return productSupplierRepository.findByProduct(id);
	}

	public void create(Product_supplier productSupplier) {
		productSupplierRepository.save(productSupplier);
		
	}

	
	
}

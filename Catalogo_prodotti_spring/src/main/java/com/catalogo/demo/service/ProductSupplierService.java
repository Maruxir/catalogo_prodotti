package com.catalogo.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public ArrayList<Product_supplier> findAllByProduct(int id) {
		
		return productSupplierRepository.findAllByProduct(id);
	} 
	public void save(Product_supplier product_supplier) {
		productSupplierRepository.save(product_supplier);
		
	}

	public ArrayList<Product_supplier> findAllBySupplier(int id) {
		
		return productSupplierRepository.findAllBySupplier(id);
	}


	
	
}

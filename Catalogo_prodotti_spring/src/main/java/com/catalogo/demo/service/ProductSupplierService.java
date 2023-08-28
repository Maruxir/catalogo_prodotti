package com.catalogo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.demo.repository.ProductSupplierRepository;

@Service
public class ProductSupplierService {
	@Autowired
	private ProductSupplierRepository productSupplierRepository;

	public void delete(int id) {
		productSupplierRepository.deleteById(id);
	}

	
	
}

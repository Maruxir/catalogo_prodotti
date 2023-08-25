package com.catalogo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.demo.model.Product;
import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.repository.CustomerRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProduct() {
		return productRepository.getProduct();
	}

	/*public List<Supplier> getSuppliers(int id) {
		
		return ;
	} */

}

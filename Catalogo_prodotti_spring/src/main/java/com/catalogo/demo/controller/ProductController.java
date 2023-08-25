package com.catalogo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.demo.model.Product;
import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProduct();
	}
	
	/*@RequestMapping("/products/{id}") 
	public List<Supplier> getSuppliers(@PathVariable int id) {
		return productService.getSuppliers(id);
	}*/
	
}

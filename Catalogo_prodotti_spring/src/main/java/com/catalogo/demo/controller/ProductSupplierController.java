package com.catalogo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.demo.service.ProductSupplierService;

@RestController
public class ProductSupplierController {
	@Autowired
	ProductSupplierService productSupplierService;
	
	@GetMapping("/deletePs/{id}")
	public void delete(@PathVariable int id) {
		productSupplierService.delete(id);
	}
}

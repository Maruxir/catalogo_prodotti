package com.catalogo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.service.SupplierService;

@RestController
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	
	@GetMapping("/prova/{email}")
	public Supplier prova(@PathVariable String email) {
		return supplierService.findByEmail(email);
	}
}

package com.prenotazioni.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prenotazioni.demo.model.Customer;
import com.prenotazioni.demo.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/Customer/{id}") 
	public Optional<Customer> get(@PathVariable int id) {
		return service.getName(id);
	}

}

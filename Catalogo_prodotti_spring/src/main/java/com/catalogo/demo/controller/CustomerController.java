package com.catalogo.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.demo.model.Customer;
import com.catalogo.demo.service.CustomerService;

import jakarta.annotation.security.PermitAll;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/Customer/{id}") 
	public Optional<Customer> get(@PathVariable int id) {
		return service.getName(id);
	}
	
	@RequestMapping("/Customer") 
	public String emailget() {
		return service.email("sara.bianchi");
	}
	
	   @GetMapping("/users")
	    public String users(){
	        return "ciao ciao ciaooooo";
	    }
	
	@RequestMapping("/demo") 
	public String ciao() {
		return "Ci siamo!";
	}
	
	@RequestMapping("/uno") 
	public String ciao1() {
		return "con log!";
	}
}

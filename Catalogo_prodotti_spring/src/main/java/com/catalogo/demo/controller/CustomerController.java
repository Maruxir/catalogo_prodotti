package com.catalogo.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.demo.model.Customer;
import com.catalogo.demo.model.Review;
import com.catalogo.demo.service.CustomerService;

import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpSession;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/Customer/{id}") 
	public Optional<Customer> get(@PathVariable int id) {
		return service.getName(id);
	}
	
	
	   @GetMapping("/users")
	    public String users(){
	        return "ciao ciao ciaooooo";
	    }
	   
	   @GetMapping("/administrator")
	    public String administrator(){
	        return "sono l'amministratore";
	    }
	   
	   @GetMapping("/custo")
	    public String cus( HttpSession session){
		   String email = (String) session.getAttribute("email");
		   return email;
	    }
	
	   
}


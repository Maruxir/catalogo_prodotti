package com.catalogo.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.demo.model.Customer;
import com.catalogo.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;

	public Optional<Customer> getName(int id) {
		Optional<Customer> customer = repository.findById(id);
		return customer;
	}

	public String email(String email) {
		Customer customer = repository.findByEmail(email);
		return customer.getPassword();
	}

}

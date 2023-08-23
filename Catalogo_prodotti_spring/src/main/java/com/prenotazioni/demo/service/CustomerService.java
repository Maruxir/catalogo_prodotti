package com.prenotazioni.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prenotazioni.demo.model.Customer;
import com.prenotazioni.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;

	public Optional<Customer> getName(int id) {
		Optional<Customer> customer = repository.findById(id);
		return customer;
	}

}

package com.prenotazioni.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();
	
	public int getId() {
		return customer_id;
	}
	public void setId(int id) {
		this.customer_id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

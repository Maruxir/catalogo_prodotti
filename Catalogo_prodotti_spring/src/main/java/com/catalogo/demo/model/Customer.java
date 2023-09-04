package com.catalogo.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	  @ManyToOne
	    @JoinColumn(name = "role_id")
	    private Roles user_role;
	  
	public Roles getUser_role() {
		return user_role;
	}

	public void setUser_role(Roles role) {
		this.user_role = role;
	}

	
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

package com.catalogo.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number_code;
	private String name;
	private String description;
	private double price;
	
	@ManyToMany(mappedBy = "products")
	private List<Supplier> suppliers;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();
	
	public int getNumber_code() {
		return number_code;
	}
	public void setNumber_code(int number_code) {
		this.number_code = number_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

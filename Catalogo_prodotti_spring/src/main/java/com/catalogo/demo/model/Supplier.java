
package com.catalogo.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplier_id;
	private String name;
	private String email;
	private String password;
	private String address;
	
	@ManyToMany
	@JoinTable(
	        name = "Supplier_products",
	        joinColumns = @JoinColumn(name = "supplier_id"),
	        inverseJoinColumns = @JoinColumn(name = "number_code")
	    )
	private List<Product> products;
	
	
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

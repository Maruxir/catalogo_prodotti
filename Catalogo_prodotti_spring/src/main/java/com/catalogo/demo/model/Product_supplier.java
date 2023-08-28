package com.catalogo.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product_supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ps;
	
	 @ManyToOne
	    @JoinColumn(name = "number_code")
	private Product product;
	 
	 @ManyToOne
	    @JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	
	public int getId_ps() {
		return id_ps;
	}
	public void setId_ps(int id_ps) {
		this.id_ps = id_ps;
	}
	public Product getId_product() {
		return product;
	}
	public void setId_product(Product product) {
		this.product = product;
	}
	public Supplier getId_supplier() {
		return supplier;
	}
	public void setId_supplier(Supplier id_supplier) {
		this.supplier = supplier;
	}
}

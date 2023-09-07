package com.catalogo.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.demo.model.Product;
import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	SupplierRepository supplierRepository;

	public ArrayList<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	public void delete(int id) {
		supplierRepository.deleteById(id);
		
	}
	
	public void save(Supplier supplier) {
		int max = 0;
		ArrayList<Supplier> suppliers = supplierRepository.findAll();
		for(Supplier idSupplier : suppliers) {
			if(idSupplier.getSupplier_id() > max) {
				max = idSupplier.getSupplier_id();
			}	
		}
		max = max+1;
		supplier.setSupplier_id(max);
		supplierRepository.save(supplier);
	}
	
	public Supplier findByEmail(String email) {
		return supplierRepository.findByEmail(email);
	}

	public Supplier findById(int idSupplier) {
		return supplierRepository.findById(idSupplier);
	}

	public void update(Supplier supplier) {
		supplierRepository.save(supplier);
		
	}
		
}

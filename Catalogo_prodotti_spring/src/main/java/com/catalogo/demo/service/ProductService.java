package com.catalogo.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.demo.model.Product;
import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.repository.ProductRepository;
import com.catalogo.demo.repository.SupplierRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SupplierRepository supplierRepository;

	public ArrayList<Product> getProduct() {
		return productRepository.findAll();
	}

	public List<Supplier> getSuppliers(int id) {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		 List<Integer> suppliersId = productRepository.getSuppliers(id);
		 for(Integer supplierId: suppliersId) {
			 Optional<Supplier> supplier = supplierRepository.findById(supplierId);
			Supplier valueSupplier = supplier.orElse(null);
			suppliers.add(valueSupplier);
		 }
		 return suppliers;
	}
	

	public void delete(int id) {
		productRepository.deleteById(id);
	}

	public Optional<Product> findById(int code) {
		return productRepository.findById(code);
	}

	public List<Product> getProductByName(String name) {
		return productRepository.getByName(name);
	}

	/*public List<Product> getSup(int id) {
		
		List<Integer> sup = productRepository.getSuppliers(id);
		for (Integer supplierId: suppliersId) {
			 Optional<Supplier> supplier = supplierRepository.findById(supplierId);
			Supplier valueSupplier = supplier.orElse(null);
			suppliers.add(valueSupplier);
		 }
		
	} */

}

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

	public List<Supplier> getSuppliers(int productId) {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		 List<Integer> suppliersId = productRepository.getSuppliers(productId);
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

}

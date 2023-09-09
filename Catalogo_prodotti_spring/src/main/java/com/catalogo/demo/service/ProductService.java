package com.catalogo.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.demo.model.Product;
import com.catalogo.demo.model.Product_supplier;
import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.repository.ProductRepository;
import com.catalogo.demo.repository.ProductSupplierRepository;
import com.catalogo.demo.repository.SupplierRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private ProductSupplierRepository productSupplierRepository;


	public ArrayList<Product> getProduct() {
		return productRepository.findAll();
	}
	
	public ArrayList<Supplier> getSuppliers(int id) {
		ArrayList<Product_supplier> productSupplier = productSupplierRepository.findAllByProduct(id);
		ArrayList<Supplier> supplier = new ArrayList<Supplier>();
		for(Product_supplier ps : productSupplier) {
			supplier.add(ps.getId_supplier());
		}
		return supplier;
	}
	

	public void delete(int id) {
		productRepository.deleteById(id);
	}

	public Product findById(int code) {
		return productRepository.findById(code);
	}

	public List<Product> getProductByName(String name) {
		return productRepository.getByName(name);
	}

	public List<Product> getProductByFornitore(String name) {
		
		return productRepository.getByFornitore(name);
	}

	/*public List<Product> getSup(int id) {
		
		List<Integer> sup = productRepository.getSuppliers(id);
		for (Integer supplierId: suppliersId) {
			 Optional<Supplier> supplier = supplierRepository.findById(supplierId);
			Supplier valueSupplier = supplier.orElse(null);
			suppliers.add(valueSupplier);
		 }
		
	} */
	
	public void save(Product product) {
		int max = 0;
		ArrayList<Product> products = productRepository.findAll();
		for(Product idProduct : products) {
			if(idProduct.getNumber_code() > max) {
				max = idProduct.getNumber_code();
			}	
		}
		max = max+1;
		product.setNumber_code(max);
		productRepository.save(product);
	}

	public void update(Product product) {
		productRepository.save(product);
	}

}

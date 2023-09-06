package com.catalogo.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.catalogo.demo.model.Product;
import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.service.ProductService;
import com.catalogo.demo.service.SupplierService;

@Controller
public class AuthAdministratorController {
	@Autowired 
	ProductService productService;
	
	@Autowired 
	SupplierService supplierService;
	
	  private void updateModel(Model model) {
	        ArrayList<Product> products = productService.getProduct();
	        model.addAttribute("products", products);
	        
	        ArrayList<Supplier> suppliers = supplierService.findAll();
	        model.addAttribute("suppliers", suppliers);
	    }
	
	@RequestMapping("/homeAdministrator")
	public String homeAdministrator(Model model) {
		updateModel(model);
		return "homeAdministrator";
	}
	
	   @RequestMapping(value = "/deleteProduct/{id}") 
		public String deleteProduct(Model model, @PathVariable int id) {
		   productService.delete(id);
		   updateModel(model);
			return "homeAdministrator";
		}
	   
	   @RequestMapping(value = "/deleteSupplier/{id}") 
		public String Supplier(Model model, @PathVariable int id) {
		   supplierService.delete(id);
		   updateModel(model);
			return "homeAdministrator";
		}
	   
	   @RequestMapping(value = "/addProduct") 
		public String addProduct(Model model, @RequestParam("name") String name,
				@RequestParam("description") String description, @RequestParam("price") double price) {
		   Product product = new Product();
		   product.setName(name);
		   product.setDescription(description);
		   product.setPrice(price);
		   productService.save(product);
		   updateModel(model);
			return "homeAdministrator";
		}
	
	   @RequestMapping(value = "/addP") 
		public String newProduct() {
			return "newProduct";
		}
	   
	   @RequestMapping(value = "/addSupplier") 
		public String addSupplier(Model model, @RequestParam("name") String name,
				@RequestParam("surname") String surname, @RequestParam("address") String address, 
				@RequestParam("email") String email) {
		   Supplier supplier = new Supplier();
		   supplier.setName(name);
		   supplier.setSurname(surname);
		   supplier.setAddress(address);
		   supplier.setEmail(email);
		   supplierService.save(supplier);
		   updateModel(model);
			return "homeAdministrator";
		}
	   
	   @RequestMapping(value = "/newSupplier") 
		public String newSupplier() {
			return "newSupplier";
		}
	   
	   @RequestMapping(value = "/updateProductCall") 
		public String updateProductCall(Model model) {
		   Product product = new Product();
		   model.addAttribute("product", product);
			return "updateProduct";
		}
	   
	   @RequestMapping(value = "/updateProduct") 
		public String updateProduct(Model model,@RequestParam("code_number") int code_number, @RequestParam("name") String name, 
				@RequestParam("description") String description, @RequestParam("price") Double price) {
		   Product product = productService.findById(code_number);
		   if(product != null) {
			   product.setName(name);
			   product.setDescription(description);
			   product.setPrice(price);
		   }
		   productService.update(product, code_number);
		   updateModel(model);
		   return "homeAdministrator";
		}
}

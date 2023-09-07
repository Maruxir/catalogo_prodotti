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
import com.catalogo.demo.model.Product_supplier;
import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.service.ProductService;
import com.catalogo.demo.service.ProductSupplierService;
import com.catalogo.demo.service.SupplierService;

@Controller
public class AuthAdministratorController {
	@Autowired 
	ProductService productService;
	
	@Autowired 
	SupplierService supplierService;
	
	@Autowired 
	ProductSupplierService productSupplierService;
	
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
		   Product_supplier productSupplier = productSupplierService.findByProduct(id);
		   if(productSupplier != null)
			   productSupplierService.delete(productSupplier.getId_ps());
		   
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
	   
	   @RequestMapping(value = "/updateProductNameCall") 
		public String updateProductNameCall(Model model) {
		   //Product product = new Product();
		  // model.addAttribute("product", product);
			return "updateProductName";
		}
	   
	   @RequestMapping(value = "/updateProductDescriptionCall") 
		public String updateProductDescriptionCall(Model model) {
		   //Product product = new Product();
		  // model.addAttribute("product", product);
			return "updateProductDescription";
		}
	   
	   @RequestMapping(value = "/updateProductPriceCall") 
		public String updateProductPriceCall(Model model) {
		   //Product product = new Product();
		  // model.addAttribute("product", product);
			return "updateProductPrice";
		}
//	   
//	   @RequestMapping(value = "/updateProduct") 
//		public String updateProduct(Model model,@RequestParam("code_number") int code_number, @RequestParam("name") String name, 
//				@RequestParam("description") String description, @RequestParam("price") Double price) {
//		   Product p = productService.findById(code_number);
//		   Product product = new Product();
//		   if(p != null) {
//				   product.setDescription(description);
//				   product.setName(name);
//				   product.setPrice(price);
//				   product.setNumber_code(p.getNumber_code());
//		   }
//		   productService.update(product);
//		   updateModel(model);
//		   return "homeAdministrator";
//		}
	   
	   @RequestMapping(value = "/updateProductName") 
		public String updateProductName(Model model,@RequestParam("code_number") int code_number, @RequestParam("name") String name) {
		   Product product = productService.findById(code_number);
		   if(product != null) {
				   product.setName(name);
		   }
		   productService.update(product);
		   updateModel(model);
		   return "homeAdministrator";
		}
	   
	   @RequestMapping(value = "/updateProductDescription") 
		public String updateProductDescription(Model model,@RequestParam("code_number") int code_number, @RequestParam("description") String description) {
		   Product product = productService.findById(code_number);
		   if(product != null) {
				   product.setDescription(description);
		   }
		   productService.update(product);
		   updateModel(model);
		   return "homeAdministrator";
		}
	   
	   @RequestMapping(value = "/updateProductPrice") 
		public String updateProductPrice(Model model,@RequestParam("code_number") int code_number, @RequestParam("price") Double price) {
		   Product product = productService.findById(code_number);
		   if(product != null) {
				   product.setPrice(price);
		   }
		   productService.update(product);
		   updateModel(model);
		   return "homeAdministrator";
		}
	   
	
	   @RequestMapping(value = "/updateSupplierAddress") 
		public String updateSupplierAddress(Model model,@RequestParam("id_supplier") int idSupplier, @RequestParam("address") String address) {
		   
		   Supplier supplier = supplierService.findById(idSupplier);
		   if(supplier != null) {
				   supplier.setAddress(address);
		   }
		   supplierService.update(supplier);
		   updateModel(model);
		   return "homeAdministrator";
		}
	   
	   @RequestMapping(value = "/updateSupplierAddressCall") 
		public String updateSupplierAddressCall(Model model) {
		   //Product product = new Product();
		  // model.addAttribute("product", product);
			return "updateSupplierAddress";
		}
	   
	   @RequestMapping(value = "/updateSupplierEmail") 
		public String updateSupplierEmail(Model model,@RequestParam("id_supplier") int idSupplier, @RequestParam("email") String email) {
		   
		   Supplier supplier = supplierService.findById(idSupplier);
		   if(supplier != null) {
				   supplier.setAddress(email);
		   }
		   supplierService.update(supplier);
		   updateModel(model);
		   return "homeAdministrator";
		}
	   
	   @RequestMapping(value = "/updateSupplierEmailCall") 
		public String updateSupplierEmailCall(Model model) {
			return "updateSupplierEmail";
		}
	   
	   @RequestMapping(value = "/addProductSupplier") 
		public String addProductSupplier(Model model, @RequestParam("code_number") int code_number, @RequestParam("emailSupplier") String email) {
		   
		   Product_supplier productSupplier = new Product_supplier();
		   Product product = productService.findById(code_number);
		   Supplier supplier = supplierService.findByEmail(email);
		   
		   if(supplier != null && product != null) {
			   productSupplier.setId_product(product);
			   productSupplier.setId_supplier(supplier);
			   productSupplierService.create(productSupplier);
		   }
		   
		   updateModel(model);
		   return "homeAdministrator";
		}
	   
	   @RequestMapping(value = "/addProductSupplierCall") 
		public String addProductSupplierCall() {
			return "addProductSupplier";
		}
	   
	   
}

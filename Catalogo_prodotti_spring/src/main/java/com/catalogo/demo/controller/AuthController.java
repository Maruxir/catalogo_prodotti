package com.catalogo.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catalogo.demo.model.Product;
import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.service.ProductService;
import com.catalogo.demo.service.SupplierService;

@Controller
public class AuthController {
	@Autowired
		public ProductService productService;
	
	  @GetMapping("/index")
	    public String home(){
	        return "index";
	    }
	  
	   @GetMapping("/login")
	    public String login(){
	        return "login";
	    }
	   
	   @RequestMapping(value = "/products") 
		public String Products(Model model) {
			ArrayList<Product> product = productService.getProduct();
			model.addAttribute("product" , product);
			
			return "home";
		}
	   
	   @RequestMapping(value = "/suppliers/{id}") 
		public String Suppliers(Model model , @PathVariable int id) {
		  // Product product = productService.findById(id);
			List<Supplier> supplier = productService.getSuppliers(id);
			model.addAttribute("supplier" , supplier);
			
			return "products";
		}
	   
	   @RequestMapping(value = "/deleteProduct/{id}") 
		public String deleteProduct(Model model, @PathVariable int id) {
		   productService.delete(id);
		   return "home";
		}
	   
	   @RequestMapping(value = "/cerca/{name}") 
		public String cerca(Model model , @PathVariable String name) {
			List<Product> product = productService.getProductByName(name);
			model.addAttribute("product" , product);
			
			return "home";
		}
	  
}

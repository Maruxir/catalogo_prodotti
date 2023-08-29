package com.catalogo.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catalogo.demo.model.Product;
import com.catalogo.demo.service.ProductService;

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
	  
}

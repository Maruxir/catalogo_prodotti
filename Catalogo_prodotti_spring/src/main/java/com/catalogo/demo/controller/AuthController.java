package com.catalogo.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.catalogo.demo.model.Product;
import com.catalogo.demo.model.Review;
import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.service.ProductService;
import com.catalogo.demo.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AuthController {
	@Autowired
		public ProductService productService;
	
	@Autowired
	public ReviewService reviewService;
	
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
	   
	   @RequestMapping(value = "/cercaNome/{name}") 
		public String cercaNome(Model model , @PathVariable String name) {
			List<Product> product = productService.getProductByName(name);
			model.addAttribute("product" , product);
			
			return "home";
		}
	   
	   @RequestMapping(value = "/cercaFornitore/{name}") 
	 		public String cercaFornitore(Model model , @PathVariable String name) {
	 			List<Product> product = productService.getProductByFornitore(name);
	 			model.addAttribute("product" , product);
	 			
	 			return "home";
	 		}
	   
	 /*  @RequestMapping(value = "/addReviews/{review}") 
		public String addReview(Model model , @PathVariable Review review) {
		   	reviewService.create(review);
			/*List<Product> product = productService.getProductByFornitore(name);
			model.addAttribute("product" , product);
			
			return "home";
			return "home";
		} */
	   

		  @RequestMapping(value = "/creater") 
				public void create(@RequestParam("review") String stringReview) {
			  try {
			        ObjectMapper objectMapper = new ObjectMapper();
			        Review review = objectMapper.readValue(stringReview, Review.class);
			        reviewService.create(review);
			   } catch (Exception e) {
			        // Gestisci eventuali eccezioni di parsing JSON qui
			    }
			  }
	   
	   @RequestMapping(value = "/addReview") 
		public String addReview(Model model) {
	   return "newComment"; }
	   
	   
	  
}

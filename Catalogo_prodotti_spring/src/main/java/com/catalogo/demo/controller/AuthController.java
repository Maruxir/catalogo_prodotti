package com.catalogo.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catalogo.demo.model.Customer;
import com.catalogo.demo.model.Product;
import com.catalogo.demo.model.Review;
import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.service.CustomerService;
import com.catalogo.demo.service.ProductService;
import com.catalogo.demo.service.ReviewService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
	@Autowired
		public ProductService productService;
	
	@Autowired
	public CustomerService customerService;
	
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
	   
	   
	  @RequestMapping(value = "/addReview") 
		public String addReview(Model model) {
		   Review review = new Review();
		    model.addAttribute("review", review);
	   return "newComment"; }
	   
	   	
	   @RequestMapping("/createReview")
	   public String create(@RequestParam("email") String email, @RequestParam("testoCommento") String testoCommento, @RequestParam("prodotto") int idProdotto) {
		   Review review = new Review();
		   Customer customer = customerService.findByEmail(email);
	        review.setCustomer(customer);
	        review.setComment(testoCommento);
	        Product product = productService.findById(idProdotto);
	        review.setProduct(product);
	        reviewService.create(review);
		   return "index";
	   }
	   
	  
}

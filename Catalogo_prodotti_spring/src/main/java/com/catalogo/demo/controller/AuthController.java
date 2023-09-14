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
import com.catalogo.demo.model.Product_supplier;
import com.catalogo.demo.model.Review;
import com.catalogo.demo.model.Supplier;
import com.catalogo.demo.response.EmailReviewResponse;
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
	
	 private void updateModel(Model model) {
	        ArrayList<Product> products = productService.getProduct();
	        model.addAttribute("product", products);
	    }
	
	  @GetMapping("/home")
	    public String home(){
	        return "home";
	    }
	  
	   @GetMapping("/login")
	    public String login(){
	        return "login";
	    } 
	   
	  @RequestMapping(value = "/homeCustomer") 
		public String Products(Model model) {
			updateModel(model);
			return "homeCustomer";
		}
	   
	   @RequestMapping(value = "/details/{id}/{email}") 
		public String Suppliers(Model model , @PathVariable int id, @PathVariable String email) {
		  // Product product = productService.findById(id);
			List<Supplier> supplier = productService.getSuppliers(id);
			model.addAttribute("supplier" , supplier);

			List<Review> reviews = reviewService.getReviewsByProduct(id);
			model.addAttribute("review", reviews);
			
			Customer customer = customerService.findByEmail(email);
			Review reviewByCustomer = reviewService.findByCustomerProduct(customer.getId(), id);
			model.addAttribute("reviewByCustomer", reviewByCustomer);
			
			return "detailsCustomer";
		}
	    
	   @RequestMapping(value = "/cercaNome/{name}") 
		public String cercaNome(Model model , @PathVariable String name) {
			List<Product> product = productService.getProductByName(name);
			model.addAttribute("product" , product);
			
			return "homeCustomer";
		}
	   
	   @RequestMapping(value = "/cercaFornitore/{name}") 
	 		public String cercaFornitore(Model model , @PathVariable String name) {
	 			List<Product> product = productService.getProductByFornitore(name);
	 			model.addAttribute("product" , product);
	 			
	 			return "homeCustomer";
	 		}
	   
	   
	  @RequestMapping(value = "/addReview") 
		public String addReview(Model model) {
		   Review review = new Review();
		    model.addAttribute("review", review);
	   return "newComment"; }
	   
	   	
	  @RequestMapping("/createReview")
	   public String create(Model model,@RequestParam("email") String email, @RequestParam("testoCommento") String testoCommento, @RequestParam("prodotto") int idProdotto) {
		   Review review = new Review();
		   Customer customer = customerService.findByEmail(email);
	        review.setCustomer(customer);
	        review.setComment(testoCommento);
	        Product product = productService.findById(idProdotto);
	        review.setProduct(product);
	        reviewService.create(review);
	    	updateModel(model);
			return "homeCustomer";
	  }
	   
	   @RequestMapping("/updateReview")
	   public String update(Model model , @RequestParam("testoCommento") String testoCommento, 
			   @RequestParam("idCommento") int idCommento) {
		   Review review = reviewService.getById(idCommento);
	        review.setComment(testoCommento);
	        reviewService.update(review);
	    	updateModel(model);
			return "homeCustomer";
	   } 
	   
	   @RequestMapping("/updateReviewPage")
	   public String updatePage(Model model) {
		   Review review = new Review();
		    model.addAttribute("review", review);
		   return "updateComment";
	   }
	   
	   
}

package com.catalogo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.demo.model.Review;
import com.catalogo.demo.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	 ReviewService reviewService;

	 /* @RequestMapping(value = "/creater/{review}", method = RequestMethod.POST) 
			public void create(@PathVariable Review review) {
		  		 reviewService.create(review);
			   	
				} */
}

package com.catalogo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.demo.model.Review;
import com.catalogo.demo.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired 
	ReviewRepository reviewRepository;
	
	
	public void create(Review review) {
		reviewRepository.save(review);
	}
}

package com.catalogo.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.demo.model.Review;
import com.catalogo.demo.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;

/*	public void create(Review review) {
		reviewRepository.save(review);
	} */

	public void create(Review review) {
		int idCustomer= review.getCustomer().getId();
		int idProduct=review.getProduct().getNumber_code();
		Review r = reviewRepository.findCustomerProduct(idCustomer, idProduct);
		if(r == null) {
		ArrayList<Review> reviews = reviewRepository.findAll();
		int max = 0;
		for(Review idReview : reviews) {
			if(idReview.getReview_id() > max) {
				max = idReview.getReview_id();
			}
		}
		review.setReview_id(max+1);
		reviewRepository.save(review); }
	}



	
	
}

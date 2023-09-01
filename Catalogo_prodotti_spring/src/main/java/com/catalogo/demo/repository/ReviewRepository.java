package com.catalogo.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.demo.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer>{

	Review save(Review review);
}

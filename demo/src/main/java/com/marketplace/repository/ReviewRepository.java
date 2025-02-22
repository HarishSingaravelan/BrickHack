package com.marketplace.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByRevieweeId(String revieweeId);
    List<Review> findByReviewerId(String reviewerId);
}

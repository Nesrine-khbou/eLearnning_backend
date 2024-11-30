package com.backend.application.services;

import com.backend.application.entities.Review;
import com.backend.application.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Retrieve all Reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Retrieve Review by ID
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    // Save or Update Review
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    // Delete Review by ID
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}

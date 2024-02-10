package com.jobApplication.service;

import java.util.List;

import com.jobApplication.model.Review;

public interface ReviewService {
	List<Review> getAllReviews();

	List<Review> getAllReviewsByCompanyId(long companyId);

	Review addReview(long companyId, Review review);

	Review getReviewByReviewIdAndCompanyId(Long companyId, Long reviewId);
	
	Review updateReview(Long companyIdLong ,Long reviewIdLong , Review review);
	
	boolean deleteReviewByCompanyIdAndReviewId(Long companyId, Long reviewId);
}

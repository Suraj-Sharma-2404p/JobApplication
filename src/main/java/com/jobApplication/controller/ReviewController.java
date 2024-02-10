package com.jobApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobApplication.model.Review;
import com.jobApplication.service.ReviewService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/companies")
public class ReviewController {

	private final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews() {
		return new ResponseEntity<List<Review>>(reviewService.getAllReviews(), HttpStatus.OK);
	}

	@GetMapping("/{companyId}/reviews")
	public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable Long companyId) {
		return new ResponseEntity<List<Review>>(reviewService.getAllReviewsByCompanyId(companyId), HttpStatus.OK);
	}

	@PostMapping("/{companyId}/addreview")
	public ResponseEntity<Review> addReview(@PathVariable Long companyId, @RequestBody Review reviewToSave) {
		Review savedReview = reviewService.addReview(companyId, reviewToSave);
		return new ResponseEntity<>(savedReview, HttpStatus.OK);

	}

	@GetMapping("/{companyId}/reviews/{reviewId}")
	public ResponseEntity<?> getReviewsByCompanyId(@PathVariable Long companyId, @PathVariable Long reviewId) {
		Review review = reviewService.getReviewByReviewIdAndCompanyId(companyId, reviewId);
		if (review != null) {
			return new ResponseEntity<>(review, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Either reviewId or CompanyId is incorrect!", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{companyId}/reviews/{reviewId}")
	public ResponseEntity<?> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
			@RequestBody Review review) {
		Review updatedReview = reviewService.updateReview(companyId, reviewId, review);
		if (updatedReview != null) {
			return new ResponseEntity<>(updatedReview, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Either reviewId or CompanyId does not exist!", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{companyId}/reviews/{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
			boolean isDeleted = reviewService.deleteReviewByCompanyIdAndReviewId(companyId, reviewId);
			if(isDeleted) {
				return new ResponseEntity<>("Review Deleted successfully!",HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Either reviewId or CompanyId does not exist!", HttpStatus.NOT_FOUND);
			}
	}
}

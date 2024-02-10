package com.jobApplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jobApplication.model.Company;
import com.jobApplication.model.Review;
import com.jobApplication.repo.CompanyRepo;
import com.jobApplication.repo.ReviewRepo;
import com.jobApplication.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepo reviewRepo;
	private final CompanyRepo companyRepo;
	Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

	public ReviewServiceImpl(ReviewRepo reviewRepo, CompanyRepo companyRepo) {
		super();
		this.reviewRepo = reviewRepo;
		this.companyRepo = companyRepo;
	}

	@Override
	public List<Review> getAllReviewsByCompanyId(long companyId) {
		List<Review> reviews = reviewRepo.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public Review addReview(long companyId, Review review) {
		Company optionalCompany = companyRepo.findById(companyId).get();
		if (optionalCompany != null) {
			review.setCompany(optionalCompany);
			reviewRepo.save(review);
		}
		return review;
	}

	@Override
	public List<Review> getAllReviews() {
		List<Review> list = reviewRepo.findAll();
		return list;
	}

	@Override
	public Review getReviewByReviewIdAndCompanyId(Long companyId, Long reviewId) {
		List<Review> reviews = reviewRepo.findByCompanyId(companyId);
		return reviews.stream().filter(review -> review.getReviewId() == reviewId).findFirst().orElse(null);
	}

	@Override
	public Review updateReview(Long companyIdLong, Long reviewIdLong, Review review) {
		if (companyRepo.findById(companyIdLong) != null) {
			review.setCompany(companyRepo.findById(companyIdLong).get());
			review.setReviewId(reviewIdLong);
			reviewRepo.save(review);
		} else {
			return null;
		}
		return review;
	}

	@Override
	public boolean deleteReviewByCompanyIdAndReviewId(Long companyId, Long reviewId) {
		Review review = getReviewByReviewIdAndCompanyId(companyId, reviewId);
		if (review != null) {
			reviewRepo.delete(review);
			return true;
		}
		return false;
		
	}

}

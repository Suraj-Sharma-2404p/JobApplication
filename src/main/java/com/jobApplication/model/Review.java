package com.jobApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;
	private String title;
	private String description;
	private double rating;

	@ManyToOne
	@JsonIgnore
	private Company company;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(long reviewId, String title, String description, double rating) {
		super();
		this.reviewId = reviewId;
		this.title = title;
		this.description = description;
		this.rating = rating;
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", title=" + title + ", description=" + description + ", rating="
				+ rating + "]";
	}

}

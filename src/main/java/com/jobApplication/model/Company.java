package com.jobApplication.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "Company name can not be empty")
	private String name;
	@NotBlank(message = "Company Description is required")
	private String description;

	@OneToMany(mappedBy = "company")
	@JsonIgnore
	List<Job> jobs = new ArrayList<>();

	@OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
	List<Review> reviews = new ArrayList<>();

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(long id, String name, String description, List<Job> jobs, List<Review> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", description=" + description + ", jobs=" + jobs + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}

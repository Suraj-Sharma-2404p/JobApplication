package com.jobApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobApplication.model.Company;
import com.jobApplication.model.Review;
import com.jobApplication.service.CompanyService;
import com.jobApplication.service.ReviewService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("companies")
public class CompanyController {

	private final CompanyService companyService;
	private final ReviewService reviewService;

	public CompanyController(CompanyService companyService,ReviewService reviewService) {
		super();
		this.companyService = companyService;
		this.reviewService = reviewService;
	}

	@GetMapping
	private ResponseEntity<List<Company>> getAllCompanies() {
		List<Company> companies = companyService.getAllCompanies();
		for(Company company : companies) {
			List<Review> reviews = reviewService.getAllReviewsByCompanyId(company.getId());
			if (reviews != null) {
				company.setReviews(reviews);
			}else {
				company.setReviews(null);
			}
		}
		return new ResponseEntity<>(companies, HttpStatus.OK);
	}

	@GetMapping("/{companyId}")
	private ResponseEntity<Company> getCompanyById(@PathVariable long companyId) {
		Company company = companyService.getCompanyByCompanyId(companyId);
		return new ResponseEntity<>(company, HttpStatus.OK);
	}

	@PostMapping
	private ResponseEntity<Company> saveCompany(@Valid @RequestBody Company company) throws MethodArgumentNotValidException {
		Company savedCompany = companyService.saveCompany(company);
		return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
	}

	@PutMapping("/{companyId}")
	private ResponseEntity<Company> updateCompa(@PathVariable long companyId, @RequestBody Company company) {
		company.setId(companyId);
		Company updatedCompany = companyService.updateCompany(company);
		return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
	}
}

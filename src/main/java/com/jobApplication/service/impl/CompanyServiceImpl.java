package com.jobApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobApplication.model.Company;
import com.jobApplication.repo.CompanyRepo;
import com.jobApplication.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepo companyRepo;

	public CompanyServiceImpl(CompanyRepo companyRepo) {
		super();
		this.companyRepo = companyRepo;
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepo.findAll();
	}

	@Override
	public Company updateCompany(Company company) {
		Company existingCompany = companyRepo.findById(company.getId()).get();
		if (existingCompany != null) {
			existingCompany.setName(company.getName());
			existingCompany.setDescription(company.getDescription());
			Company updaetdCompany = companyRepo.save(existingCompany);
			return updaetdCompany;
		} else {
			return null;
		}
	}

	@Override
	public Company saveCompany(Company company) {
		Company savedCompany = companyRepo.save(company);
		return savedCompany;
	}

	@Override
	public Company getCompanyByCompanyId(long companyId) {
		Company company = companyRepo.findById(companyId).get();
		return company;
	}

}

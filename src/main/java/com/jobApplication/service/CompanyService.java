package com.jobApplication.service;

import java.util.List;

import com.jobApplication.model.Company;


public interface CompanyService {
	
	List<Company> getAllCompanies();
	Company saveCompany(Company company);
	Company updateCompany(Company company);
	Company getCompanyByCompanyId(long companyId);

}

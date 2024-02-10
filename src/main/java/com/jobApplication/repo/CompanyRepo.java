package com.jobApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobApplication.model.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {

}

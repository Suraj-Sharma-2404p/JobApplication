package com.jobApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobApplication.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}

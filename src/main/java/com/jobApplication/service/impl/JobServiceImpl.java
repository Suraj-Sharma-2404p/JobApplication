package com.jobApplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jobApplication.model.Company;
import com.jobApplication.model.Job;
import com.jobApplication.repo.CompanyRepo;
import com.jobApplication.repo.JobRepository;
import com.jobApplication.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	private final JobRepository jobRepository;
	private final CompanyRepo companyRepo;

	public JobServiceImpl(JobRepository jobRepository, CompanyRepo companyRepo) {
		super();
		this.jobRepository = jobRepository;
		this.companyRepo = companyRepo;
	}

	@Override
	public List<Job> getCompanyByJobId(long jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> getAll() {
		return jobRepository.findAll();
	}

	@Override
	public Job getJobByJobId(long jobId) {
		Optional<Job> optionalJob = jobRepository.findById(jobId);
		return optionalJob.get();
	}

	@Override
	public Job saveJob(Job job) {
		Company company = companyRepo.findById(job.getCompany().getId()).get();
		job.setCompany(company);
		return jobRepository.save(job);
	}

	@Override
	public Job updateJob(Job job) {
		Job existingJob = jobRepository.findById(job.getId()).get();
		existingJob.setTitle(job.getTitle());
		existingJob.setDescription(job.getDescription());
		existingJob.setMinSalary(job.getMinSalary());
		existingJob.setMaxSalary(job.getMaxSalary());
		existingJob.setLocation(job.getLocation());
		Company company = companyRepo.findById(job.getCompany().getId()).get();
		existingJob.setCompany(company);
		Job updatedJob = jobRepository.save(existingJob);
		return updatedJob;
	}

	@Override
	public void deleteJobByJobId(long jobId) {
		jobRepository.deleteById(jobId);

	}

}

package com.jobApplication.service;

import java.util.List;

import com.jobApplication.model.Job;

public interface JobService {
	List<Job> getAll();
	Job getJobByJobId(long jobId);
	Job saveJob(Job job);
	Job updateJob(Job job);
	void deleteJobByJobId(long jobId);
	List<Job> getCompanyByJobId(long jobId);
}

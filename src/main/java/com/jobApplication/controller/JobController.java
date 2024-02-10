package com.jobApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobApplication.model.Job;
import com.jobApplication.service.JobService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
@RequestMapping("/job")
public class JobController {

	private final JobService jobService;

	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping("/all")
	private ResponseEntity<List<Job>> getAllJobs() {
		List<Job> jobs = jobService.getAll();
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Job> saveJob(@Valid @RequestBody Job job) {
		Job savedJob = jobService.saveJob(job);
		return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
	}

	@GetMapping("/{jobId}")
	public ResponseEntity<Job> getUserById(@PathVariable Long jobId) {
		Job job = jobService.getJobByJobId(jobId);
		return new ResponseEntity<>(job, HttpStatus.OK);
	}

	@PutMapping("/{jobId}")
	public ResponseEntity<Job> updateUser(@PathVariable Long jobId, @RequestBody Job job) {
		job.setId(jobId);
		Job updatedJob = jobService.updateJob(job);
		return new ResponseEntity<>(updatedJob, HttpStatus.OK);
	}

}

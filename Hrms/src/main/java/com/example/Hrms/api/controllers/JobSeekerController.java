package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.JobSeekerService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;
	
	public JobSeekerController() {
		
	}
	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return jobSeekerService.getAll();
	}

	@PostMapping("/add")
	public Result register(@RequestBody JobSeeker jobSeeker) {
		return jobSeekerService.register(jobSeeker);
	}
}

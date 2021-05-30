package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.JobService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	private JobService jobService;
	
	
	@Autowired
	  public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping("/getall")
	    public DataResult<List<Job>> getAll() {
	        return this.jobService.getAll();
	    }

	    @PostMapping("/add")
	    public Result add(@RequestBody Job job) {
	        return this.jobService.add(job);
	    }

	    @GetMapping("/findAllByActiveTrue")
	    public DataResult<List<Job>> findAllByActiveTrue() {
	        return this.jobService.findAllByActiveTrue();
	    }

	    @GetMapping("/findAllByEmployerIdAndActiveTrue")
	    public DataResult<List<Job>> findAllByEmployerIdAndActiveTrue(@RequestParam int employerId) {
	        return this.jobService.findAllByEmployerIdAndActiveTrue(employerId);
	    }

	    @GetMapping("/findAllByActiveTrueOrderByCreatedTimeDesc")
	    public DataResult<List<Job>> findAllByActiveTrueOrderByCreatedTimeDesc() {
	        return this.jobService.findAllByActiveTrueOrderByCreatedTimeDesc();

	    }

	    @PostMapping("/setValue")
	    public Result setValue(int id, boolean value) {
	        return this.jobService.setValue(id, value);
	    }
	}

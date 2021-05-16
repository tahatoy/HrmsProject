package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.JobPositionService;
import com.example.Hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {

	private JobPositionService jobPositionService;
	
	public JobPositionController() {
		
	}

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public List<JobPosition> getAll(){
		return this.jobPositionService.getAll();
	}
	
	
}

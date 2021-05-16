package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.EmployerService;
import com.example.Hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

	private EmployerService employerService;
	
	public EmployerController() {
		
	}
	
	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public List<Employer> getAll(){
		return this.employerService.getAll();
	}
	
}

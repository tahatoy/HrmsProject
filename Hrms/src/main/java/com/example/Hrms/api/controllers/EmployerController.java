package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.EmployerService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.Employer;
import com.example.Hrms.entities.dtos.EmployerRegisterDto;

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
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/register")
	public Result register(@RequestBody EmployerRegisterDto employer) {
		return this.employerService.register(employer);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Employer employer, int id) {
		return this.employerService.update(employer, id);
	}
	
	
}

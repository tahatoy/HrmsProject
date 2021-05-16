package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.HrmsValidatorService;
import com.example.Hrms.entities.concretes.HrmsValidator;

@RestController
@RequestMapping("/api/hrmsvalidators")
public class HrmsValidatorController {

	private HrmsValidatorService hrmsValidatorService;

	public HrmsValidatorController() {
		
	}
	
	@Autowired
	public HrmsValidatorController(HrmsValidatorService hrmsValidatorService) {
		super();
		this.hrmsValidatorService = hrmsValidatorService;
	}
	
	@GetMapping("/getall")
	public List<HrmsValidator> getAll(){
		return this.hrmsValidatorService.getAll();
	}
	
	
}

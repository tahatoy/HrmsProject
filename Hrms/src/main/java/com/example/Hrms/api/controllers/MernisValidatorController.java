package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.MernisValidatorService;
import com.example.Hrms.entities.concretes.MernisValidator;


@RestController
@RequestMapping("api/mernisvalidators")
public class MernisValidatorController {
	
	private MernisValidatorService mernisValidatorService;
	

	@Autowired
	public MernisValidatorController(MernisValidatorService mernisValidatorService) {
		super();
		this.mernisValidatorService = mernisValidatorService;
	}
	
	@GetMapping("/getall")
	public List<MernisValidator> getAll(){
		return this.mernisValidatorService.getAll();
	}
	
	
	

}

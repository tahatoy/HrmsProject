package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.EmailValidatorService;
import com.example.Hrms.entities.concretes.EmailValidator;

@RestController
@RequestMapping("/api/emailvalidators")
public class EmailValidatorController {

	private EmailValidatorService emailValidatorService;

	public EmailValidatorController() {
		
	}

	@Autowired
	public EmailValidatorController(EmailValidatorService emailValidatorService) {
		super();
		this.emailValidatorService = emailValidatorService;
	}
	
	@GetMapping("/getall")
	public List<EmailValidator> getAll(){
		return this.emailValidatorService.getAll();
	}
	
	
}

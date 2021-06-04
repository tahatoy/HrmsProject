package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.SchoolService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.School;
import com.example.Hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
	
	private SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@GetMapping("/getallorderbyenddatedesc")
	public DataResult<List<School>> getAllOrderByEndDateDesc() {
		return this.schoolService.getAllOrderByEndDateDesc();
	}
	
	@GetMapping("/getbyenddateisnull")
	public DataResult<List<School>> getByEndDateIsNull(){
		return this.schoolService.getByEndDateIsNull();
	}
	
	@GetMapping("/getbyenddateisnotnullorderbyenddatedesc")
	public DataResult<List<School>>  getByEndDateIsNotNullOrderByEndDateDesc() {
		return (this.schoolService.getByEndDateIsNotNullOrderByEndDateDesc());
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	

}

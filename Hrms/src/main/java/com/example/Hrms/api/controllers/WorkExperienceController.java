package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.WorkExperienceService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/workexperiences")
public class WorkExperienceController {

private WorkExperienceService workExperienceService;
	
	@Autowired
	public WorkExperienceController(WorkExperienceService workExperienceService) {
		this.workExperienceService = workExperienceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkExperience>> getAll() {
		return this.workExperienceService.getAll();
	}
	/*
	@GetMapping("/getallorderbyenddatedesc")
	public DataResult<List<WorkExperience>> getAllOrderByEndDateDesc() {
		return this.workExperienceService.getAllOrderByEndDateDesc();
	}
	
	@GetMapping("/getbyenddateisnull")
	public DataResult<List<WorkExperience>> getByEndDateIsNull() {
		return this.workExperienceService.getByEndDateIsNull();
	}
	
	@GetMapping("/getbyenddateisnotnullorderbyenddatedesc")
	public DataResult<List<WorkExperience>> getByEndDateIsNotNullOrderByEndDateDesc() {
		return this.workExperienceService.getByEndDateIsNotNullOrderByEndDateDesc();
	}
	*/
	@PostMapping("/add")
	public Result add( @RequestBody WorkExperience workExperience) {
		return this.workExperienceService.add(workExperience);
	}
	
	@GetMapping("/getByCurriculumVitae_IdOrderByEndDateDesc")
	public DataResult<List<WorkExperience>> getByCurriculumVitae_IdOrderByEndDateDesc(int curriculumVitaeId){
		return this.workExperienceService.getByCurriculumVitae_CurriculumVitaeIdOrderByEndDateDesc(curriculumVitaeId);
	}
}

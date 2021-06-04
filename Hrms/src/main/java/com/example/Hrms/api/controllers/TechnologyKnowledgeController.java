package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.TechnologyKnowledgeService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.TechnologyKnowledge;

@RestController
@RequestMapping("/api/technologyknowledges")
public class TechnologyKnowledgeController {

	private TechnologyKnowledgeService technologyKnowledgeService;

	@Autowired
	public TechnologyKnowledgeController(TechnologyKnowledgeService technologyKnowledgeService) {
		super();
		this.technologyKnowledgeService = technologyKnowledgeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<TechnologyKnowledge>> getAll() {
		return this.technologyKnowledgeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody TechnologyKnowledge technologyKnowledge) {
		return this.technologyKnowledgeService.add(technologyKnowledge);
	}
	
	
}

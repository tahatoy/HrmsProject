package com.example.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hrms.business.abstracts.SystemUserService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/systemusers")
public class SystemUserController {

	private SystemUserService systemUserService;
	
	
	
	@Autowired
	public SystemUserController(SystemUserService systemUserService) {
		super();
		this.systemUserService = systemUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemUser>> getAll(){
		return this.systemUserService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemUser systemUser) {
		return systemUserService.add(systemUser);
		 
	}
	
}

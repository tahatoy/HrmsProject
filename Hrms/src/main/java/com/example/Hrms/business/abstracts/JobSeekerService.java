package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	

	DataResult<List<JobSeeker>> getAll();
	Result register(JobSeeker jobSeeker);
	
	
	

	
}

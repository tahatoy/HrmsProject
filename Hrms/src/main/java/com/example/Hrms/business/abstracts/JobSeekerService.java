package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.JobSeeker;
import com.example.Hrms.entities.dtos.JobSeekerRegisterDto;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();
	Result register(JobSeekerRegisterDto jobSeekerDto);
	Result update(JobSeeker jobSeeker,int id);
	DataResult<JobSeeker> getById(int id);
	Result emailVerification(JobSeeker jobSeeker, String activationCode);
	
	
	

	
}

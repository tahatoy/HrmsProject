package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.JobSeekerService;
import com.example.Hrms.dataAccess.abstracts.JobSeekerDao;
import com.example.Hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}


	@Override
	public List<JobSeeker> getAll() {
		
		return this.jobSeekerDao.findAll();
	}

}

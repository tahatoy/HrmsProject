package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	List<JobSeeker> getAll();
}

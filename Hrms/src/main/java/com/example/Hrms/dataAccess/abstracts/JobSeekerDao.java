package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	boolean existsByNationalId(String nationalId);
	boolean existsByEmail(String email);
}


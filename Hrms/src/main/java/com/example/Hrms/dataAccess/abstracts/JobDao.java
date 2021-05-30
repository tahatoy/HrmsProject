package com.example.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer> {
	
	List<Job> findAllByActiveTrue();
    List<Job> findAllByEmployer_IdAndActiveTrue(int employerId);
    List<Job> findAllByActiveTrueOrderByCreatedTimeDesc();
    Job findByIdAndActiveTrue(int id);
	
}

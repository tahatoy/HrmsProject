package com.example.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.Job;
import com.example.Hrms.entities.concretes.School;
import com.example.Hrms.entities.concretes.WorkExperience;

public interface SchoolDao extends JpaRepository<School, Integer> { 
	List<School> getByCurriculumVitae_CurriculumVitaeIdOrderByEndDateDesc(int curriculumVitaeId);
	/*
	List<School> findAllByOrderByEndDateDesc();
	List<School> findByEndDateIsNull();
	List<School> findByEndDateIsNotNullOrderByEndDateDesc();
	*/
}

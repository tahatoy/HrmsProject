package com.example.Hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
	List<WorkExperience> getByCurriculumVitae_CurriculumVitaeIdOrderByEndDateDesc(int curriculumVitaeId);
}

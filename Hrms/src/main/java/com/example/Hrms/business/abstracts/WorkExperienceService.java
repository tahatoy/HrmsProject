package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.WorkExperience;

public interface WorkExperienceService {
	DataResult<List<WorkExperience>> getAll();
	DataResult<WorkExperience> get(int id);
	Result add(WorkExperience workExperience);
	DataResult<List<WorkExperience>> getByCurriculumVitae_CurriculumVitaeIdOrderByEndDateDesc(int curriculumVitaeId);
	
}

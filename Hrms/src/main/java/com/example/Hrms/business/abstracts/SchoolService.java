package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.School;
import com.example.Hrms.entities.concretes.WorkExperience;

public interface SchoolService {
	DataResult<List<School>> getAll();
	DataResult<School> get(int id);
	Result add(School school);
	DataResult<List<School>> getByCurriculumVitae_CurriculumVitaeIdOrderByEndDateDesc(int curriculumVitaeId);
	
/*	
	DataResult<List<School>> getAllOrderByEndDateDesc();
	DataResult<List<School>> getByEndDateIsNull();
	DataResult<List<School>> getByEndDateIsNotNullOrderByEndDateDesc();
*/
}

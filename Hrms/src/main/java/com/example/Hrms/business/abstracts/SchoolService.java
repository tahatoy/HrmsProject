package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.School;

public interface SchoolService {
	DataResult<List<School>> getAll();
	DataResult<School> get(int id);
	Result add(School school);
	Result delete(int id);
	Result update(School school);
	
	DataResult<List<School>> getAllOrderByEndDateDesc();
	DataResult<List<School>> getByEndDateIsNull();
	DataResult<List<School>> getByEndDateIsNotNullOrderByEndDateDesc();
}

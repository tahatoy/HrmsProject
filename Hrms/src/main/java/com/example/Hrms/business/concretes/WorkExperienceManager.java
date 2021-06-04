package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.WorkExperienceService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessDataResult;
import com.example.Hrms.dataAccess.abstracts.WorkExperienceDao;
import com.example.Hrms.entities.concretes.WorkExperience;
@Service
public class WorkExperienceManager implements WorkExperienceService {

	private WorkExperienceDao workExperienceDao;
	
	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>( this.workExperienceDao.findAll());
	}

	@Override
	public DataResult<WorkExperience> get(int id) {
		return new SuccessDataResult<WorkExperience>( this.workExperienceDao.findById(id).get());
	}

	@Override
	public Result add(WorkExperience schoolDegree) {
		this.workExperienceDao.save(schoolDegree);
		return new SuccessDataResult<WorkExperience>("Work experience added succesfully.");
	}

	@Override
	public Result delete(int id) {
		this.workExperienceDao.deleteById(id);
		return new SuccessDataResult<WorkExperience>("Work experience deleted succesfully.");
	}

	@Override
	public Result update(WorkExperience schoolDegree) {
		this.workExperienceDao.save(schoolDegree);
		return new SuccessDataResult<WorkExperience>("Work experience updated succesfully.");
	}
	
	@Override
	public DataResult<List<WorkExperience>> getAllOrderByEndDateDesc() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAllByOrderByEndDateDesc(), "Work experiences listed and ordered by end date (Desc) succesfully.");
	}

	@Override
	public DataResult<List<WorkExperience>> getByEndDateIsNull() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findByEndDateIsNull(), "Work experiences in progress listed succesfully.");
	}

	@Override
	public DataResult<List<WorkExperience>> getByEndDateIsNotNullOrderByEndDateDesc() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findByEndDateIsNotNullOrderByEndDateDesc(), "Finished work experiences listed and ordered by end date (Desc) succesfully.");
	}
	
}
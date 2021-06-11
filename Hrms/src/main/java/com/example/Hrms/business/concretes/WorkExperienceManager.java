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
	public Result add(WorkExperience workExperience) {
		this.workExperienceDao.save(workExperience);
		return new SuccessDataResult<WorkExperience>("İş deneyimi başarıyla eklendi.");
	}

	@Override
	public DataResult<List<WorkExperience>>getByCurriculumVitae_CurriculumVitaeIdOrderByEndDateDesc(int curriculumVitaeId) {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.getByCurriculumVitae_CurriculumVitaeIdOrderByEndDateDesc(curriculumVitaeId),"Deneyimler tarihe göre sıralandı");
	}

	
}
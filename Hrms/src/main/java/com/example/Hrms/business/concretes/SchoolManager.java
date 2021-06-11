package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.SchoolService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessDataResult;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.SchoolDao;
import com.example.Hrms.entities.concretes.School;
import com.example.Hrms.entities.concretes.WorkExperience;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Okullar başarıyla listelendi");
	}

	@Override
	public DataResult<School> get(int id) {
		return new SuccessDataResult<School>(this.schoolDao.findById(id).get());
	}

	@Override
	public Result add(School school) {
	this.schoolDao.save(school);
	return new SuccessResult("Okul başarıyla eklendi.");
	}

	@Override
	public DataResult<List<School>> getByCurriculumVitae_CurriculumVitaeIdOrderByEndDateDesc(int curriculumVitaeId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getByCurriculumVitae_CurriculumVitaeIdOrderByEndDateDesc(curriculumVitaeId),"Okunan okullar tarihe göre sıralandı");

	}



	
}

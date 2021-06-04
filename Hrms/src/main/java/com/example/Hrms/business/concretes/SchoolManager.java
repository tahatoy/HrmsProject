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
	public Result delete(int id) {
		this.schoolDao.deleteById(id);
		return new SuccessResult("Okul başarıyla silindi");
	}

	@Override
	public Result update(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul başarıyla güncellendi");
	}

	@Override
	public DataResult<List<School>> getAllOrderByEndDateDesc() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByOrderByEndDateDesc(), "Okullar en güncel haliyle sıralandı");
	}

	@Override
	public DataResult<List<School>> getByEndDateIsNull() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findByEndDateIsNull(), "Devam eden okullar başarıyla listelendi");
	}

	@Override
	public DataResult<List<School>> getByEndDateIsNotNullOrderByEndDateDesc() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findByEndDateIsNotNullOrderByEndDateDesc(), "Mezun olunan okullar en güncel haliyle listelendi");
	}

}

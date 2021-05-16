package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.HrmsValidatorService;
import com.example.Hrms.dataAccess.abstracts.HrmsValidatorDao;
import com.example.Hrms.entities.concretes.HrmsValidator;

@Service
public class HrmsValidatorManager implements HrmsValidatorService {

	private HrmsValidatorDao hrmsValidatorDao;
	
	
	public HrmsValidatorManager(HrmsValidatorDao hrmsValidatorDao) {
		super();
		this.hrmsValidatorDao = hrmsValidatorDao;
	}



	@Override
	public List<HrmsValidator> getAll() {
	
		return this.hrmsValidatorDao.findAll();
	}

}

package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.EmployerService;
import com.example.Hrms.dataAccess.abstracts.EmployerDao;
import com.example.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao	empolyerDao;
	
	public EmployerManager(EmployerDao empolyerDao) {
		super();
		this.empolyerDao = empolyerDao;
	}


	@Override
	public List<Employer> getAll() {

		return this.empolyerDao.findAll();
	}

}

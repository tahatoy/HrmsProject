package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.MernisValidatorService;
import com.example.Hrms.dataAccess.abstracts.MernisValidatorDao;
import com.example.Hrms.entities.concretes.MernisValidator;

@Service
public class MernisValidatorManager implements MernisValidatorService {

	private MernisValidatorDao mernisValidatorDao;
	
	

	public MernisValidatorManager(MernisValidatorDao mernisValidatorDao) {
		super();
		this.mernisValidatorDao = mernisValidatorDao;
	}




	@Override
	public List<MernisValidator> getAll() {
			return this.mernisValidatorDao.findAll();
	}

}

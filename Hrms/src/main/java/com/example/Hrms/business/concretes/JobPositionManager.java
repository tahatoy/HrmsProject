package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.JobPositionService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.ErrorResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessDataResult;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.JobPositionDao;
import com.example.Hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
       return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}


	@Override
	public Result add(JobPosition jobPosition) {
		if(this.jobPositionDao.existsByPositionName(jobPosition.getPositionName())==true)
			return new ErrorResult("Bu pozisyon sistemde kayıtlıdır");
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Pozisyon başarıyla sisteme eklendi");
	}



}

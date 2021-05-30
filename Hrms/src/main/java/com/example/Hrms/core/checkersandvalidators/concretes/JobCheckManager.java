package com.example.Hrms.core.checkersandvalidators.concretes;

import com.example.Hrms.core.checkersandvalidators.abstracts.JobCheckService;
import com.example.Hrms.core.utilities.ErrorResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.entities.concretes.Job;

public class JobCheckManager implements JobCheckService {

	@Override
	public Result checkJob(Job job) {
		  if (job.getJobPosition() == null || 
				  job.getDescription().isEmpty() || 
				  job.getCity()==null ||
				  String.valueOf(job.getOpenPositions()).isEmpty() || 
				  job.getPositionExpireDate() == null ||
				  job.getEmployer() == null) {
			  
			  return new ErrorResult("Tüm alanları doldurmak zorunludur"); 
		  }
			 return new SuccessResult();
	
	}
	
}	
	
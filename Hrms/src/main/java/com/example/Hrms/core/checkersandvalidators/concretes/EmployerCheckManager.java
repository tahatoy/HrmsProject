package com.example.Hrms.core.checkersandvalidators.concretes;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.SystemUserService;
import com.example.Hrms.core.checkersandvalidators.abstracts.EmployerCheckService;
import com.example.Hrms.core.utilities.ErrorResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService {

	private SystemUserService systemUserService;
	
	@Override
	public Result checkEmployer(Employer employer) {
		if(this.systemUserService.validateEmployer()) {
			return new SuccessResult();
		}
		return new ErrorResult("Admin tarafından doğrulanmadı");
	}

}

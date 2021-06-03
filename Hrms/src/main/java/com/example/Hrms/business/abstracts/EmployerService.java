package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.Employer;
import com.example.Hrms.entities.dtos.EmployerRegisterDto;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result register(EmployerRegisterDto employerDto);
	Result update(Employer employer,int employerId);
	DataResult<Employer> getById(int id);
	Result confirmBySystemUser(Employer employer);
	Result emailVerification(Employer employer,String activationCode);
}

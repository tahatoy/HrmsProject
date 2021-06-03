package com.example.Hrms.business.concretes;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.ConfirmBySystemUserService;
import com.example.Hrms.entities.concretes.Employer;

@Service
public class ConfirmBySystemUserManager implements ConfirmBySystemUserService{

	@Override
	public boolean isConfirmedBySystemUser(Employer employer) {
		return true;
	}

}

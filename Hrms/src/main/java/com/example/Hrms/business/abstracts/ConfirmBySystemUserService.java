package com.example.Hrms.business.abstracts;

import com.example.Hrms.entities.concretes.Employer;

public interface ConfirmBySystemUserService {
	
	boolean isConfirmedBySystemUser(Employer employer);
}

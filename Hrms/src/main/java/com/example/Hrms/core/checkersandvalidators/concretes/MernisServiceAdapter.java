package com.example.Hrms.core.checkersandvalidators.concretes;


import org.springframework.stereotype.Service;

import com.example.Hrms.core.checkersandvalidators.abstracts.IdentityValidationService;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessResult;

@Service
public class MernisServiceAdapter implements IdentityValidationService{

	@Override
	public Result validate(String nationalId, String firstName, String lastName) {
		
		return new SuccessResult("Mernis doğrulaması başarılı");
	}

}

package com.example.Hrms.core.checkersandvalidators.abstracts;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.Hrms.core.utilities.Result;


public interface IdentityValidationService {
	Result validate(String nationalId, String firstName,String lastName);
	
}

package com.example.Hrms.core.checkersandvalidators.abstracts;

import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.Verification;

public interface VerificationService {
	Result save(Verification code);
	String verifyCode();
}

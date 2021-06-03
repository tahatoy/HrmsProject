package com.example.Hrms.core.checkersandvalidators.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.core.checkersandvalidators.abstracts.VerificationService;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.VerificationDao;
import com.example.Hrms.entities.concretes.Verification;

@Service
public class VerificationManager implements VerificationService {

	private VerificationDao verificationDao;
	
	@Autowired
	public VerificationManager(VerificationDao verificationDao) {
		super();
		this.verificationDao = verificationDao;
	}

	@Override
	public String verifyCode() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		System.out.println("Verify Code- " + verificationCode );
		return verificationCode;
	}
	
	@Override
	public Result save(Verification code) {
		this.verificationDao.save(code);
		return new SuccessResult("Kod kaydedildi");
	}

	
}

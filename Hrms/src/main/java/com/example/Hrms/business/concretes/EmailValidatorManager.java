package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.EmailValidatorService;
import com.example.Hrms.dataAccess.abstracts.EmailValidatorDao;
import com.example.Hrms.entities.concretes.EmailValidator;

@Service
public class EmailValidatorManager implements EmailValidatorService {

	private EmailValidatorDao emailValidatorDao;
	
	
	public EmailValidatorManager(EmailValidatorDao emailValidatorDao) {
		super();
		this.emailValidatorDao = emailValidatorDao;
	}


	@Override
	public List<EmailValidator> getAll() {

		return this.emailValidatorDao.findAll();
	}

}

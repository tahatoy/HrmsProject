package com.example.Hrms.core.checkersandvalidators.concretes;

import org.springframework.stereotype.Service;

import com.example.Hrms.core.checkersandvalidators.abstracts.EmailService;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessResult;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result send(String message) {
		return new SuccessResult("E mail başarıyla gönderildi");
	}

}

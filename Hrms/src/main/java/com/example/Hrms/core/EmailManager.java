package com.example.Hrms.core;

import org.springframework.stereotype.Service;

import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessResult;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result send(String message) {
		return new SuccessResult("E mail başarıyla gönderildi");
	}

}

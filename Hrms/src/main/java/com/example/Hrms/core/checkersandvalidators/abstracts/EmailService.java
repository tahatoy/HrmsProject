package com.example.Hrms.core.checkersandvalidators.abstracts;

import com.example.Hrms.core.utilities.Result;

public interface EmailService {
	Result send(String message);
	
}

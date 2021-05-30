package com.example.Hrms.core.checkersandvalidators.abstracts;

import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.Job;

public interface JobCheckService {
	Result checkJob(Job job);
}

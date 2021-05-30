package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.Job;

public interface JobService {
	  DataResult<List<Job>> getAll();
	  Result add(Job job);
	  DataResult<List<Job>> findAllByActiveTrue();
	  DataResult<List<Job>> findAllByEmployerIdAndActiveTrue(int employerId);
	  DataResult<List<Job>> findAllByActiveTrueOrderByCreatedTimeDesc();
	  Result setValue(int id, boolean value);
}

package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.SystemUser;

public interface SystemUserService {
	DataResult<List<SystemUser>> getAll();
	Result add(SystemUser systemUser);
	boolean validateEmployer();
}

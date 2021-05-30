package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.entities.concretes.SystemUser;

public interface SystemUserService {
	List<SystemUser> getAll();
	boolean validateEmployer();
}

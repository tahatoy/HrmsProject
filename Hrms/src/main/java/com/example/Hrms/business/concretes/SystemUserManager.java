package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.SystemUserService;
import com.example.Hrms.dataAccess.abstracts.SystemUserDao;
import com.example.Hrms.entities.concretes.SystemUser;


@Service
public class SystemUserManager implements SystemUserService{

	private SystemUserDao systemUserDao;
	
	public SystemUserManager(SystemUserDao systemUserDao) {
		super();
		this.systemUserDao = systemUserDao;
	}


	@Override
	public List<SystemUser> getAll() {
		
		return this.systemUserDao.findAll();
	}

}

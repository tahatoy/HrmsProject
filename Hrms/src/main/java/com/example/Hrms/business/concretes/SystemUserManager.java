package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.SystemUserService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.ErrorResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessDataResult;
import com.example.Hrms.core.utilities.SuccessResult;
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
	public DataResult<List<SystemUser>> getAll() {
		return new SuccessDataResult<List<SystemUser>>(this.systemUserDao.findAll());
	}
	
	@Override
	public boolean validateEmployer() {
		return true;
	}


	@Override
	public Result add(SystemUser systemUser) {
		if(this.systemUserDao.existsByEmail(systemUser.getEmail())==true) {
			return new ErrorResult("Bu e postaya sahip kullanıcı sistemde mevcuttur");
		}
		this.systemUserDao.save(systemUser);
		return new SuccessResult("Kullanıcı başarıyla sisteme eklendi");
	}

}

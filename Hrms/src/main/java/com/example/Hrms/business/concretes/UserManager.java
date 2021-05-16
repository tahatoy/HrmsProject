package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.UserService;
import com.example.Hrms.dataAccess.abstracts.UserDao;
import com.example.Hrms.entities.concretes.User;
@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}



	@Override
	public List<User> getAll() {
		
		return this.userDao.findAll();
	}

}

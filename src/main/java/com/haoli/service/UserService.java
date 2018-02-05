package com.haoli.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haoli.dao.AuthDao;
import com.haoli.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean login(Map params) {
//		String password = userDao.login(params);
//		if(password.equals(params.get("password")))return true;
//		else return false;
		if (params.get("accountName").equals("li") && params.get("password").equals("1"))return true;
		else return false;
	}

}

package com.haoli.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haoli.dao.AuthDao;
import com.haoli.dao.UserDao;
import com.haoli.domain.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean login(Map params) {
		User dbUser = userDao.selectUserByLoginName(params);
		if(dbUser.getPassWord().equals((String)params.get("password")))return true;
		else return false;
	}

}

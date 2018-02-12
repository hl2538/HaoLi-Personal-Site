package com.haoli.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.haoli.domain.User;


@Mapper
public interface UserDao {

	public String login(Map params);

	public User selectUserByLoginName(Map params);
	
}

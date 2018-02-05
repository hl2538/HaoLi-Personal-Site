package com.haoli.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

	public String login(Map params);
	
}

package com.haoli.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.haoli.domain.Project;


@Mapper
public interface AuthDao {

	public void addProject(Map project);
	
}

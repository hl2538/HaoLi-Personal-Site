package com.haoli.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.haoli.domain.Project;


@Mapper
public interface AuthDao {

	public void addProject(Map project);

	public void add(Map params);

	public Map list(Map params);

	public void update(Map params);

	public void delete(Long id);
	
}

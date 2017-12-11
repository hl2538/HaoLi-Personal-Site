package com.haoli.dao;


import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApiDao {
	public void add(Map params);

	public Map list(Long id);

	public void update(Map params);

	public void delete(Long id);

	public Integer count(Map params);

	public List<Map> pageList(Map params);
}

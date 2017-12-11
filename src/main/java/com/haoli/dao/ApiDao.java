package com.haoli.dao;


import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.haoli.util.PageResult;

@Mapper
public interface ApiDao {
	public void add(Map params);

	public Map list(Long id);

	public void update(Map params);

	public void delete(Long id);

	public Integer count(Map params);

	public List<Map> pageList(Map params);

	public void addCategory(Map params);

	public void updateCategory(Map params);

	public List<Map> pageListCategory(Map params);

	public void deleteCategory(Long id);

	public Long loadCategoryId(String name);

}

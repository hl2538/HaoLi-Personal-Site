package com.haoli.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haoli.dao.ApiDao;
import com.haoli.util.MapUtil;
import com.haoli.util.PageResult;

import net.sf.json.JSONArray;


@Service
public class ApiService {
	
	@Autowired
	ApiDao apiDao;
	
	public void add(Map params) {
		apiDao.add(params);
	}

	public Map list(Long id) {
		Map apiInfo = apiDao.list(id);
		apiInfo.put("header", JSONArray.fromObject(apiInfo.get("header")));
		apiInfo.put("request", JSONArray.fromObject(apiInfo.get("request")));
		apiInfo.put("response", JSONArray.fromObject(apiInfo.get("response")));
		return apiInfo;
	}

	public void update(Map params) {
		apiDao.update(params);
	}

	public void delete(Long id) {
		apiDao.delete(id);
	}

	public PageResult<Map> pageList(Map params) {
		Integer pageNo = MapUtil.getInteger(params, "pageNo");
		Integer pageSize = MapUtil.getInteger(params, "pageSize");
		if(pageNo != null && pageSize != null) {
			params.put("start", (pageNo - 1) * pageSize);
			params.put("limit", pageSize);
		}
		Integer total = apiDao.count(params);
		List<Map> list = null;
		if(total > 0) {
			list = apiDao.pageList(params);
		} else {
			list = new ArrayList<Map>();
		}
		return new PageResult<Map>(total, list);
	}

	public void addCategory(Map params) {
		apiDao.addCategory(params);
	}

	public void updateCategory(Map params) {
		apiDao.updateCategory(params);
	}

	public PageResult<Map> pageListCategory(Map params) {
		Integer pageNo = MapUtil.getInteger(params, "pageNo");
		Integer pageSize = MapUtil.getInteger(params, "pageSize");
		if(pageNo != null && pageSize != null) {
			params.put("start", (pageNo - 1) * pageSize);
			params.put("limit", pageSize);
		}
		Integer total = apiDao.count(params);
		List<Map> list = null;
		if(total > 0) {
			list = apiDao.pageListCategory(params);
		} else {
			list = new ArrayList<Map>();
		}
		return new PageResult<Map>(total, list);
	}

	public void deleteCategory(Long id) {
		apiDao.deleteCategory(id);
	}


	public Long loadCategoryId(String name) {
		return apiDao.loadCategoryId(name);
	}
}

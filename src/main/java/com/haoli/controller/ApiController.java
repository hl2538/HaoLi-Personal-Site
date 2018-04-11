package com.haoli.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haoli.domain.JsonResponse;
import com.haoli.service.ApiService;
import com.haoli.util.PageResult;

@RestController
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	
	@RequestMapping(path= "api/add", method = {RequestMethod.POST})
	public JsonResponse<String>add(@RequestBody Map params){
		Map cmap = new HashMap();
		if(!params.containsKey("categoryId") || (params.containsKey("categoryId") && params.get("categoryId").equals(""))) {
			String category = (String)params.get("category");
			cmap.put("name", category);
			cmap.put("sysId", (String)params.get("sysId"));
			apiService.addCategory(cmap);
			Long cid = apiService.loadCategoryId((String)cmap.get("name"));
			params.put("categoryId", cid);
		}
		params.put("header", params.get("header").toString());
		params.put("request",params.get("request").toString());
		params.put("response", params.get("response").toString());
		apiService.add(params);
		return JsonResponse.success();
	}
	
	@RequestMapping(path="api/list", method = {RequestMethod.GET})
	public JsonResponse<Map> list(@RequestParam Long id) {
		return new JsonResponse<Map>(apiService.list(id));
	}
	
	@RequestMapping(path = "api/pageList", method = {RequestMethod.POST})
	public JsonResponse<PageResult<Map>> pageList(@RequestBody Map params){
		PageResult<Map> page = apiService.pageList(params);
		return new JsonResponse<PageResult<Map>>(page);
	}
	
	@RequestMapping(path="api/update", method = {RequestMethod.POST})
	public JsonResponse<String> update(@RequestBody Map params){
		params.put("header", params.get("header").toString());
		params.put("request",params.get("request").toString());
		params.put("response", params.get("response").toString());
		apiService.update(params);
		return JsonResponse.success();
	}
	
	@RequestMapping(path="api/delete", method = {RequestMethod.GET})
	public JsonResponse<String> delete(@RequestParam Long id){
		apiService.delete(id);
		return JsonResponse.success();
	}
	
	@RequestMapping(path = "api/category/add", method = {RequestMethod.POST})
	public JsonResponse<String> addCategory(@RequestBody Map params){
		apiService.addCategory(params);
		return JsonResponse.success();
	}
	
	@RequestMapping(path = "api/category/update", method = {RequestMethod.POST})
	public JsonResponse<String> updateCategory(@RequestBody Map params){
		apiService.updateCategory(params);
		return JsonResponse.success();
	}
	
	@RequestMapping(path = "api/category/pageList", method = {RequestMethod.POST})
	public JsonResponse<PageResult<Map>> pageListCategory(@RequestBody Map params){
		PageResult<Map> page = apiService.pageListCategory(params);
		return new JsonResponse<PageResult<Map>>(page);
	}
	
	@RequestMapping(path = "api/category/delete", method = {RequestMethod.GET})
	public JsonResponse<String> deleteCategory(@RequestParam Long id){
		apiService.deleteCategory(id);
		return JsonResponse.success();
	}
}

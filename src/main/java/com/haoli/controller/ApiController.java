package com.haoli.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.haoli.sdk.JsonResponse;
import com.haoli.service.ApiService;
import com.haoli.util.PageResult;

@RestController
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	
	@RequestMapping(path= "api/add", method = {RequestMethod.POST})
	public JsonResponse<String>add(@RequestBody Map params){
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
}

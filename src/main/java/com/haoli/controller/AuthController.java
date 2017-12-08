package com.haoli.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.haoli.sdk.JsonResponse;
import com.haoli.service.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(path = "auth/project/addProject", method = {RequestMethod.GET})
	public JsonResponse<String>addProject(){
		return new JsonResponse<String>(authService.addProject());
	}
	
	
	@RequestMapping(path= "auth/api/add", method = {RequestMethod.POST})
	public JsonResponse<String>add(@RequestBody Map params){
		params.put("header", new JSONArray((ArrayList)params.get("header")).toString());
		params.put("request", new JSONArray((ArrayList)params.get("request")).toString());
		params.put("response", new JSONArray((ArrayList)params.get("response")).toString());
		authService.addApi(params);
		return JsonResponse.success();
	}
	
	@RequestMapping(path="auth/api/list", method = {RequestMethod.POST})
	public JsonResponse<Map> list(@RequestBody Map params) {
		return new JsonResponse<Map>(authService.list(params));
	}
	
	@RequestMapping(path="auth/api/update", method = {RequestMethod.POST})
	public JsonResponse<String> update(@RequestBody Map params){
		params.put("header", new JSONArray((ArrayList)params.get("header")).toString());
		params.put("request", new JSONArray((ArrayList)params.get("request")).toString());
		params.put("response", new JSONArray((ArrayList)params.get("response")).toString());
		authService.update(params);
		return JsonResponse.success();
	}
	
	@RequestMapping(path="auth/api/delete", method = {RequestMethod.GET})
	public JsonResponse<String> delete(@RequestParam Long id){
		authService.delete(id);
		return JsonResponse.success();
	}
	
}
package com.haoli.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.haoli.sdk.JsonResponse;
import com.haoli.service.UserService;

@RestController

public class UserController {

	@Autowired
	private UserService userService;
	
	protected HttpServletResponse response;
	  
	  
	@RequestMapping(path="/user/login", method = {RequestMethod.POST})
	@ResponseBody
	public JsonResponse<Map> login(@RequestBody Map params ){
		boolean flag = userService.login(params);
		Map result = new HashMap();
		result.put("flag", flag);
		return new JsonResponse<Map>(result);
	}

	
}

package com.haoli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
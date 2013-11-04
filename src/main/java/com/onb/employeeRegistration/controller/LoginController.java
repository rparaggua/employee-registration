package com.onb.employeeRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onb.employeeRegistration.service.ERSAccountService;

@Controller
public class LoginController {
	
	@Autowired
	private ERSAccountService ersAccountService;
	
	@RequestMapping(value = "/")
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/login")
	public String getLoginPage() {
		return "login";	
	}
	
	@RequestMapping(value = "/login-failed")
	public String loginFailed() {
		return "login";
	}
	
	@RequestMapping(value = "/logout-success")
	public String logoutSuccess() {
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/denied")
	public String accessDenied() {
		return "redirect:/login";
	}
}

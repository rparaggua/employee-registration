package com.onb.employeeRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onb.employeeRegistration.service.SecurityContextAccessorService;

@Controller
public class LoginController {

//	@Autowired
//	private SecurityContextAccessorService securityContextAccessor;
	
	@RequestMapping(value = "/login")
	public String getLoginPage() {
//		
//		if(securityContextAccessor.isCurrentlyLoggedIn()){
//			return "redirect:/login-success";
//		}
//		else{
//			return "login";
//		}
		return "login";
		
	}
	
	@RequestMapping(value = "/login-failed")
	public String loginFailed(Model model) {
		model.addAttribute("error", "Invalid Username or Password");
		return "login";
	}
	
	@RequestMapping(value = "/login-success")
	public String loginSuccess() {
		return "redirect:/branch";
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

package com.onb.employeeRegistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login-failed", method = RequestMethod.GET)
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

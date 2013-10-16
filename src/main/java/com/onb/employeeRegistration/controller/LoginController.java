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
		model.addAttribute("error", "Invalid username or password");
		return "login";
	}
}

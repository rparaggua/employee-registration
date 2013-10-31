package com.onb.employeeRegistration.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.onb.employeeRegistration.service.ERSAccountService;


public class LoginPageFilter implements Filter {

	@Autowired
	private ERSAccountService ersAccountService;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
	    HttpServletResponse response = (HttpServletResponse) servletResponse;

	    if(request.getUserPrincipal() != null){
	    	response.sendRedirect("/employee-registration"+(String)request.getSession().getAttribute("targetUrl"));
	    }
	    else{
	    	filterChain.doFilter(servletRequest, servletResponse);
	    }
	}

	@Override
	public void destroy() {
	}
}

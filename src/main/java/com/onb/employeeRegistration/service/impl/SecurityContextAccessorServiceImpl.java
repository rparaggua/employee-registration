package com.onb.employeeRegistration.service.impl;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.onb.employeeRegistration.service.SecurityContextAccessorService;

@Service
public class SecurityContextAccessorServiceImpl implements SecurityContextAccessorService{
	
	@Override
	public boolean isCurrentlyLoggedIn() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication instanceof AnonymousAuthenticationToken){
			return true;
		}
		else{
			return false;
		}
	}

}

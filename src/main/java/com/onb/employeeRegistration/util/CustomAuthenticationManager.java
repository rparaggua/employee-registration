package com.onb.employeeRegistration.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.onb.employeeRegistration.domain.Access;
import com.onb.employeeRegistration.domain.ERSAccount;
import com.onb.employeeRegistration.domain.Role;
import com.onb.employeeRegistration.service.ERSAccountService;

public class CustomAuthenticationManager implements AuthenticationManager{

	@Value("${com.onb.employeeregistration.validator.message.invalidUsernameOrPassword}")
	private String errorMessage;
	
	private ShaPasswordEncoder shaPasswordEncoder;
	
	@Autowired
	private ERSAccountService ersAccountService;
	
	@Autowired
	private void setShaPasswordEncoder() {
		this.shaPasswordEncoder = new ShaPasswordEncoder(256);
		this.shaPasswordEncoder.setIterations(1000);
	}
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		ERSAccount ersAccount = ersAccountService.getERSAccountByUsername(authentication.getName());
		
		if(ersAccount == null){
			throw new BadCredentialsException(errorMessage);
		}

		if(shaPasswordEncoder.isPasswordValid(ersAccount.getPassword(), (String) authentication.getCredentials(), ersAccount.getDateCreated()) == false){
			throw new BadCredentialsException(errorMessage);
		}
		else{
			return new UsernamePasswordAuthenticationToken(
					authentication.getName(), 
					authentication.getCredentials(), 
					getAuthorities(ersAccount.getRoles()));
		}
	}
	private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) { 
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (Role role : roles) {
			List<Access> accesses = role.getAccess();
		
			for (Access access : accesses) {
				authorities.add(new SimpleGrantedAuthority(access.getName()));
			}
		}
		return authorities;
	}
	
}
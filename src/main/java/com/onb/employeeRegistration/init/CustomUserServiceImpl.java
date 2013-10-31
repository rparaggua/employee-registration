package com.onb.employeeRegistration.init;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeeRegistration.domain.Access;
import com.onb.employeeRegistration.domain.ERSAccount;
import com.onb.employeeRegistration.domain.Role;
import com.onb.employeeRegistration.service.ERSAccountService;

@Service("userService")
@Transactional(readOnly=true)
public class CustomUserServiceImpl implements UserDetailsService{
	
	@Autowired
	private ERSAccountService ersAccountService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		
		ERSAccount ersAccount = ersAccountService.getERSAccountByUsername(userName);
		
        if (ersAccount == null) {
        	throw new UsernameNotFoundException("Invalid email or password");
        }
        boolean enabled = true;
        boolean accountNonExpired = true;  
        boolean credentialsNonExpired = true;  
        boolean accountNonLocked = true;
        return new org.springframework.security.core.userdetails.User(
        	ersAccount.getUsername(), 
        	ersAccount.getPassword(),
        	enabled,
    		accountNonExpired, 
    		credentialsNonExpired, 
    		accountNonLocked,
    		getAuthorities(ersAccount.getRoles())
		);
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

package com.onb.employeeRegistration.dao;

import java.util.List;

import com.onb.employeeRegistration.domain.ERSAccount;

public interface ERSAccountDao {
	
	ERSAccount getERSAccountByid(Long id);	
	
	ERSAccount getERSAccountByUsername(String username);
	
	void addOrUpdateERSAccounth(ERSAccount ersAccount);
	
	void deleteERSAccount(ERSAccount ersAccount);
	
	public List<ERSAccount> getERSAccountList();
	
	Boolean usernameExist(String username);
}

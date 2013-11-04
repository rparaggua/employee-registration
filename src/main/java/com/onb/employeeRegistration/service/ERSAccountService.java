package com.onb.employeeRegistration.service;

import java.util.List;

import com.onb.employeeRegistration.domain.ERSAccount;

public interface ERSAccountService {
	
	void addOrUpdateERSAccount(ERSAccount ersAccount);

	ERSAccount getERSAccountByID(Long id);

	ERSAccount getERSAccountByUsername(String username);

	List<ERSAccount> ersAccountList();
	
	Boolean usernameExist(String username);
	
	void activateUserAccount(String username);
	
	String encodePassword(ERSAccount ersAccount, String password);

}

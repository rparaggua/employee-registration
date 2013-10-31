package com.onb.employeeRegistration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeeRegistration.dao.ERSAccountDao;
import com.onb.employeeRegistration.domain.ERSAccount;
import com.onb.employeeRegistration.service.ERSAccountService;

@Service
@Transactional
public class ERSAccountServiceImpl implements ERSAccountService {
	
	@Autowired
	private ERSAccountDao ersAccountDao;  
	
	@Override
	public void addOrUpdateERSAccount(ERSAccount ersAccount) {
		ersAccountDao.addOrUpdateERSAccounth(ersAccount);
	}

	@Override
	public ERSAccount getERSAccountByID(Long id) {
		return ersAccountDao.getERSAccountByid(id);
	}

	@Override
	public ERSAccount getERSAccountByUsername(String username) {
		return ersAccountDao.getERSAccountByUsername(username);
	}

	@Override
	public List<ERSAccount> ersAccountList() {
		return ersAccountDao.getERSAccountList();
	}

	@Override
	public Boolean usernameExist(String username) {
		return ersAccountDao.usernameExist(username);
	}
}

package com.onb.employeeRegistration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeeRegistration.dao.BranchDao;
import com.onb.employeeRegistration.dao.ERSAccountDao;
import com.onb.employeeRegistration.domain.Branch;
import com.onb.employeeRegistration.service.BranchService;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private ERSAccountDao ersAccountDao;
	
	@Override
	public void addOrUpdateBranch(Branch branch) {
		branchDao.addOrUpdateBranch(branch);
	}

	@Override
	public Branch getBranchById(Long id) {
		return branchDao.getBranchById(id);
	}

	@Override
	public Branch getBranchByName(String name) {
		return branchDao.getBranchByName(name);
	}

	@Override
	public List<Branch> getBranchList() {
		return branchDao.getBranchList();
	}

	@Override
	public void deleteBranch(Branch branch) {
		branchDao.deleteBranch(branch);
	}

	@Override
	public Branch getBranchByEmail(String email) {
		return branchDao.getBranchByEmail(email);
	}
}

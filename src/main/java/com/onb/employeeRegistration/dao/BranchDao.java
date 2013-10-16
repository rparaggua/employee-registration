package com.onb.employeeRegistration.dao;

import java.util.List;

import com.onb.employeeRegistration.domain.Branch;

public interface BranchDao {
	void addOrUpdateBranch(Branch branch);

	void deleteBranch(Branch branch);
	
	Branch getBranchById(Long id);

	Branch getBranchByName(String name);
	
	Branch getBranchByEmail(String email);

	List<Branch> getBranchList();
}

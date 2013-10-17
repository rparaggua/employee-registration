package com.onb.employeeRegistration.mock;

import com.onb.employeeRegistration.domain.Branch;

public class BranchMock {
	
	private BranchMock(){
	}

	private Branch generateBranch(){
		Branch branch = new Branch();
		
		branch.setId(1);
		branch.setName("Branch1");
		branch.setAddress("Branch1 Address");
		branch.setEmail("branch1@email.com");
		branch.setPhoneNumber("123 456");
		
		return branch;
	}
}

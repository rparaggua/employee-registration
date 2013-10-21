package com.onb.employeeRegistration.mock;

import java.util.ArrayList;
import java.util.List;

import com.onb.employeeRegistration.domain.Branch;

public class BranchMock {
	
	private BranchMock(){
	}

	public static Branch generateBranch(){
		Branch branch = new Branch();
		
		branch.setId(1L);
		branch.setName("Branch1");
		branch.setAddress("Branch1 Address");
		branch.setEmail("branch1@email.com");
		branch.setPhoneNumber("02-111-01-11");
		return branch;
	}
	
	public static Branch generateInvalidBranch(){
		Branch branch = new Branch();
		
		branch.setName("Invalid Branch");
		branch.setAddress("Branch1 Address");
		branch.setEmail("invalid email.com");
		branch.setPhoneNumber("02-111-01-11");
		return branch;
	}
	
	public static Branch generateNewBranch(){
		Branch branch = new Branch();
		
		branch.setName("New Branch");
		branch.setAddress("New Branch Address");
		branch.setEmail("newbranch@email.com");
		branch.setPhoneNumber("111 111");
		
		return branch;
	}
	
	public static List<Branch> generateBranchList(){
		List<Branch> branchList = new ArrayList<Branch>();
		
		Branch branch1 = new Branch();
		branch1.setId(1L);
		branch1.setName("Branch1");
		branch1.setAddress("Branch1 Address");
		branch1.setEmail("branch1@email.com");
		branch1.setPhoneNumber("123 456");
		branchList.add(branch1);
		
		Branch branch2 = new Branch();
		branch2.setId(2L);
		branch2.setName("Branch2");
		branch2.setAddress("Branch2 Address");
		branch2.setEmail("branch2@email.com");
		branch2.setPhoneNumber("612 345");
		branchList.add(branch2);
		
		Branch branch3 = new Branch();
		branch3.setId(3L);
		branch3.setName("Branch3");
		branch3.setAddress("Branch3 Address");
		branch3.setEmail("branch3@email.com");
		branch3.setPhoneNumber("561 234");
		branchList.add(branch3);
		
		return branchList;
	}
}

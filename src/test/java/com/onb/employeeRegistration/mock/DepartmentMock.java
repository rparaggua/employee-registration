package com.onb.employeeRegistration.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.onb.employeeRegistration.domain.Department;

public class DepartmentMock {

	private DepartmentMock(){
	}
	
	public static Department generateDepartment(){
		Department department = new Department();

		department.setId(1L);
		department.setName("Department1");
		department.setDEPB(new BigDecimal("0.01"));
		department.setBranch(BranchMock.generateBranch());
		
		return department;
	}
	
	public static Department generateNewDepartment(){
		Department department = new Department();

		department.setName("New Department");
		department.setDEPB(new BigDecimal("0.00"));
		
		return department;
	}
	
	public static List<Department> generateDepartmentList(){
		List<Department> departmentList = new ArrayList<Department>();
		
		Department department1 = new Department();
		department1.setId(1L);
		department1.setName("Department1");
		department1.setDEPB(new BigDecimal("0.01"));
		department1.setBranch(BranchMock.generateBranch());
		departmentList.add(department1);
		
		Department department2 = new Department();
		department2.setId(2L);
		department2.setName("Department2");
		department2.setDEPB(new BigDecimal("0.02"));
		department2.setBranch(BranchMock.generateBranch());
		departmentList.add(department2);
		
		Department department3 = new Department();
		department3.setId(3L);
		department3.setName("Department3");
		department3.setDEPB(new BigDecimal("0.03"));
		department3.setBranch(BranchMock.generateBranch());
		departmentList.add(department3);
		
		return departmentList;
	}
}

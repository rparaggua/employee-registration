package com.onb.employeeRegistration.service;

import java.util.List;

import com.onb.employeeRegistration.domain.Department;

public interface DepartmentService {

	void addOrUpdateDepartment(Department department);
	
	void deleteDepartment(Department department);
	
	Department getDepartmentById(Long id);

	List<Department> getBranchDepartmentListByBranchId(Long id);
}

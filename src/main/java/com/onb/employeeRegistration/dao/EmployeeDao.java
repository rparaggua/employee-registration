package com.onb.employeeRegistration.dao;

import java.util.List;

import com.onb.employeeRegistration.domain.Employee;

public interface EmployeeDao {
	
	void addOrUpdateEmployee(Employee employee);
	
	void deleteEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	
	Employee getEmployeeByEmail(String email);
	
	List<Employee> getEmployeeByDepartmentId(Long id);
}

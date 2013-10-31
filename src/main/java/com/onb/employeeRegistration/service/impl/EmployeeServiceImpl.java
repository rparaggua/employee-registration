package com.onb.employeeRegistration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeeRegistration.dao.EmployeeDao;
import com.onb.employeeRegistration.domain.Employee;
import com.onb.employeeRegistration.service.DepartmentService;
import com.onb.employeeRegistration.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Override
	public void addOrUpdateEmployee(Employee employee) {
		employee.setDepartment(departmentService.getDepartmentById(employee.getDepartment().getId()));
		employeeDao.addOrUpdateEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}

	@Override
	public List<Employee> getEmployeeByDepartmentId(Long id) {
		return employeeDao.getEmployeeByDepartmentId(id);
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		return employeeDao.getEmployeeByEmail(email);
	}
}

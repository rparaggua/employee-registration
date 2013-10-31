package com.onb.employeeRegistration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeeRegistration.dao.DepartmentDao;
import com.onb.employeeRegistration.domain.Department;
import com.onb.employeeRegistration.service.BranchService;
import com.onb.employeeRegistration.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private BranchService branchService;
	
	@Override
	public void addOrUpdateDepartment(Department department) {
		department.setBranch(branchService.getBranchById(department.getBranch().getId()));
		departmentDao.addOrUpdateDepartment(department);
	}

	@Override
	public void deleteDepartment(Department department) {
		departmentDao.deleteDepartment(department);
	}

	@Override
	public Department getDepartmentById(Long id) {
		return departmentDao.getDepartmentById(id);
	}

	@Override
	public List<Department> getBranchDepartmentListByBranchId(Long id) {
		return departmentDao.getBranchDepartmentListByBranchId(id);
	}

}

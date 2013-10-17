package com.onb.employeeRegistration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeeRegistration.dao.EmployeeDao;
import com.onb.employeeRegistration.domain.Employee;
import com.onb.employeeRegistration.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
//	@Autowired
//	private ContributionService contributionService;
	
	@Override
	public void addOrUpdateEmployee(Employee employee) {
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
	
//	private Employee computeContributions(Map<String, BigDecimal> contribution, Employee employee){
//		
//		employee.setPagibigContribution(contribution.get("PGIBG").multiply(employee.getGrossSalary()));
//		employee.setSSSContribution(contribution.get("SSS").multiply(employee.getGrossSalary()));
//		employee.setTaxContribution(contribution.get("TAX").multiply(employee.getGrossSalary()));
//		employee.setDepartmentalBonus(employee.getDepartment().getDEPB().multiply(employee.getGrossSalary()));
//		employee.setNetSalary(employee.getGrossSalary()
//				.subtract(employee.getPagibigContribution()
//						.add(employee.getSSSContribution()
//						.add(employee.getTaxContribution())))
//				.add(employee.getDepartmentalBonus()));
//		
//		return employee;
//	}
}

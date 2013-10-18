package com.onb.employeeRegistration.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.onb.employeeRegistration.domain.Employee;

public class EmployeeMock {
	
	private EmployeeMock(){
	}
	
	public static Employee generateEmployee(){
		Employee employee = new Employee();
		
		employee.setId(1L);
		employee.setFirstname("Richard");
		employee.setMiddlename("Martinez");
		employee.setLastname("Paraggua");
		employee.setPhoneNumber("123 456");
		employee.setEmail("employee1@email.com");
		employee.setGrossSalary(new BigDecimal("10000.00"));
		employee.setDepartment(DepartmentMock.generateDepartment());
		
		return employee;
	}
	
	public static Employee generateNewEmployee(){
		Employee employee = new Employee();
		
		employee.setFirstname("NewFirstname");
		employee.setMiddlename("NewMiddlename");
		employee.setLastname("NewLastname");
		employee.setPhoneNumber("612 345");
		employee.setEmail("newemployee@email.com");
		employee.setGrossSalary(new BigDecimal("1000.00"));
		employee.setDepartment(DepartmentMock.generateDepartment());
		
		return employee;
	}
	
	public static List<Employee> generateEmployeeList(){
		List<Employee> employeeList = new ArrayList<Employee>();
		
		Employee employee1 = new Employee();
		employee1.setId(1L);
		employee1.setFirstname("Richard");
		employee1.setMiddlename("Martinez");
		employee1.setLastname("Paraggua");
		employee1.setPhoneNumber("123 456");
		employee1.setEmail("employee1@email.com");
		employee1.setGrossSalary(new BigDecimal("10000.00"));
		employee1.setDepartment(DepartmentMock.generateDepartment());
		employeeList.add(employee1);
		
		Employee employee2 = new Employee();
		employee2.setId(2L);
		employee2.setFirstname("Edwin");
		employee2.setMiddlename("Richbald");
		employee2.setLastname("Salinas");
		employee2.setPhoneNumber("612 345");
		employee2.setEmail("employee2@email.com");
		employee2.setGrossSalary(new BigDecimal("10000.00"));
		employee2.setDepartment(DepartmentMock.generateDepartment());
		employeeList.add(employee2);
		
		Employee employee3 = new Employee();
		employee3.setId(3L);
		employee3.setFirstname("Mave");
		employee3.setMiddlename("Tumbaga");
		employee3.setLastname("Layus");
		employee3.setPhoneNumber("561 234");
		employee3.setEmail("employee3@email.com");
		employee3.setGrossSalary(new BigDecimal("10000.00"));
		employee3.setDepartment(DepartmentMock.generateDepartment());
		employeeList.add(employee3);
		
		return employeeList;
	}

}

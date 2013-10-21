package com.onb.employeeRegistration.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onb.employeeRegistration.domain.Employee;
import com.onb.employeeRegistration.mock.EmployeeMock;

import infrastructure.BaseIT;

public class EmployeeDaoIT extends BaseIT{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Test
	public void shouldAddEmployee(){
		//given
		Employee employee = EmployeeMock.generateNewEmployee();
		
		//when
		employeeDao.addOrUpdateEmployee(employee);
		Employee employeeFromDB = employeeDao.getEmployeeByEmail(employee.getEmail());
		
		//then
		assertEquals(employee.getFirstname(), employeeFromDB.getFirstname());
	}
	
	@Test
	public void shouldUpdateEmployee(){
		//given
		Long id = 1L;
		Employee employee = employeeDao.getEmployeeById(id);
		
		//when
		employee.setFirstname("New Employee");
		employeeDao.addOrUpdateEmployee(employee);
		Employee employeeFromDB = employeeDao.getEmployeeById(id);
		
		//then
		assertEquals("New Employee", employeeFromDB.getFirstname());
	}
	
	@Test
	public void shouldGetEmployeeByID(){
		//given
		Long id = 1L;
		
		//when
		Employee employeeFromDB = employeeDao.getEmployeeById(id);
		
		//then
		assertEquals(id, employeeFromDB.getId());
	}
	
	@Test
	public void shouldGetEmployeeByEmail(){
		//given
		String email = "employee1@email.com";
		
		//when
		Employee employeeFromDB = employeeDao.getEmployeeByEmail(email);
		
		//then
		assertEquals(email, employeeFromDB.getEmail());
	}
	
	@Test
	public void shouldGetEmployeeByDepartmentID(){
		//given
		Long id = 1L;
		
		//when
		List<Employee> employeeList = employeeDao.getEmployeeByDepartmentId(id);
		
		//then
		assertTrue(employeeList.size() == 5);
		assertEquals(id, employeeList.get(0).getDepartment().getId());
	}
}

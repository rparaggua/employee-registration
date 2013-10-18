package com.onb.employeeRegistration.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.util.Assert.notNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BindingResult;

import com.onb.employeeRegistration.domain.Employee;
import com.onb.employeeRegistration.mock.ContributionMock;
import com.onb.employeeRegistration.mock.DepartmentMock;
import com.onb.employeeRegistration.mock.EmployeeMock;
import com.onb.employeeRegistration.service.ContributionService;
import com.onb.employeeRegistration.service.DepartmentService;
import com.onb.employeeRegistration.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	
	@Mock
	private DepartmentService departmentService;
	
	@Mock
	private EmployeeService employeeService;
	
	@Mock
	private ContributionService contributionService;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	@Test
	public void shouldGetDepartmentsEmployees(){
		//given
		Long id = 1L;
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(employeeService.getEmployeeByDepartmentId(id)).thenReturn(EmployeeMock.generateEmployeeList());
		when(contributionService.getContributionList()).thenReturn(ContributionMock.generateContributionList());
		String page = employeeController.getDepartmentEmployee(id, model);
		
		Long departmentId = (Long) model.get("departmentId");
		@SuppressWarnings("unchecked")
		List<Employee> employeeList = (List<Employee>) model.get("employeeList");
		
		//then
		notNull(departmentId);
		notNull(employeeList);
		assertTrue(employeeList.size()>0);
		assertEquals("employeeListView", page);	
	}
	
	@Test
	public void getAddEmployeeView(){
		//given
		Long id = 1L;
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(departmentService.getDepartmentById(id)).thenReturn(DepartmentMock.generateDepartment());
		String page = employeeController.addEmployee(id, model);
		Employee employee = (Employee) model.get("employee");
		
		//then
		notNull(employee);
		assertNull(employee.getId());
		assertEquals(id, employee.getDepartment().getId());
		assertEquals("0.00", employee.getGrossSalary().toString());
		assertEquals("employee-add", page);
	}
	
	@Test
	public void shouldAddEmployeeAndRedirectToEmployeeListView(){
		//given
		Employee employee = EmployeeMock.generateNewEmployee();
		BindingResult result = mock(BindingResult.class);
		
		//when
		String page = employeeController.addEmployee(employee, result);
		
		//then
		notNull(employee);
		assertFalse(result.hasErrors());
		assertNull(employee.getId());
		verify(employeeService).addOrUpdateEmployee(employee);
		assertEquals("redirect:/employee/"+employee.getDepartment().getId(), page);
	}
	
	@Test
	public void shouldGetEditEmployeeView(){
		//given
		Long id = 1L;
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(employeeService.getEmployeeById(id)).thenReturn(EmployeeMock.generateEmployee());
		String page = employeeController.editEmployee(id, model);
		
		Employee employee = (Employee) model.get("employee");
		
		//then
		notNull(employee);
		notNull(employee.getId());
		assertEquals("employee-edit", page);
	}
	
	@Test
	public void shouldUpdateEmployeeAndRedirectToEmployeeView(){
		//given
		Employee employee = EmployeeMock.generateEmployee();
		BindingResult result = mock(BindingResult.class);
		
		//when
		String page = employeeController.updateEmployee(employee, result);
		
		//then
		assertFalse(result.hasErrors());
		notNull(employee.getId());
		verify(employeeService).addOrUpdateEmployee(employee);
		assertEquals("redirect:/employee/"+employee.getDepartment().getId(), page);
	}
	
	@Test
	public void shouldDeleteEmployeeAndRedirectToEmployeeView(){
		//given
		Long id = 1L;
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(employeeService.getEmployeeById(id)).thenReturn(EmployeeMock.generateEmployee());
		String page = employeeController.deleteEmployee(id, model);
		Employee employee = employeeService.getEmployeeById(id);
		
		//then
		verify(employeeService).deleteEmployee(employee);
		notNull(employee.getId());
		assertEquals("redirect:/employee/"+employee.getId(), page);
		
	}
}

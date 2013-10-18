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

import com.onb.employeeRegistration.domain.Department;
import com.onb.employeeRegistration.mock.BranchMock;
import com.onb.employeeRegistration.mock.DepartmentMock;
import com.onb.employeeRegistration.service.BranchService;
import com.onb.employeeRegistration.service.DepartmentService;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentControllerTest {
	
	@Mock
	private DepartmentService departmentService;
	
	@Mock
	private BranchService branchService;
	
	@InjectMocks
	private DepartmentController departmentController;
	
	@Test
	public void getBranchDepartmentView(){
		//given
		Long id = 1L;
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(departmentService.getBranchDepartmentListByBranchId(id)).thenReturn(DepartmentMock.generateDepartmentList());
		String page = departmentController.getBranchDepartment(id, model);
		
		Long branchId = (Long) model.get("branchId");
		List<Department> departmentList = (List<Department>) model.get("departmentList");
		
		//then
		notNull(branchId);
		notNull(departmentList);
		assertTrue(departmentList.size() > 0);
		assertEquals("branchDepartmentListView", page);
	}
	
	@Test
	public void shouldGetAddDepartmentView(){
		//given
		Long id = 1L;
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(branchService.getBranchById(id)).thenReturn(BranchMock.generateBranch());
		String page = departmentController.addDepartment(id, model);
		Department department = (Department) model.get("department");
		
		//then
		notNull(department);
		assertNull(department.getId());
		notNull(department.getBranch());
		assertEquals("0.00", department.getDEPB().toString());
		assertEquals("department-add", page);
	}
	
	@Test
	public void shouldAddDepartment(){
		//given
		Department department = DepartmentMock.generateDepartment();
		BindingResult result = mock(BindingResult.class);
		
		//when
		String page = departmentController.addDepartment(department, result);
		
		//then
		notNull(department);
		notNull(department.getId());
		assertFalse(result.hasErrors());
		verify(departmentService).addOrUpdateDepartment(department);
		assertEquals("redirect:/department/"+department.getBranch().getId(), page);
	}
	
	@Test
	public void shouldGetEditDepartmentView(){
		//given
		Long id = 1L;
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(departmentService.getDepartmentById(id)).thenReturn(DepartmentMock.generateDepartment());
		String page = departmentController.editDepartment(id, model);
		Department department = (Department) model.get("department");
		
		//then
		notNull(department);
		notNull(department.getId());
		assertEquals("department-edit", page);	
	}
	
	@Test
	public void shouldUpdateDepartmentAndRedirectToDepartmentView(){
		//given
		Department department = DepartmentMock.generateDepartment();
		BindingResult result = mock(BindingResult.class);
		
		//when
		String page = departmentController.updateDepartment(department, result);
		
		//then
		assertFalse(result.hasErrors());
		notNull(department.getId());
		verify(departmentService).addOrUpdateDepartment(department);
		assertEquals("redirect:/department/"+department.getBranch().getId(), page);
	}
	
	@Test
	public void shouldDeleteDepartmentAndRedirectToDepartmentView(){
		//given
		Long id = 1L;
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(departmentService.getDepartmentById(id)).thenReturn(DepartmentMock.generateDepartment());
		String page = departmentController.deleteDepartment(id, model);
		Department department = departmentService.getDepartmentById(id);
		
		//then
		notNull(department.getId());
		verify(departmentService).deleteDepartment(department);
		assertEquals("redirect:/department/"+department.getBranch().getId(), page);
	}

}

package com.onb.employeeRegistration.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onb.employeeRegistration.domain.Department;
import com.onb.employeeRegistration.mock.DepartmentMock;

import infrastructure.BaseIT;

public class DepartmentDaoIT extends BaseIT{

	@Autowired
	private DepartmentDao departmentDao;
	
	@Test
	public void shouldAddDepartment(){
		//given
		Long id = 11L;
		Department department = DepartmentMock.generateNewDepartment();
		
		//when
		departmentDao.addOrUpdateDepartment(department);
		Department departmentFromDB = departmentDao.getDepartmentById(id);
		
		//then
		assertEquals(department.getName(), departmentFromDB.getName());
	}
	
	@Test
	public void shouldUpdateDepartment(){
		//given
		Department department = departmentDao.getDepartmentById(1L);
		
		//when
		department.setName("New Department");
		departmentDao.addOrUpdateDepartment(department);
		Department departmentFromDB = departmentDao.getDepartmentById(1L);

		//then
		assertEquals("New Department", departmentFromDB.getName());
	}
	
	@Test
	public void shouldDeleteDepartment(){
		//given
		Department department = departmentDao.getDepartmentById(1L);
		
		//when
		departmentDao.deleteDepartment(department);
		Department departmentFromDB = departmentDao.getDepartmentById(1L);
		
		//then
		assertNull(departmentFromDB);
	}
	
	@Test
	public void shouldGetDepartmentByID(){
		//given
		Long id = 1L;
		//when
		Department departmentFromDB = departmentDao.getDepartmentById(id);
		
		//then
		assertEquals(id, departmentFromDB.getId());
	}
	
	@Test
	public void shouldGetDepartmentListByBranchId(){
		//given
		Long id = 1L;
		
		//when
		List<Department> departmentList = departmentDao.getBranchDepartmentListByBranchId(id);
		
		//then
		assertTrue(departmentList.size()== 5);
		assertEquals(id, departmentList.get(0).getBranch().getId());
	}
}

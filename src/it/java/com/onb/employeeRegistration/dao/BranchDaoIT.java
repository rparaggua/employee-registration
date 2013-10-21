package com.onb.employeeRegistration.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.util.Assert.notNull;

import java.util.List;

import infrastructure.BaseIT;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onb.employeeRegistration.domain.Branch;
import com.onb.employeeRegistration.mock.BranchMock;


public class BranchDaoIT extends BaseIT {
	
	@Autowired
	private BranchDao branchDao;
	
	@Test
	public void shouldAddBranch(){
		//given
		Branch branch = new Branch();
		branch.setName("New Branch");
		branch.setAddress("Address of new branch");
		branch.setDepartments(null);
		branch.setEmail("newbranch@email.com");
		branch.setPhoneNumber("1234-5678");
		
		//when
		branchDao.addOrUpdateBranch(branch);
		Branch branchFromDB = branchDao.getBranchByName("New Branch");
		
		//then
		notNull(branchFromDB);
		assertEquals("New Branch", branchFromDB.getName());
	}
	
	@Test
	public void shouldUpdateBranch(){
		//given
		Branch branch = branchDao.getBranchById(1L);
		
		//when
		branch.setName("Branch 54");
		branchDao.addOrUpdateBranch(branch);
		Branch updatedBRanch = branchDao.getBranchById(1L);
		
		//then
		assertEquals("Branch 54", updatedBRanch.getName());
	}
	
	@Test
	public void shouldDeleteBranch(){
		//given
		Branch branch = BranchMock.generateNewBranch();
		branchDao.addOrUpdateBranch(branch);
		
		//when
		branchDao.deleteBranch(branch);
		Branch deletedBranch = branchDao.getBranchByName(branch.getName());
		
		//then
		assertNull(deletedBranch);
	}
	
	@Test
	public void shouldGetBranchById(){
		//given
		Long id = 1L;
		
		//when
		Branch branch = branchDao.getBranchById(id);
		
		//then
		assertEquals(id, branch.getId());
	}
	
	@Test
	public void shouldGetBranchByName(){
		//given
		Branch branch = branchDao.getBranchById(1L);
		String name = branch.getName();

		//when
		Branch branchFromDB = branchDao.getBranchByName(branch.getName());
		
		//then
		assertEquals(name, branchFromDB.getName());
	}
	
	@Test
	public void shouldGetBranchByEmail(){
		//given
		String email = "branch1@email.com";
		
		//when
		Branch branch = branchDao.getBranchByEmail(email);
		
		//then
		assertEquals(email, branch.getEmail());
	}
	
	@Test
	public void shouldGetBranchList(){
		//given
		
		//when
		List<Branch> branchList = branchDao.getBranchList();
		
		//then
		assertTrue(branchList.size() == 2);
	}

}

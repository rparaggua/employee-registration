package com.onb.employeeRegistration.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.util.Assert.notNull;

import java.util.List;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BindingResult;

import com.onb.employeeRegistration.domain.Branch;
import com.onb.employeeRegistration.mock.BranchMock;
import com.onb.employeeRegistration.service.BranchService;

import infrastructure.BaseIT;

public class BranchControllerIT extends BaseIT{

	@Autowired
	private BranchService branchService;
	
	@Autowired
	private BranchController branchController;
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldGetBranchView(){
		//given
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		String page = branchController.getBranchView(model);
		
		List<Branch> employeeList = (List<Branch>) model.get("branchList");
		
		//then
		notNull(employeeList);
		assertTrue(employeeList.size()>0);
		assertEquals("branchListView", page);
	}
	
	@Test
	public void shouldGetAddBranchView(){
		//given
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		String page = branchController.getAddBranchView(model);
		Branch branch = (Branch)model.get("branch");

		//then
		notNull(branch);
		assertNull(branch.getId());
		assertEquals("branch-add", page);
	}
	
//	@Test
//	public void shouldAddBranchAndRedirectToBranchPageNoError(){
//		//given
//		Branch branch = BranchMock.generateNewBranch();
//		BindingResult result = mock(BindingResult.class);
//		
//		//when
//		String page = branchController.addBranch(branch, result);
//		
//		//then
//		
//		notNull(branch);
//		assertFalse(result.hasErrors());
//		assertEquals("redirect:/branch", page);
//	}
//	
//	@Test
//	public void shouldReturnAddBranchViewWithErrors(){
//		//given
//		Branch branch = BranchMock.generateInvalidBranch();
//		BindingResult result = mock(BindingResult.class);
//		
//		//when
//		String page = branchController.addBranch(branch, result);
//		
//		//then
//		
//		notNull(branch);
//		assertTrue(result.hasErrors());
//		assertEquals("branch-add", page);
//	}
	
}

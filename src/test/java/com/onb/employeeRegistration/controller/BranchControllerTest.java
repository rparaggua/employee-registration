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

import com.onb.employeeRegistration.domain.Branch;
import com.onb.employeeRegistration.mock.BranchMock;
import com.onb.employeeRegistration.service.BranchService;

@RunWith(MockitoJUnitRunner.class)
public class BranchControllerTest {

	@Mock
	private BranchService branchService;
	
	@InjectMocks
	private BranchController branchController;
	
	@Test
	public void shouldGetBranchView(){
		//given
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(branchService.getBranchList()).thenReturn(BranchMock.generateBranchList());
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
	
	@Test
	public void shouldAddBranchAndRedirectToBranchPage(){
		//given
		Branch branch = BranchMock.generateNewBranch();
		BindingResult result = mock(BindingResult.class);
		
		//when
		String page = branchController.addBranch(branch, result);
		
		//then
		notNull(branch);
		assertNull(branch.getId());
		assertFalse(result.hasErrors());
		verify(branchService).addOrUpdateBranch(branch);
		assertEquals("redirect:/branch", page);
	}
	
	@Test
	public void shouldDeleteBranchAndRedirectToBranchPage(){
		//given
		Long id  = 1L;
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(branchService.getBranchById(id)).thenReturn(BranchMock.generateBranch());
		String page = branchController.deleteBranch(id, model);
		Branch branch = branchService.getBranchById(id);
		
		//the
		notNull(branch);
		notNull(branch.getId());
		verify(branchService).deleteBranch(branch);
		assertEquals("redirect:/branch", page);	
	}
	
	@Test
	public void shouldGetEditBranchView(){
		//given
		Long id = 1L;
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(branchService.getBranchById(id)).thenReturn(BranchMock.generateBranch());
		String page = branchController.editBranch(id, model);
		Branch branch = (Branch) model.get("branch");
		
		//then
		notNull(branch);
		notNull(branch.getId());
		assertEquals("branch-edit", page);
	}
	
	@Test
	public void shouldUpdateBranchAndRedirectToBranchView(){
		//given
		Branch branch = BranchMock.generateBranch();
		BindingResult result = mock(BindingResult.class);
		
		//when
		String page = branchController.updateBranch(branch, result);
		
		//then
		assertFalse(result.hasErrors());
		notNull(branch.getId());
		verify(branchService).addOrUpdateBranch(branch);
		assertEquals("redirect:/branch", page);
	}
}

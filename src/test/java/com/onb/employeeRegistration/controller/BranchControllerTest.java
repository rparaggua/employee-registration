package com.onb.employeeRegistration.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.util.Assert.notNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BindingResult;

import com.onb.employeeRegistration.domain.Branch;
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
		String page = branchController.getBranchView(model);
		
		//then
		assertEquals("branchListView", page);
		verify(branchService).getBranchList();
	}
	
	@Test
	public void shouldGetAddBranchView(){
		//given
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		String page = branchController.getAddBranchView(model);
		Branch branch = (Branch) model.get("branch");

		//then
		assertEquals("branch-add", page);
		notNull(branch);
	}
	
	@Test
	public void shouldAddBranchAndRedirectToBranchPage(){
		//given
		Branch branch = new Branch();
		BindingResult result = mock(BindingResult.class);
		
		//when
		String page = branchController.addBranch(branch, result);
		
		//then
		verify(branchService).addOrUpdateBranch(branch);
		assertEquals("redirect:/branch", page);
	}
	
	@Test
	public void shouldDeleteBranchAndRedirectToBranchPage(){
		//given
		Long id  = 1L;
		ExtendedModelMap model = new ExtendedModelMap();
		
		//when
		when(branchService.getBranchById(id)).thenReturn(new Branch());
		String page = branchController.deleteBranch(id, model);
		
		//then
	}
}

package com.onb.employeeRegistration.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onb.employeeRegistration.domain.Branch;
import com.onb.employeeRegistration.domain.Department;
import com.onb.employeeRegistration.service.BranchService;
import com.onb.employeeRegistration.service.DepartmentService;

@Controller
@RequestMapping(value = "/branch")
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostAuthorize("hasRole('VIEW_BRANCH_LISTINGS')")
	@RequestMapping(method = RequestMethod.GET)
	public String getBranchListView(Model model){
		
		List<Branch> branchList = branchService.getBranchList();
		model.addAttribute("branchList", branchList);
		
		return "branchListView";
	}
	
	@PostAuthorize("hasAnyRole('VIEW_BRANCH','BRANCH_HEAD')")
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String getBranchView(@PathVariable Long id, Model model){
		
		Branch branch = branchService.getBranchById(id);
		List<Department> departmentList = departmentService.getBranchDepartmentListByBranchId(id);
		
		model.addAttribute("branch", branch);
		model.addAttribute("departmentList", departmentList);
		
		return "branch-View";
	}
	
	@PostAuthorize("hasRole('ADD_BRANCH')")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddBranchView(Model model){
		
		model.addAttribute("branch", new Branch());
		
		return "branch-add";
	}
	
	@PostAuthorize("hasRole('ADD_BRANCH')")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBranch(@Valid Branch branch, BindingResult result) {
		
		result = validateBranchNameAndEmail(branch, result);
		
		if (result.hasErrors()){
			return "branch-add";
		}
		else {
			branchService.addOrUpdateBranch(branch);
			return "redirect:/branch";
		}
 
	}
	
	@PostAuthorize("hasRole('DELETE_BRANCH')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBranch(@PathVariable Long id, Model model){
		
		Branch branch = branchService.getBranchById(id);
		branchService.deleteBranch(branch);
		
		return "redirect:/branch";
	}
	
	@PostAuthorize("hasRole('EDIT_BRANCH')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBranch(@PathVariable Long id, Model model){
		
		Branch branch = branchService.getBranchById(id);
		model.addAttribute("branch", branch);
		
		return "branch-edit";
	}
	
	@PostAuthorize("hasRole('EDIT_BRANCH')")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateBranch(@Valid Branch branch, BindingResult result) {

		result = validateBranchNameAndEmail(branch, result);
		
		if (result.hasErrors()){
			return "branch-edit";
		} else {
			branchService.addOrUpdateBranch(branch);
			return "redirect:/branch";
		}
 
	}
	
	private BindingResult validateBranchNameAndEmail(Branch branch, BindingResult result){
		Branch test;
		if(branch.getName() != null  && (test = branchService.getBranchByName(branch.getName()))!= null){
			
			if(branch.getId() != test.getId())
				result.rejectValue("name", "com.onb.employeeregistration.validator.message.branchExist");
		}
		
		
		if(branch.getEmail() != null && (test = branchService.getBranchByEmail(branch.getEmail())) != null){
			
			if(branch.getId() != test.getId())
				result.rejectValue("email", "com.onb.employeeregistration.validator.message.emailExist");
		}
		
		return result;
	}
}

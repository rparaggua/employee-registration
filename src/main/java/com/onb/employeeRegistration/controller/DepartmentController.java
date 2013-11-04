package com.onb.employeeRegistration.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onb.employeeRegistration.domain.Department;
import com.onb.employeeRegistration.domain.Employee;
import com.onb.employeeRegistration.service.BranchService;
import com.onb.employeeRegistration.service.DepartmentService;
import com.onb.employeeRegistration.service.EmployeeService;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostAuthorize("hasAnyRole('VIEW_DEPARTMENT', 'DEPARTMENT_HEAD')")
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String getDepartmentView(@PathVariable Long id, Model model){
		
		List<Employee> employeeList = employeeService.getEmployeeByDepartmentId(id);
		Department department = departmentService.getDepartmentById(id);
		
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("department", department);
		
		return "department-view";
	}

	@PostAuthorize("hasRole('ADD_DEPARTMENT')")
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String addDepartment(@PathVariable Long id, Model model){

		Department department = new Department();
		department.setBranch(branchService.getBranchById(id));
		department.setDEPB(new BigDecimal("0.00"));
		model.addAttribute("department", department);
		return "department-add";
	}
	
	@PostAuthorize("hasRole('ADD_DEPARTMENT')")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addDepartment(@Valid Department department, BindingResult result) {

		if (result.hasErrors()){
			return "department-add";
		}
		else {
			try{
				departmentService.addOrUpdateDepartment(department);
				return "redirect:/branch/view/"+department.getBranch().getId();
			}
			catch(DataIntegrityViolationException ex){
				result.rejectValue("name", "com.onb.employeeregistration.validator.message.departmentExist");
				return "department-add";
			}
		}
	}
	
	@PostAuthorize("hasRole('EDIT_DEPARTMENT')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editDepartment(@PathVariable Long id, Model model){
		
		Department department = departmentService.getDepartmentById(id);
		model.addAttribute("department", department);
		
		return "department-edit";
	}
	
	@PostAuthorize("hasRole('EDIT_DEPARTMENT')")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateDepartment(@Valid Department department, BindingResult result) {
		
		if (result.hasErrors()){
			return "department-edit";
		}
		else {
			try{
				departmentService.addOrUpdateDepartment(department);
				return "redirect:/branch/view/"+department.getBranch().getId();
			}
			catch(DataIntegrityViolationException ex){
				result.rejectValue("name", "com.onb.employeeregistration.validator.message.departmentExist");
				return "department-edit";
			}
		}
	}

	@PostAuthorize("hasRole('DELETE_DEPARTMENT')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteDepartment(@PathVariable Long id, Model model){
		
		Department department = departmentService.getDepartmentById(id);
		Long branchId = department.getBranch().getId();
		departmentService.deleteDepartment(department);
		
		return "redirect:/branch/view/"+branchId;
	}
}

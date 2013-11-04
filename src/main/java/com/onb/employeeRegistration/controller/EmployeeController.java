package com.onb.employeeRegistration.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onb.employeeRegistration.domain.Contribution;
import com.onb.employeeRegistration.domain.Employee;
import com.onb.employeeRegistration.service.ContributionService;
import com.onb.employeeRegistration.service.DepartmentService;
import com.onb.employeeRegistration.service.EmployeeService;

@Controller
@RequestMapping(value = "employee")
public class EmployeeController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ContributionService contributionService;
	
	@PostAuthorize("hasRole('VIEW_EMPLOYEE')")
	@RequestMapping(value="/view/{id}", method = RequestMethod.GET)
	public String getEmployeeView(@PathVariable Long id, Model model){
		
		Map<String, BigDecimal> contribution = convertListToMap();
		Employee employee = computeContributions(contribution, employeeService.getEmployeeById(id));
		
		model.addAttribute("employee", employee);
		
		return "employee-view";
	}
	
	@PostAuthorize("hasRole('ADD_EMPLOYEE')")
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String addEmployee(@PathVariable Long id, Model model){

		Employee employee = new Employee();
		employee.setDepartment(departmentService.getDepartmentById(id));
		employee.setGrossSalary(new BigDecimal("0.00"));
		model.addAttribute("employee", employee);
		return "employee-add";
	}
	
	@PostAuthorize("hasRole('ADD_EMPLOYEE')")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@Valid Employee employee, BindingResult result) {

		result = validateEmployeeEmail(employee, result);
		
		if (result.hasErrors()){
			return "employee-add";
		}
		else {
			try{
				employeeService.addOrUpdateEmployee(employee);
				return "redirect:/department/view/"+employee.getDepartment().getId();
			}
			catch(DataIntegrityViolationException ex){
				result.rejectValue("firstname", "com.onb.employeeregistration.validator.message.employeeExist");
				return "employee-add";
			}
		}
	}
	
	@PostAuthorize("hasRole('EDIT_EMPLOYEE')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable Long id, Model model){
		
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		
		return "employee-edit";
	}
	
	@PostAuthorize("hasRole('EDIT_EMPLOYEE')")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateEmployee(@Valid Employee employee, BindingResult result) {
		
		result = validateEmployeeEmail(employee, result);
		
		if (result.hasErrors()){
			return "employee-edit";
		}
		else {
			try{
				employeeService.addOrUpdateEmployee(employee);
				return "redirect:/department/view/"+employee.getDepartment().getId();
			}
			catch(DataIntegrityViolationException ex){
				result.rejectValue("firstname", "com.onb.employeeregistration.validator.message.employeeExist");
				return "employee-edit";
			}
		}
	}
	
	@PostAuthorize("hasRole('DELETE_EMPLOYEE')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable Long id, Model model){
		
		Employee employee= employeeService.getEmployeeById(id);
		Long departmentId = employee.getDepartment().getId();
		employeeService.deleteEmployee(employee);
		
		return "redirect:/department/view/"+departmentId;
	}

	
	private Employee computeContributions(Map<String, BigDecimal> contribution, Employee employee){
		
		employee.setPagibigContribution(contribution.get("PGIBG").multiply(employee.getGrossSalary()));
		employee.setSSSContribution(contribution.get("SSS").multiply(employee.getGrossSalary()));
		employee.setTaxContribution(contribution.get("TAX").multiply(employee.getGrossSalary()));
		employee.setDepartmentalBonus(employee.getDepartment().getDEPB().multiply(employee.getGrossSalary()));
		employee.setNetSalary(employee.getGrossSalary()
				.subtract(employee.getPagibigContribution()
						.add(employee.getSSSContribution()
						.add(employee.getTaxContribution())))
				.add(employee.getDepartmentalBonus()));
		
		return employee;
	}
	
	private Map<String, BigDecimal> convertListToMap() {
		
		Map<String, BigDecimal> contribution = new HashMap<String, BigDecimal>();
		List<Contribution> contributionList = contributionService.getContributionList();
		
		for(Contribution contri: contributionList){
			contribution.put(contri.getName(), contri.getPercentage());
		}
		
		return contribution;	
	}
	
	private BindingResult validateEmployeeEmail(Employee employee, BindingResult result){
		
		Employee test;
		if(employee.getEmail() != null && (test = employeeService.getEmployeeByEmail(employee.getEmail())) != null){
			
			if(!employee.getId().equals(test.getId())){
				result.rejectValue("email", "com.onb.employeeregistration.validator.message.emailExist");
			}
		}
		
		return result;
	}
}

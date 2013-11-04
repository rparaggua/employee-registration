package com.onb.employeeRegistration.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onb.employeeRegistration.domain.ERSAccount;
import com.onb.employeeRegistration.form.ChangePasswordForm;
import com.onb.employeeRegistration.service.ERSAccountService;

@Controller
@RequestMapping(value = "/ersaccount")
public class ERSAccountController {

	@Autowired
	private ERSAccountService ersAccountService;

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String getChangePasswordView(Model model) {

		model.addAttribute("changePasswordForm", new ChangePasswordForm());
		return "change-password";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String changePassword(@Valid ChangePasswordForm changePasswordForm,
			BindingResult result) {

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = authentication.getName();

		ERSAccount ersAccount = ersAccountService
				.getERSAccountByUsername(username);
		String newEncodedPassword = ersAccountService.encodePassword(
				ersAccount, changePasswordForm.getNewPassword());

		if (!result.hasErrors()){
			if (!changePasswordForm.getNewPassword().equals(
					changePasswordForm.getConfirmPassword()) && changePasswordForm.getConfirmPassword().length()>0) {
				result.rejectValue("confirmPassword",
						"com.onb.employeeregistration.validator.message.passwordDoesNotMatch");
			}else if(changePasswordForm.getConfirmPassword().length() == 0){
				result.rejectValue("confirmPassword",
						"com.onb.employeeregistration.validator.message.confirmPassword");
			} else if (!ersAccountService.encodePassword(ersAccount,
					changePasswordForm.getOldPassword()).equals(
					ersAccount.getPassword())) {
				result.rejectValue("oldPassword",
						"com.onb.employeeregistration.validator.message.invalidOldPassword");
			} else if (newEncodedPassword.equals(ersAccount.getPassword())) {
				result.rejectValue("newPassword",
						"com.onb.employeeregistration.validator.message.passwordOldAndNewMatched");
			}
		}

		if (result.hasErrors()) {
			return "change-password";
		} else {
			ersAccount.setPassword(newEncodedPassword);
			ersAccountService.addOrUpdateERSAccount(ersAccount);
			return "redirect:/changePassword-success";
		}
	}

}

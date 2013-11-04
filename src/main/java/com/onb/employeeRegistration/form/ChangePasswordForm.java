package com.onb.employeeRegistration.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.onb.employeeRegistration.util.PatternUtility;

public class ChangePasswordForm {
	
	@Size(min = 7, 
			max = 20,
			message = "{com.onb.employeeregistration.validator.message.invalidPassword}")
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	@Pattern(regexp = PatternUtility.PASSWORD_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidPasswordPattern}")
	private String newPassword;
	
	private String confirmPassword;
	
	private String oldPassword;
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
}

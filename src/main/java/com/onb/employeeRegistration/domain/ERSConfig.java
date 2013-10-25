package com.onb.employeeRegistration.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

//@Entity
public class ERSConfig implements Serializable {

	private static final long serialVersionUID = 6298717706651846094L;
	
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private Long maxIdleSession;

	public Long getMaxIdleSession() {
		return maxIdleSession;
	}

	public void setMaxIdleSession(Long maxIdleSession) {
		this.maxIdleSession = maxIdleSession;
	}

}

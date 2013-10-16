package com.onb.employeeRegistration.dao;

import java.util.List;

import com.onb.employeeRegistration.domain.Access;

public interface AccessDao {
	
	Access getAccessById(Long id);

	Access getAccessByName(String name);

	List<Access> getAccessList();

}

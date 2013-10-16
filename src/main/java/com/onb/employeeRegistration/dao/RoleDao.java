package com.onb.employeeRegistration.dao;

import java.util.List;

import com.onb.employeeRegistration.domain.Role;

public interface RoleDao {
	void addOrUpdateRole(Role role);

	void deleteRole(Role role);

	Role getRoleById(Long id);

	Role getRoleByName(String name);

	List<Role> getRoleList();
}

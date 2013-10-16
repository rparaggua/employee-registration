package com.onb.employeeRegistration.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onb.employeeRegistration.dao.DepartmentDao;
import com.onb.employeeRegistration.domain.Branch;
import com.onb.employeeRegistration.domain.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addOrUpdateDepartment(Department department) {
		sessionFactory.getCurrentSession().saveOrUpdate(department);
	}

	@Override
	public void deleteDepartment(Department department) {
		department.setBranch(new Branch());
		sessionFactory.getCurrentSession().saveOrUpdate(department);
		sessionFactory.getCurrentSession().delete(department);
	}

	@Override
	public Department getDepartmentById(Long id) {
		return (Department) sessionFactory.getCurrentSession().get(Department.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getBranchDepartmentListByBranchId(Long id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Department.class);
		criteria.add(Restrictions.eq("branch.id", id));
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

}

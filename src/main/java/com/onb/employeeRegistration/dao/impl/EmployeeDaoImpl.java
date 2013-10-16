package com.onb.employeeRegistration.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onb.employeeRegistration.dao.EmployeeDao;
import com.onb.employeeRegistration.domain.Department;
import com.onb.employeeRegistration.domain.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addOrUpdateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employee.setDepartment(new Department());
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
		sessionFactory.getCurrentSession().delete(employee);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeByDepartmentId(Long id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("department.id", id));
		criteria.addOrder(Order.asc("firstname"));
		return criteria.list();
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("email", email));
		return (Employee) criteria.uniqueResult();
	}
}

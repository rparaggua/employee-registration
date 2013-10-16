package com.onb.employeeRegistration.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onb.employeeRegistration.dao.RoleDao;
import com.onb.employeeRegistration.domain.Role;

@Repository
public class RoleDaoImpl implements RoleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addOrUpdateRole(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

	@Override
	public void deleteRole(Role role) {
		sessionFactory.getCurrentSession().delete(role);
	}

	@Override
	public Role getRoleById(Long id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("id", id));
		criteria.setFetchMode("access", FetchMode.JOIN);
		return (Role) criteria.uniqueResult();
	}

	@Override
	public Role getRoleByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("name", name));
		return (Role) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoleList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		criteria.setFetchMode("access", FetchMode.JOIN);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

}

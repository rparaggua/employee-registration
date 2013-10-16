package com.onb.employeeRegistration.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onb.employeeRegistration.dao.AccessDao;
import com.onb.employeeRegistration.domain.Access;

@Repository
public class AccesDaoImpl implements AccessDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Access getAccessById(Long id) {
		return (Access) sessionFactory.getCurrentSession().get(Access.class, id);
	}

	@Override
	public Access getAccessByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Access.class);
		criteria.add(Restrictions.eq("name", name));
		return (Access) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Access> getAccessList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Access.class);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

}

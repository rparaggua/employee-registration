package com.onb.employeeRegistration.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onb.employeeRegistration.dao.ContributionDao;
import com.onb.employeeRegistration.domain.Contribution;

@Repository
public class ContributionDaoImpl implements ContributionDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void updateContributio(Contribution contribution) {
		sessionFactory.getCurrentSession().update(contribution);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contribution> getContributionList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contribution.class);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

}

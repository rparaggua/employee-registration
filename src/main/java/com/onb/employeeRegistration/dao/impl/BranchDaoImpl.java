package com.onb.employeeRegistration.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onb.employeeRegistration.dao.BranchDao;
import com.onb.employeeRegistration.domain.Branch;

@Repository
public class BranchDaoImpl implements BranchDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addOrUpdateBranch(Branch branch) {
		sessionFactory.getCurrentSession().saveOrUpdate(branch);
	}

	@Override
	public Branch getBranchById(Long id) {
		return (Branch) sessionFactory.getCurrentSession().get(Branch.class, id);
	}

	@Override
	public Branch getBranchByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Branch.class);
		criteria.add(Restrictions.eq("name", name));
		return (Branch) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Branch> getBranchList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Branch.class);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

	@Override
	public void deleteBranch(Branch branch) {
		sessionFactory.getCurrentSession().delete(branch);
	}

	@Override
	public Branch getBranchByEmail(String email) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Branch.class);
		criteria.add(Restrictions.eq("email", email));
		return (Branch) criteria.uniqueResult();
	}

}

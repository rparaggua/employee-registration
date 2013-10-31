package com.onb.employeeRegistration.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onb.employeeRegistration.dao.ERSAccountDao;
import com.onb.employeeRegistration.domain.ERSAccount;

@Repository
public class ERSAccountDaoImpl implements ERSAccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ERSAccount getERSAccountByid(Long id) {
		return (ERSAccount) sessionFactory.getCurrentSession().get(ERSAccount.class, id);	
	}

	@Override
	public ERSAccount getERSAccountByUsername(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ERSAccount.class);
		criteria.add(Restrictions.eq("username", username).ignoreCase());
		return (ERSAccount) criteria.uniqueResult();
	}

	@Override
	public void addOrUpdateERSAccounth(ERSAccount ersAccount) {
		sessionFactory.getCurrentSession().saveOrUpdate(ersAccount);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ERSAccount> getERSAccountList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ERSAccount.class);
		criteria.addOrder(Order.asc("username"));
		return criteria.list();
	}

	@Override
	public void deleteERSAccount(ERSAccount ersAccount) {
		sessionFactory.getCurrentSession().delete(ersAccount);
	}

	@Override
	public Boolean usernameExist(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ERSAccount.class);
		criteria.add(Restrictions.eq("username", username).ignoreCase());
		return criteria.uniqueResult() != null;
	}

}

package com.onb.employeeRegistration.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import infrastructure.BaseIT;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onb.employeeRegistration.domain.Contribution;
import com.onb.employeeRegistration.mock.ContributionMock;

public class ContributonDaoIT extends BaseIT{
	
	@Autowired
	private ContributionDao contributionDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void shouldUpdateContribution(){
		//given
		Contribution contribution = ContributionMock.generateContribution();
		
		//when
		contribution.setName("GSIS");
		contributionDao.updateContributio(contribution);
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contribution.class);
		criteria.add(Restrictions.eq("name", "GSIS"));
		Contribution contributionFromDB = (Contribution) criteria.uniqueResult();
		
		//then
		assertEquals("GSIS", contributionFromDB.getName());
	}
	
	public void shouldGetContributionList(){
		//given
		
		//when
		List<Contribution> contributionList = contributionDao.getContributionList();
		
		//then
		assertTrue(contributionList.size() == 3);
	}

}

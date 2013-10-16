package com.onb.employeeRegistration.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeeRegistration.dao.ContributionDao;
import com.onb.employeeRegistration.domain.Contribution;
import com.onb.employeeRegistration.service.ContributionService;

@Service
@Transactional
public class ContributionServiceImpl implements ContributionService {

	@Autowired
	private ContributionDao contributionDao;
	
	@Override
	public void updateContributio(Contribution contribution) {
		contributionDao.updateContributio(contribution);
	}

	@Override
	public List<Contribution> getContributionList() {
		return contributionDao.getContributionList();
	}
}

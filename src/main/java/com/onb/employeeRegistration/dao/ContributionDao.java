package com.onb.employeeRegistration.dao;

import java.util.List;

import com.onb.employeeRegistration.domain.Contribution;

public interface ContributionDao {
	void updateContributio(Contribution contribution);

	List<Contribution> getContributionList();

}

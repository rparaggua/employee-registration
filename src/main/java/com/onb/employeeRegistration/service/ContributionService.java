package com.onb.employeeRegistration.service;

import java.util.List;

import com.onb.employeeRegistration.domain.Contribution;

public interface ContributionService {
	
	void updateContributio(Contribution contribution);

	List<Contribution> getContributionList();

}

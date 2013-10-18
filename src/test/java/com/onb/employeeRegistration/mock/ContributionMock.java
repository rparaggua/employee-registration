package com.onb.employeeRegistration.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.onb.employeeRegistration.domain.Contribution;

public class ContributionMock {
	
	private ContributionMock(){
	}
	
	public static List<Contribution> generateContributionList(){
		
		List <Contribution> contributionList = new ArrayList<Contribution>();
		
		Contribution contribution1 = new Contribution();
		contribution1.setId(1L);
		contribution1.setName("SSS");
		contribution1.setPercentage(new BigDecimal("0.03"));
		contributionList.add(contribution1);
		
		Contribution contribution2 = new Contribution();
		contribution2.setId(2L);
		contribution2.setName("PGIBG");
		contribution2.setPercentage(new BigDecimal("0.03"));
		contributionList.add(contribution2);
		
		Contribution contribution3 = new Contribution();
		contribution3.setId(3L);
		contribution3.setName("TAX");
		contribution3.setPercentage(new BigDecimal("0.11"));
		contributionList.add(contribution3);
		
		return contributionList;
	}

}

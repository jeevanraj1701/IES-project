package com.jeev.binding;

import lombok.Data;

@Data
public class DashboardCards {

	private long plansCnt;
	
	private long approvedCnt;
	
	private long deniedCnt;
	
	private Double benefitAmountGiven;
	
	private UserAccForm user;
	
}

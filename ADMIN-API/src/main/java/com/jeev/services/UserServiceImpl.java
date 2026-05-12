 package com.jeev.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeev.entities.eligibility.*;

import com.jeev.binding.DashboardCards;
import com.jeev.binding.LoginForm;
import com.jeev.binding.UserAccForm;
import com.jeev.entities.admin.UsersIES;
import com.jeev.repositories.EligibilityRepo;
import com.jeev.repositories.PlanRepo;
import com.jeev.repositories.UsersRepo;
import com.jeev.utils.EmailUtils;


@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UsersRepo userRepo;
	
	@Autowired
	private EmailUtils eu;
	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private EligibilityRepo eRepo;
	
	@Override
	public String login(LoginForm loginForm) {
		// TODO Auto-generated method stub
		UsersIES entity = userRepo.findByUserEmailAndUserPassword(loginForm.getEmail(), loginForm.getPassword());
		if(entity == null) {
			return "Invalid Creddentials";
		}
		if("Y".equals(entity.getActiveSw()) && "UNLOCKED".equals(entity.getAccountStatus())  ) {
			return "success";
		}
		return "Account Locked/Inactive";
	}

	@Override
	public boolean recoverPassword(String email) {
		// TODO Auto-generated method stub
		UsersIES entity = userRepo.findByUserEmail(email);
		if(null == entity) {
			return false;
		}else {
			String subject = "Recover Password";
			String body = "";
			return eu.sendEmail(subject, body, email);
		}
	}

	@Override
	public DashboardCards fetchDashboardInfo() {
		// TODO Auto-generated method stub
		long plansCnt = planRepo.count();
		
		List<IESEligibilityDtls> eList = eRepo.findAll();
		Long approvedCnt = eList.stream().filter(ed -> ed.getPlanStatus().equals("APPROVED")).count();
		Long deniedCnt = eList.stream().filter(ed -> ed.getPlanStatus().equals("DENIED")).count();
		double benefitAmount = eList.stream().mapToDouble(ed -> ed.getBenefitAmount()).sum();
		
		DashboardCards card = new DashboardCards();
		card.setPlansCnt(plansCnt);
		card.setApprovedCnt(approvedCnt);
		card.setDeniedCnt(deniedCnt);
		card.setBenefitAmountGiven(benefitAmount);
		return card;
	}

	@Override
	public UserAccForm getUserByEmail(String email) {
		// TODO Auto-generated method stub
		UsersIES user = userRepo.findByUserEmail(email);
		UserAccForm userForm = new UserAccForm();
		BeanUtils.copyProperties(user, userForm);
		return userForm;
	}
 
}

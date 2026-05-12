package com.jeev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeev.binding.PlanForm;
import com.jeev.entities.admin.IESPlans;
import com.jeev.repositories.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {

    private final AccountServiceImpl accountServiceImpl;
	
	@Autowired
	private PlanRepo planRepo;

    PlanServiceImpl(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }

	@Override
	public boolean createPlan(PlanForm planForm) {
		// TODO Auto-generated method stub
		IESPlans plan = new IESPlans();
		BeanUtils.copyProperties(planForm, plan);
		planRepo.save(plan);
		return true;
	}

	@Override
	public List<PlanForm> fetchPlans() {
		// TODO Auto-generated method stub
		List<IESPlans> plans = planRepo.findAll();
		List<PlanForm> planForms = new ArrayList<>();
		for(IESPlans plan:plans) {
			PlanForm planForm = new PlanForm();
			BeanUtils.copyProperties(plan, planForm);
			planForms.add(planForm);
		}
		return planForms;
	}

	@Override
	public PlanForm getPlanById(Integer planId) {
		// TODO Auto-generated method stub
		System.out.println(planRepo.findById(planId));
		Optional<IESPlans> plan = planRepo.findById(planId);
		System.out.println(plan.isPresent());
		PlanForm planForm = new PlanForm();
		if(plan.isPresent()) {
			IESPlans iesForm = new IESPlans();
			iesForm = plan.get();
			BeanUtils.copyProperties(iesForm, planForm);
			return planForm;
		}
		
		
		return null;
	}

	@Override
	public String changePlanStatus(Integer planId, String status) {
		// TODO Auto-generated method stub
		Integer updateStatus = planRepo.updateStatus(planId, status);
		if(updateStatus>0) {
			return "SUCCESS";
		}
		return "FAILED";
	}

}

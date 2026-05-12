package com.jeev.rest;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeev.binding.PlanForm;
import com.jeev.binding.StatusRequest;
import com.jeev.services.PlanService;

@RestController
public class PlanRestController {

	private Logger logger = LoggerFactory.getLogger(PlanRestController.class);
	
	@Autowired
	private PlanService planService;
	
	@PostMapping("/plans")
	public ResponseEntity<String> createPlan(@RequestBody PlanForm planForm) throws IOException{
		logger.debug("Plan Creation Process Started");
		System.out.println("Hello Plan Started");
		boolean status = planService.createPlan(planForm);
		logger.debug("Account Creation Process Ended");
		if(status) {
			logger.info("Account Created Successfully");
			return new ResponseEntity<>("Plan Created", HttpStatus.CREATED); // 201
		}else {
			logger.info("Plan Creation Failed");
			return new ResponseEntity<>("Plan Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR); // 500
		}
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<PlanForm>> getUsers(){
		logger.debug("Plan Accounts  Process Started");
		List<PlanForm> fetchUserAccounts = planService.fetchPlans();
		logger.info("Plan Accounts Fetched");
		logger.debug("Plan Accounts  Fetched Success");
		return new ResponseEntity<>(fetchUserAccounts, HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<PlanForm> getPlan(@PathVariable("planId") Integer planId){
		logger.debug("Plan retrieve Process Started");
		PlanForm plan= planService.getPlanById(planId);
		logger.debug("Plan Retrieve Process Ended");
		logger.info("User Account Status Updated Successfully");
		return new  ResponseEntity<>(plan, HttpStatus.OK);
	}
	
	@PutMapping("/{planId}/status")
	public ResponseEntity<String> changeStatus(
			@PathVariable Integer planId,
			@RequestBody StatusRequest request) {

		String response = planService.changePlanStatus(planId, request.getStatus());
		
		if(response.equals("SUCCESS")) {
			return new ResponseEntity<>("Plan Status Updated", HttpStatus.OK);
		}

		return new ResponseEntity<>("Plan Not Found", HttpStatus.BAD_REQUEST);
	}
}

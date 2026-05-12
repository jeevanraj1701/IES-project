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

import com.jeev.binding.UserAccForm;
import com.jeev.services.AccountService;

@RestController
public class AccountRestController {

	private Logger logger = LoggerFactory.getLogger(AccountRestController.class);
	
	
	@Autowired
	private AccountService accService;
	
	@PostMapping("/users")
	public ResponseEntity<String> createAccount(@RequestBody UserAccForm userAccForm) throws IOException{
		logger.debug("Account Creation Process Started");
		System.out.println("Hello Started");
		boolean status = accService.createUserAccount(userAccForm);
		logger.debug("Account Creation Process Ended");
		if(status) {
			logger.info("Account Created Successfully");
			return new ResponseEntity<>("Account Created", HttpStatus.CREATED); // 201
		}else {
			logger.info("Account Creation Failed");
			return new ResponseEntity<>("Account Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR); // 500
		}
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserAccForm>> getUsers(){
		logger.debug("User Accounts  Process Started");
		List<UserAccForm> fetchUserAccounts = accService.fetchUserAccounts();
		logger.info("User Accounts Fetched");
		logger.debug("User Accounts  Fetched Success");
		return new ResponseEntity<>(fetchUserAccounts, HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserAccForm> getUser(@PathVariable("userId") Integer userId){
		
		UserAccForm userAcc = accService.getUserAccById(userId);
		logger.info("User Account Is Fetched");
		return new ResponseEntity<>(userAcc, HttpStatus.OK);
	}
	
	@PutMapping("/user/{userId}/{status}")
	public ResponseEntity<List<UserAccForm>> updateUserAcc(@PathVariable("userId") Integer userId, 
															@PathVariable("status") String status){
		logger.debug("User Account Update Process Started");
		accService.changeAccStatus(userId, status);
		logger.debug("User Account Update Process Ended");
		List<UserAccForm> userAccForm = accService.fetchUserAccounts();
		logger.info("User Account Status Updated Successfully");
		return new  ResponseEntity<>(userAccForm, HttpStatus.OK);
	}
}

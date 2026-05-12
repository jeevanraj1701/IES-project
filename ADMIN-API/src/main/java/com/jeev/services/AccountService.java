package com.jeev.services;

import java.io.IOException;
import java.util.List;

import com.jeev.binding.UnlockAccForm;
import com.jeev.binding.UserAccForm;

public interface AccountService {
		
	public boolean createUserAccount(UserAccForm accForm) throws IOException;
	
	public List<UserAccForm> fetchUserAccounts();
	
	public UserAccForm getUserAccById(Integer accId);
	
	public String changeAccStatus(Integer accId, String status);
	
	public String unlockUserAccount(UnlockAccForm unlockAccForm);
	
}

package com.jeev.services;

import com.jeev.binding.DashboardCards;
import com.jeev.binding.LoginForm;
import com.jeev.binding.UserAccForm;

public interface UserService {

	public String login(LoginForm loginForm);
	
	public boolean recoverPassword(String email);
	
	public DashboardCards fetchDashboardInfo();
	
	public UserAccForm getUserByEmail(String email);
	
}

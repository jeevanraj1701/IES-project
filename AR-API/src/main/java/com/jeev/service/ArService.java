package com.jeev.service;

import java.util.List;

import com.jeev.binding.App;

public interface ArService {
	
	public String createApplication(App app);
	
	public List<App> fetchApps(Integer userid);
	
	
}

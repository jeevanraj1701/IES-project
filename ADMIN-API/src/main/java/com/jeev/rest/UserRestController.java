package com.jeev.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeev.binding.DashboardCards;
import com.jeev.binding.LoginForm;
import com.jeev.binding.UserAccForm;
import com.jeev.services.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;
	
	
	//public String login(LoginForm loginForm)  Used this earlier
	// here login is checking user availability
	@PostMapping("/login")
	public String login(LoginForm loginForm) {
		String status = userService.login(loginForm);
		if(status.equals("success")) {
			//login success
			return "redirect:/dashboard?email="+loginForm.getEmail();
		}else {
			//not success
			return status;
		}
	}
	
	// here again login is fetching user, two times validation kind
	@GetMapping("/dashboard")
	public ResponseEntity<DashboardCards> buildDashboard(@RequestParam("email") String email){
		UserAccForm userByEmail = userService.getUserByEmail(email);
		DashboardCards dashboardCards = userService.fetchDashboardInfo();
		dashboardCards.setUser(userByEmail);
		return new ResponseEntity<DashboardCards>(dashboardCards, HttpStatus.OK);
	}
	
}

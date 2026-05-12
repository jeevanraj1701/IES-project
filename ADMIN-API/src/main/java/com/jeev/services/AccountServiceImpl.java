package com.jeev.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeev.binding.UnlockAccForm;
import com.jeev.binding.UserAccForm;
import com.jeev.entities.admin.UsersIES;
import com.jeev.repositories.UsersRepo;
import com.jeev.utils.EmailUtils;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private UsersRepo userRepo;
	
	@Autowired
	private EmailUtils eu;
	
	@Override
	public boolean createUserAccount(UserAccForm accForm) throws IOException {
		// TODO Auto-generated method stub
		UsersIES entity = new UsersIES();
		BeanUtils.copyProperties(accForm, entity);
		
		//set Random password (Search for generate random text)
		String pwd = generatePwd();
		entity.setUserPassword(pwd);
		
		// set account as Locked
		entity.setAccountStatus("LOCKED");
		entity.setActiveSw("Y");
		
		userRepo.save(entity);
		
		// send email
		String msg = readEmailBody("REG_EMAIL_BODY", entity);
		return eu.sendEmail("UNLOCK ACCOUNT", msg, accForm.getUserEmail());
		
	}

	@Override
	public List<UserAccForm> fetchUserAccounts() {
		// TODO Auto-generated method stub
		List<UsersIES> entities = userRepo.findAll();
		
		List<UserAccForm> users = new ArrayList<>();
		
		for(UsersIES userEntity : entities) {
			UserAccForm user = new UserAccForm();
			BeanUtils.copyProperties(userEntity, user);
			users.add(user);
		}
			
		
		return users;
	}

	@Override
	public UserAccForm getUserAccById(Integer accId) {
		
		// TODO Auto-generated method stub
		
		Optional<UsersIES> optional = userRepo.findById(accId);
		if(optional.isPresent()) {
			UsersIES userEntity = optional.get();
			UserAccForm user= new UserAccForm();
			BeanUtils.copyProperties(userEntity, user);
			return user;
		}
		return null;
	}

	@Override
	public String changeAccStatus(Integer accId, String status) {
		// TODO Auto-generated method stub
		int cnt = userRepo.updateAccountStatus(accId, status);
		if(cnt>0) {
			return "STATUS CHANGED";
		}
		return "Failed to change";
	}

	@Override
	public String unlockUserAccount(UnlockAccForm unlockAccForm) {
		// TODO Auto-generated method stub
		UsersIES user = userRepo.findByUserEmail(unlockAccForm.getEmail());
		
		user.setAccountStatus("UNLOCKED");
		user.setUserPassword(unlockAccForm.getPassword());
		userRepo.save(user);
		return "Account Unlocked";
	}
	
	public String generatePwd() {
		String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        Random random = new Random();
	        StringBuilder builder = new StringBuilder(6);
	        
	        for (int i = 0; i < 6; i++) {
	            // Pick a random index from the ALPHABET string
	            int index = random.nextInt(ALPHABET.length());
	            builder.append(ALPHABET.charAt(index));
	        }
	        return builder.toString();
	    }
	public String readEmailBody(String filename, UsersIES user) throws IOException {

	    StringBuilder sb = new StringBuilder();

	    InputStream is = getClass()
	            .getClassLoader()
	            .getResourceAsStream("templates/" + filename + ".txt");

	    if (is == null) {
	        throw new RuntimeException("File not found: " + filename);
	    }

	    try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

	        String line;

	        while ((line = br.readLine()) != null) {

	            line = line.replace("${FNAME}", user.getUserFullName());
	            line = line.replace("${TEMP_PWD}", user.getUserPassword());
	            line = line.replace("${EMAIL}", user.getUserEmail());

	            sb.append(line).append("\n");
	        }
	    }

	    return sb.toString();
	}
}



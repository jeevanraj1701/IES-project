package com.jeev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.jeev.entities.UsersIES;

public interface UsersRepo extends JpaRepository<UsersIES, Integer> {

	@Modifying
	@Transactional
	@Query("update UsersIES set accountStatus=:status where userId=:accId")
	public Integer updateAccountStatus(Integer accId, String status);
	
	public UsersIES findByUserEmail(String email);
	
	public UsersIES findByUserEmailAndUserPassword(String email, String pwd);

}

package com.jeev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeev.entities.AppEntity;

public interface AppRepo extends JpaRepository<AppEntity, Long> {

	
	public List<AppEntity> findAll();
	
	@Query("from AppEntity where user.userId = :userId")
	public List<AppEntity> fetchCwApps(
			@Param("userId") Integer userId);
}

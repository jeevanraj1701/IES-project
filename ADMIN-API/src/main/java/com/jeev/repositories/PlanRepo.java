package com.jeev.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jeev.entities.admin.IESPlans;

public interface PlanRepo extends JpaRepository<IESPlans, Integer> {
	
	@Modifying
	@Transactional
	@Query("update IESPlans set activeSw=:status where planId=:planId")
	public Integer updateStatus(
			@Param("planId") Integer planId,
			@Param("status") String status);
}

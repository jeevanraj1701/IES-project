package com.jeev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeev.entities.eligibility.IESEligibilityDtls;

public interface EligibilityRepo extends JpaRepository<IESEligibilityDtls, Integer>{

}

package com.jeev.entities.eligibility;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jeev.entities.admin.UsersIES;
import com.jeev.entities.registration.IESApps;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ed_eligilibity_dtls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IESEligibilityDtls {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ED_TRACE_ID")
    private Long edTraceId;

    // FK to Application
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CASE_NUM")
    private IESApps application;

    @Column(name = "PLAN_NAME")
    private String planName;

    @Column(name = "PLAN_STATUS")
    private String planStatus; // APPROVED / DENIED

    @Column(name = "ELIGIBILITY_START_DATE")
    private LocalDate eligibilityStartDate;

    @Column(name = "ELIGIBILITY_END_DATE")
    private LocalDate eligibilityEndDate;

    @Column(name = "BENEFIT_AMOUNT")
    private Double benefitAmount;

    @Column(name = "DENIAL_REASON")
    private String denialReason;
}
/*
 package com.jeev.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"application"})
@Entity
@Table(name = "ed_eligibility_dtls")
public class Eligibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ED_TRACE_ID")
    private Long edTraceId;

    // FK to Application
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CASE_NUM")
    private Application application;

    @Column(name = "PLAN_NAME")
    private String planName;

    @Column(name = "PLAN_STATUS")
    private String planStatus; // APPROVED / DENIED

    @Column(name = "ELIGIBILITY_START_DATE")
    private LocalDate eligibilityStartDate;

    @Column(name = "ELIGIBILITY_END_DATE")
    private LocalDate eligibilityEndDate;

    @Column(name = "BENEFIT_AMOUNT")
    private Double benefitAmount;

    @Column(name = "DENIAL_REASON")
    private String denialReason;
}
		*/
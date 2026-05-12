package com.jeev.entities.benefit;

import java.time.LocalDate;

import com.jeev.entities.registration.IESApps;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="benefit_info")
public class IESBenefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BENEFIT_ID")
    private Long benefitId;

    // FK → Application
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CASE_NUM")
    private IESApps application;

    @Column(name = "BENEFIT_MONTH_YEAR")
    private String benefitMonthYear; // Example: "2026-04"

    @Column(name = "BENEFIT_AMOUNT")
    private Double benefitAmount;

    @Column(name = "TRANSACTION_DATE")
    private LocalDate transactionDate;

    @Column(name = "TRANSACTION_STATUS")
    private String transactionStatus; // SUCCESS / FAILED / PENDING
}
/*
 * *
 * package com.jeev.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"application"})
@Entity
@Table(name = "benefit_info")
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BENEFIT_ID")
    private Long benefitId;

    // FK → Application
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CASE_NUM")
    private Application application;

    @Column(name = "BENEFIT_MONTH_YEAR")
    private String benefitMonthYear; // Example: "2026-04"

    @Column(name = "BENEFIT_AMOUNT")
    private Double benefitAmount;

    @Column(name = "TRANSACTION_DATE")
    private LocalDate transactionDate;

    @Column(name = "TRANSACTION_STATUS")
    private String transactionStatus; // SUCCESS / FAILED / PENDING
}
 */

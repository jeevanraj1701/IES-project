package com.jeev.entities.datacollection;

import com.jeev.entities.registration.IESApps;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="dc_income")
public class IESIncome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INCOME_ID")
    private Long incomeId;

    @Column(name = "SALARY_INCOME")
    private Double salaryIncome;

    @Column(name = "RENT_INCOME")
    private Double rentIncome;

    @Column(name = "PROPERTY_INCOME")
    private Double propertyIncome;

    @OneToOne
    @JoinColumn(name = "CASE_NUM")
    private IESApps application;
}

/*
 * @Entity
@Table(name = "dc_income")
@Getter
@Setter
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INCOME_ID")
    private Long incomeId;

    @Column(name = "SALARY_INCOME")
    private Double salaryIncome;

    @Column(name = "RENT_INCOME")
    private Double rentIncome;

    @Column(name = "PROPERTY_INCOME")
    private Double propertyIncome;

    @OneToOne
    @JoinColumn(name = "CASE_NUM")
    private Application application;
}
 */
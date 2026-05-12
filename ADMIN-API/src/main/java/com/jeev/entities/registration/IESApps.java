package com.jeev.entities.registration;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jeev.entities.admin.UsersIES;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="ies_apps")
public class IESApps {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "CASE_NUM")
	    private Long caseNum;

	    @Column(name = "NAME", nullable = false)
	    private String name;

	    @Column(name = "EMAIL")
	    private String email;

	    @Column(name = "PHNO")
	    private String phno;

	    @Column(name = "DOB")
	    private LocalDate dob;

	    @Column(name = "SSN")
	    private String ssn;

	    @Column(name = "STATE_NAME")
	    private String stateName;

	    @Column(name = "CITY_NAME")
	    private String cityName;

	    @Column(name = "HOUSE_NUM")
	    private String houseNum;

	    // FK to Users table
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "CREATED_BY", updatable = false)
	    private UsersIES createdBy;

	    @Column(name = "CREATED_DATE", updatable = false)
	    private LocalDateTime createdDate;

	    @PrePersist
	    protected void onCreate() {
	        this.createdDate = LocalDateTime.now();
	    }
}

/*
 * package com.jeev.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"createdBy"})
@Entity
@Table(name = "ies_apps")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CASE_NUM")
    private Long caseNum;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHNO")
    private String phno;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "SSN")
    private String ssn;

    @Column(name = "STATE_NAME")
    private String stateName;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "HOUSE_NUM")
    private String houseNum;

    // FK to Users table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY", updatable = false)
    private UsersIES createdBy;

    @Column(name = "CREATED_DATE", updatable = false)
    private LocalDateTime createdDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }
}
*/

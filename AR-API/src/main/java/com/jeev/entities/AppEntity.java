package com.jeev.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "IES_APPS")
public class AppEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long caseNum;
	
	private String fullname;
	
	private String email;
	
	private String gender;
	
	private LocalDate dob;
	
	private long phno;
	
	private long ssn;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UsersIES user;

	public long getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(long caseNum) {
		this.caseNum = caseNum;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public UsersIES getUser() {
		return user;
	}

	public void setUser(UsersIES user) {
		this.user = user;
	}
	
}

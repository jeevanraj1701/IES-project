package com.jeev.entities.datacollection;

import java.time.LocalDate;

import com.jeev.entities.registration.IESApps;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="dc_children")
public class IESChildren {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "CHILD_ID")
	    private Long childId;

	    @Column(name = "CHILD_NAME")
	    private String childName;

	    @Column(name = "CHILD_DOB")
	    private LocalDate childDob;

	    @Column(name = "CHILD_SSN")
	    private String childSsn;

	    @ManyToOne
	    @JoinColumn(name = "CASE_NUM")
	    private IESApps application;
}

/*
 * @Entity
@Table(name = "dc_children")
@Getter
@Setter
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHILD_ID")
    private Long childId;

    @Column(name = "CHILD_NAME")
    private String childName;

    @Column(name = "CHILD_DOB")
    private LocalDate childDob;

    @Column(name = "CHILD_SSN")
    private String childSsn;

    @ManyToOne
    @JoinColumn(name = "CASE_NUM")
    private Application application;
}
 */

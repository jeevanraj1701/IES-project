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
@Table(name="dc_education")
public class IESEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EDUCATION_ID")
    private Long educationId;

    @Column(name = "HIGHEST_DEGREE")
    private String highestDegree;

    @Column(name = "GRADUATION_YEAR")
    private Integer graduationYear;

    @Column(name = "UNIVERSITY")
    private String university;

    @OneToOne
    @JoinColumn(name = "CASE_NUM")
    private IESApps application;
}

/*@Entity
@Table(name = "dc_educational")
@Getter
@Setter
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EDUCATION_ID")
    private Long educationId;

    @Column(name = "HIGHEST_DEGREE")
    private String highestDegree;

    @Column(name = "GRADUATION_YEAR")
    private Integer graduationYear;

    @Column(name = "UNIVERSITY")
    private String university;

    @OneToOne
    @JoinColumn(name = "CASE_NUM")
    private Application application;
}
*/
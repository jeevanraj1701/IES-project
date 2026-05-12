package com.jeev.entities.datacollection;

import com.jeev.entities.admin.IESPlans;
import com.jeev.entities.registration.IESApps;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="de_plan_selection")
public class IESPlanSelection {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAN_SELECTION_ID")
    private Long planSelectionId;

    // FK to Application
    @OneToOne
    @JoinColumn(name = "CASE_NUM")
    private IESApps application;

    // FK to Plan
    @ManyToOne
    @JoinColumn(name = "PLAN_ID")
    private IESPlans plan;
}

/*@Entity
@Table(name = "dc_plan_selection")
@Getter
@Setter
public class PlanSelection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAN_SELECTION_ID")
    private Long planSelectionId;

    // FK to Application
    @OneToOne
    @JoinColumn(name = "CASE_NUM")
    private Application application;

    // FK to Plan
    @ManyToOne
    @JoinColumn(name = "PLAN_ID")
    private Plan plan;
}*/
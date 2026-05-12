package com.jeev.entities.correspondence;

import java.time.LocalDateTime;

import com.jeev.entities.eligibility.IESEligibilityDtls;
import com.jeev.entities.registration.IESApps;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

public class IESNotices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_ID")
    private Long noticeId;

    // FK → Application
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CASE_NUM")
    private IESApps application;

    // FK → Eligibility
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ED_TRACE_ID")
    private IESEligibilityDtls eligibility;

    // PDF stored as binary
    @Lob
    @Column(name = "CO_PDF")
    private byte[] coPdf;

    @Column(name = "PRINT_DATE")
    private LocalDateTime printDate;

    @Column(name = "NOTICE_STATUS")
    private String noticeStatus; // PENDING / HISTORY

    @Column(name = "CREATED_DATE", updatable = false)
    private LocalDateTime createdDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }
}

/*
 * package com.jeev.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"application", "eligibility"})
@Entity
@Table(name = "co_notices")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_ID")
    private Long noticeId;

    // FK → Application
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CASE_NUM")
    private Application application;

    // FK → Eligibility
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ED_TRACE_ID")
    private Eligibility eligibility;

    // PDF stored as binary
    @Lob
    @Column(name = "CO_PDF")
    private byte[] coPdf;

    @Column(name = "PRINT_DATE")
    private LocalDateTime printDate;

    @Column(name = "NOTICE_STATUS")
    private String noticeStatus; // PENDING / HISTORY

    @Column(name = "CREATED_DATE", updatable = false)
    private LocalDateTime createdDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }
}
 */

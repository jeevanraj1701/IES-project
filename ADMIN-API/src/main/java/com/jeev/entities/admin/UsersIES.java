package com.jeev.entities.admin;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="ies_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersIES {
	/*
-	USER_ID 	PK	AUTO
-	USER_FULL_NAME
-	USER_EMAIL
-	USER_ PASSWORD
-	USER_PHNO
-	USER_GENDER
-	USER_SSN
-	ACTIVE_SW (DEFAULT : Y)
-	ACCOUNT_STATUS (DEFAULT : UNLOCKED)
-	ROLE_ID
-	CREATED_DATE
-	UPDATED_DATE
-	CREATED_BY (FOREIGN KEY : USER_ID FROM IES_USER TABLE)
-	UPDATED_BY (FOREIGN KEY : USER_ID FROM IES_USER TABLE)
*/
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
    
    @Column(name = "USER_FULL_NAME", nullable = false, length = 100)
    private String userFullName;
    
    @Column(name = "USER_EMAIL", nullable = false, unique = true, length = 100)
    private String userEmail;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String userPassword;

    @Column(name = "USER_PHNO", length = 15)
    private String userPhoneNumber;

    @Column(name = "USER_GENDER", length = 10)
    private String userGender;

    @Column(name = "USER_SSN", length = 20)
    private String userSsn;

    @Column(name = "ACTIVE_SW", length = 1)
    private String activeSw = "Y";

    @Column(name = "ACCOUNT_STATUS", length = 20)
    private String accountStatus = "UNLOCKED";

    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "CREATED_DATE", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;

    // Self-referencing relationship for CREATED_BY
    @ManyToOne
    @JoinColumn(name = "CREATED_BY", updatable = false)
    private UsersIES createdBy;

    // Self-referencing relationship for UPDATED_BY
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private UsersIES updatedBy;

    // Automatically set timestamps
    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
    
}

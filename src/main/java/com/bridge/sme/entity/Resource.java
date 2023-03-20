package com.bridge.sme.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RESOURCE", schema="SME")
public class Resource implements Serializable {
    private static final long SERIALVERSIONUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "RESOURCE_ID")
    private Integer resourceId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "CONTACT_NUM")
    private String contactNum;

    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PRIMARY_TECH_STACK_ID")
    private Integer primaryTechStackId;

    @Column(name = "PRIMARY_SKILL_SET")
    private String primarySkillSet;

    @Column(name = "SECONDARY_TECH_STACK_ID")
    private Integer secondaryTechStackId;

    @Column(name = "SECONDARY_SKILL_SET")
    private String secondarySkillSet;

    @Column(name = "SUPPORT_AVAILABLE_TIME")
    private String supportAvailableTime;

    @Column(name = "NUM_HOURS_PER_WEEK")
    private String numHoursPerWeek;

    @Column(name = "SUPPORT_MODEL")
    private String supportModel;

    @Column(name = "REFERRED_BY")
    private String referredBy;

    @Column(name = "REFERENCE_CODE")
    private String referenceCode;

    @Column(name = "SELECTED_BY")
    private String selectedBy;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "LAST_UPDATE_TS")
    private Date lastUpdateTs;

    @Column(name = "COMMENTS")
    private String comments;
}

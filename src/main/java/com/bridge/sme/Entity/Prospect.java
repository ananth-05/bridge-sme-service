package com.bridge.sme.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROSPECT")
public class Prospect implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "PROSPECT_ID")
    private Long prospectId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "TECH_STACK_NAME")
    private String techStackName;

    @Column(name = "TIME_ZONE")
    private String timeZone;

    @Column(name = "DEMO_DATE")
    private Date demoDate;

    @Column(name = "EXP_START_DATE")
    private Date expStartDate;

    @Column(name = "PREFERRED_CONTACT_METHOD")
    private String preferredContactMethod;

    @Column(name = "REQUIREMENT_DETAILS")
    private String requirementDetails;

    @CreationTimestamp
    @Column(name = "CREATE_DATE")
    private Date createDate;
}

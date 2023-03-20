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
@Table(name = "CUSTOMER", schema="SME")
public class Customer implements Serializable {
    private static final long SERIALVERSIONUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "CUSTOMER_ID")
    private Integer customerId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "TECH_STACK_ID")
    private String techStackId;

    @Column(name = "TIME_ZONE")
    private String timeZone;

    @Column(name = "PREFERRED_CONTACT_METHOD")
    private String preferredContactMethod;

    @CreationTimestamp
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @UpdateTimestamp
    @Column(name = "LAST_UPDATE_TS")
    private Date lastUpdateTs;
}

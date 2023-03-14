package com.bridge.sme.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProspectRegDTO {

    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private String techStackName;
    private String timeZone;
    private Date demoDate;
    private Date expStartDate;
    private String preferredContactMethod;
    private String requirementDetails;
    private Date createDate;
}

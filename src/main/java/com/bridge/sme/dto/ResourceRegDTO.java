package com.bridge.sme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceRegDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String contactNum;
    private String dateOfBirth;
    private String city;
    private String country;
    private Integer primaryTechStackId;
    private String primarySkillSet;
    private Integer secondaryTechStackId;
    private String secondarySkillSet;
    private String supportAvailableTime;
    private String numHoursPerWeek;
    private String supportModel;
    private String referredBy;
    private String referenceCode;
    private String selectedBy;
    private Boolean isActive;
    private String comments;
}

package com.bridge.sme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String primaryTechStackId;
    private String timeZone;
    private String preferredContactMethod;
    private String createdBy;
}

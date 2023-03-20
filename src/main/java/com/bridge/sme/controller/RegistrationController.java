package com.bridge.sme.controller;

import com.bridge.sme.dto.CustomerRegDTO;
import com.bridge.sme.dto.ProspectRegDTO;
import com.bridge.sme.dto.ResourceRegDTO;
import com.bridge.sme.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/prospectReg")
    public ResponseEntity<String> prospectRegistration(@RequestBody ProspectRegDTO prospectReg) {
        registrationService.saveProspectCustomer(prospectReg);
        return new ResponseEntity<>("Prospect Customer Saved Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/customerReg")
    public ResponseEntity<String> customerRegistration(@RequestBody CustomerRegDTO customerReg) {
        registrationService.saveCustomer(customerReg);
        return new ResponseEntity<>("Customer Saved Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/resourceReg")
    public ResponseEntity<String> resourceRegistration(@RequestBody ResourceRegDTO resourceReg) {
        registrationService.saveResource(resourceReg);
        return new ResponseEntity<>("Resource Saved Successfully", HttpStatus.CREATED);
    }

}

package com.bridge.sme.Controller;

import com.bridge.sme.Entity.Prospect;
import com.bridge.sme.dto.ProspectRegDTO;
import com.bridge.sme.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Long prospectRegistration(@RequestBody ProspectRegDTO prospectReg) {
        Prospect prospect = registrationService.saveProspectCustomer(prospectReg);
        return prospect.getProspectId();
    }

}

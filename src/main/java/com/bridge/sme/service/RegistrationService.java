package com.bridge.sme.service;

import com.bridge.sme.Entity.Prospect;
import com.bridge.sme.Repository.ProspectRepository;
import com.bridge.sme.dto.ProspectRegDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    ProspectRepository prospectRepository;

    public Prospect saveProspectCustomer(ProspectRegDTO prospectReg) {
        ModelMapper modelMapper = new ModelMapper();
        Prospect prospect = modelMapper.map(prospectReg, Prospect.class);
        return prospectRepository.save(prospect);
    }
}

package com.bridge.sme.service;

import com.bridge.sme.dto.CustomerRegDTO;
import com.bridge.sme.dto.ResourceRegDTO;
import com.bridge.sme.entity.Customer;
import com.bridge.sme.entity.Prospect;
import com.bridge.sme.entity.Resource;
import com.bridge.sme.repository.CustomerRepository;
import com.bridge.sme.repository.ProspectRepository;
import com.bridge.sme.dto.ProspectRegDTO;
import com.bridge.sme.repository.ResourceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    ProspectRepository prospectRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ResourceRepository resourceRepository;

    public Prospect saveProspectCustomer(ProspectRegDTO prospectReg) {
        ModelMapper modelMapper = new ModelMapper();
        Prospect prospect = prospectRepository.findProspectCustomerByEmail(prospectReg.getEmail());
        if (prospect != null) {
            prospect.setFirstName(prospectReg.getFirstName());
            prospect.setLastName(prospectReg.getLastName());
            prospect.setPhone(prospectReg.getPhone());
            prospect.setTechStackName(prospectReg.getTechStackName());
            prospect.setTimeZone(prospectReg.getTimeZone());
            prospect.setDemoDate(prospectReg.getDemoDate());
            prospect.setExpStartDate(prospectReg.getExpStartDate());
            prospect.setPreferredContactMethod(prospectReg.getPreferredContactMethod());
            prospect.setRequirementDetails(prospectReg.getRequirementDetails());
        } else {
            prospect = modelMapper.map(prospectReg, Prospect.class);
        }
        return prospectRepository.save(prospect);
    }

    public Customer saveCustomer(CustomerRegDTO customerReg) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerReg, Customer.class);
        return customerRepository.save(customer);
    }


    public Resource saveResource(ResourceRegDTO resourceReg) {
        ModelMapper modelMapper = new ModelMapper();
        Resource resource = modelMapper.map(resourceReg, Resource.class);
        return resourceRepository.save(resource);
    }
}

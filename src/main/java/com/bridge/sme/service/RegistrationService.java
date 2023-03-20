package com.bridge.sme.service;

import com.bridge.sme.dto.CustomerRegDTO;
import com.bridge.sme.dto.Email;
import com.bridge.sme.dto.ProspectRegDTO;
import com.bridge.sme.dto.ResourceRegDTO;
import com.bridge.sme.entity.Customer;
import com.bridge.sme.entity.Prospect;
import com.bridge.sme.entity.Resource;
import com.bridge.sme.entity.User;
import com.bridge.sme.repository.CustomerRepository;
import com.bridge.sme.repository.ProspectRepository;
import com.bridge.sme.repository.ResourceRepository;
import com.bridge.sme.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    ProspectRepository prospectRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    UserRepository userRepository;

    public Prospect saveProspectCustomer(ProspectRegDTO prospectReg) {
        ModelMapper modelMapper = new ModelMapper();
        Prospect prospect = modelMapper.map(prospectReg, Prospect.class);
        prospect = prospectRepository.save(prospect);
        emailProcess(prospectReg);
        return prospect;
    }

    private void emailProcess(ProspectRegDTO prospectReg) {
        List<User> userList = userRepository.findAll();
        Email email = new Email();
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

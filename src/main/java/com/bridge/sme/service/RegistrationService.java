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
import com.bridge.sme.util.EmailSenderUtility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Autowired
    EmailSenderUtility emailSenderUtility;

    public Prospect saveProspectCustomer(ProspectRegDTO prospectReg) {
        ModelMapper modelMapper = new ModelMapper();
        Prospect prospect = modelMapper.map(prospectReg, Prospect.class);
        prospect = prospectRepository.save(prospect);
        emailProspectNotifyProcess(prospectReg);
        emailNotifyAllProcess(prospectReg);
        return prospect;
    }

    private void emailProspectNotifyProcess(ProspectRegDTO prospectReg) {
        Email email = new Email();
        HashMap<String, Object> props = new HashMap<>();
        props.put("name", prospectReg.getFirstName().toUpperCase());
        props.put("email", prospectReg.getEmail());
        email.setProperties(props);
        email.setTo(new String[] {prospectReg.getEmail()});
        email.setFrom("bridge-sme@gmail.com");
        email.setTemplate("registration.html");
        email.setSubject("Welcome Email from BridgeSME App");
        emailSenderUtility.sendHtmlMessage(email);
    }

    private void emailNotifyAllProcess(ProspectRegDTO prospectReg) {
        List<User> userList = userRepository.findAll();
        List<String> toEmails = userList.stream().map(User::getEmail).toList();
        Email email = new Email();
        HashMap<String, Object> props = new HashMap<>();
        props.put("name", prospectReg.getFirstName().toUpperCase());
        props.put("email", prospectReg.getEmail());
        props.put("phone", prospectReg.getPhone());
        email.setProperties(props);
        email.setTo(toEmails.toArray(new String[0]));
        email.setFrom("bridge-sme@gmail.com");
        email.setTemplate("notification.html");
        email.setSubject("New Prospect Created on BridgeSME App");
        emailSenderUtility.sendHtmlMessage(email);
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

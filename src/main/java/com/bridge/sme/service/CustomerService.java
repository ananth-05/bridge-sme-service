package com.bridge.sme.service;

import com.bridge.sme.dto.CustomerRegDTO;
import com.bridge.sme.entity.Customer;
import com.bridge.sme.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            customerRepository.findAll().forEach(customers::add);
            return customers;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    public Optional<Customer> getCustomerById(Integer id) {
        Optional<Customer> customerData = customerRepository.findById(id);
        return customerData;
    }

    public Customer updateCustomerById(Integer id, CustomerRegDTO customerReg) {
        Optional<Customer> customerData = customerRepository.findById(id);
        Customer customer = new Customer();
        if (customerData.isPresent()) {
            customer = customerData.get();
            customer.setFirstName(customerReg.getFirstName());
            customer.setLastName(customerReg.getLastName());
            customer.setPhone(customerReg.getPhone());
            customer.setTechStackId(customerReg.getPrimaryTechStackId());
            customer.setTimeZone(customerReg.getTimeZone());
            customer.setPreferredContactMethod(customerReg.getPreferredContactMethod());
            customer.setCreatedBy(customerReg.getCreatedBy());
        }
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }
}

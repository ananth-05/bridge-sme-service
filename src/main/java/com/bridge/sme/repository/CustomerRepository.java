package com.bridge.sme.repository;

import com.bridge.sme.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM SME.CUSTOMER WHERE EMAIL= :email", nativeQuery = true)
    public Customer findCustomerByEmail(@Param("email") String email);
}

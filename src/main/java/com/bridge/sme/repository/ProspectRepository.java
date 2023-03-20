package com.bridge.sme.repository;

import com.bridge.sme.entity.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProspectRepository extends JpaRepository<Prospect, Integer> {

    @Query(value = "SELECT * FROM SME.PROSPECT WHERE EMAIL= :email", nativeQuery = true)
    public Prospect findProspectCustomerByEmail(@Param("email") String email);
}

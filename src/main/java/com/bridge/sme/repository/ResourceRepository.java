package com.bridge.sme.repository;

import com.bridge.sme.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {

    @Query(value = "SELECT * FROM SME.RESOURCE WHERE EMAIL= :email", nativeQuery = true)
    public Resource findResourceByEmail(@Param("email") String email);
}

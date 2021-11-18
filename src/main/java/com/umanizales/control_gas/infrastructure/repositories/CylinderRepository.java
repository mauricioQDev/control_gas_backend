package com.umanizales.control_gas.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;

public interface CylinderRepository extends JpaRepository<Cylinder, String> {

    @Transactional
    @Modifying
    @Query("UPDATE Cylinder c " +
            "SET c.cylinderType = :#{#cylinder.cylinderType}," +
            "c.provider = :#{#cylinder.provider} WHERE c.id LIKE :#{#cylinder.id}")
    public int update(@Param("cylinder") Cylinder cylinder);
}

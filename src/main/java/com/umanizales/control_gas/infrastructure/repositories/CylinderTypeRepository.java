package com.umanizales.control_gas.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;

public interface CylinderTypeRepository extends JpaRepository<CylinderType, String> {
    @Transactional
    @Modifying
    @Query("UPDATE CylinderType ct " +
            "SET ct.capacity = :#{#cylinderType.capacity}," +
            "ct.price = :#{#cylinderType.price} WHERE ct.id LIKE :#{#cylinderType.id}")
    public int update(@Param("cylinderType") CylinderType cylinderType);
}

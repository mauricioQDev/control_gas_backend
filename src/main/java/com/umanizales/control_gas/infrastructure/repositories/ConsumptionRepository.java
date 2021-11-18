package com.umanizales.control_gas.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;

public interface ConsumptionRepository extends JpaRepository<Consumption, String> {

    @Transactional
    @Modifying
    @Query("UPDATE Consumption c SET c.startDate = :#{#consumption.startDate}, c.endDate = :#{#consumption.endDate} WHERE c.id LIKE :#{#consumption.id}")
    public int update(@Param("consumption") Consumption consumption);
}

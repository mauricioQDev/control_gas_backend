package com.umanizales.control_gas.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Transactional
    @Modifying
    @Query("UPDATE Customer c " +
            "SET c.name = :#{#customer.name}," +
            "c.lastName = :#{#customer.lastName}," +
            "c.email = :#{#customer.email}," +
            "c.address = :#{#customer.address}," +
            "c.phoneNumber = :#{#customer.phoneNumber}," +
            "c.password = :#{#customer.password} WHERE c.id LIKE :#{#customer.id}")
    public int update(@Param("customer") Customer customer);
}
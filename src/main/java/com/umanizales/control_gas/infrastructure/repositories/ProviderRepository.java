package com.umanizales.control_gas.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;

public interface ProviderRepository extends JpaRepository<Provider, String> {

    @Transactional
    @Modifying
    @Query("UPDATE Provider p SET p.name = :#{#provider.name} WHERE p.id LIKE :#{#provider.id}")
    public int update(@Param("provider") Provider provider);
}

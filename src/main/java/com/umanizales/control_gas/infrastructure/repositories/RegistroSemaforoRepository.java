package com.umanizales.control_gas.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface RegistroSemaforoRepository extends JpaRepository<RegistroSemaforo,Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE RegistroSemaforo r SET r.registro = :#{#registroSemaforo.registro} WHERE trim(r.id) LIKE :#{#registroSemaforo.id}")
    public int update(@Param("registroSemaforo") RegistroSemaforo registroSemaforo);
}

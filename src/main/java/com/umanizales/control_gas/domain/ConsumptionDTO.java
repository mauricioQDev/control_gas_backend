package com.umanizales.control_gas.domain;

import com.umanizales.control_gas.infrastructure.repositories.Customer;
import com.umanizales.control_gas.infrastructure.repositories.Cylinder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumptionDTO {

    private String id;

    private LocalDate startDate;

    private LocalDate endDate;

    private Cylinder cylinder;

    private Customer customer;
}

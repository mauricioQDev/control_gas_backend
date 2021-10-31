package com.umanizales.control_gas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CylinderTypeDTO {

    private String id;

    private int capacity;

    private double price;
}

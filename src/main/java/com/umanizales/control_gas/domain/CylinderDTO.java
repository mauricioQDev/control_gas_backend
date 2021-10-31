package com.umanizales.control_gas.domain;

import com.umanizales.control_gas.infrastructure.repositories.CylinderType;
import com.umanizales.control_gas.infrastructure.repositories.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CylinderDTO {

    private String id;

    private Provider provider;

    private CylinderType cylinderType;
}

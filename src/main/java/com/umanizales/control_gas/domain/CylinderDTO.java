package com.umanizales.control_gas.domain;

import com.umanizales.control_gas.infrastructure.repositories.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CylinderDTO {

    private String id;

    @NotNull(message = "Debe especificar el proveedor")
    private Provider provider;

    @NotNull(message = "Debe especificar el tipo de cilindro")
    private CylinderType cylinderType;
}

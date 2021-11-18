package com.umanizales.control_gas.domain;

import javax.validation.constraints.Positive;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CylinderTypeDTO {

    private String id;

    @Positive
    @NotNull(message = "Debe especificar la capacidad del cilindro")
    private int capacity;

    @Positive
    @NotNull(message = "Debe especificar el valor del cilindro")
    private double price;
}

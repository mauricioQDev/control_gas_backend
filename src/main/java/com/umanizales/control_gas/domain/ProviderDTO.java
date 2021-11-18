package com.umanizales.control_gas.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDTO {

    private String id;

    @NotNull(message = "Debe especificar el nombre del proveedor")
    @Size(min = 3, max = 50, message = "El nombre del proveedor debe tener minimo 3 caracteres y maximo 50")
    private String name;
}

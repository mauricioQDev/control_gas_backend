package com.umanizales.control_gas.domain;

import com.umanizales.control_gas.infrastructure.repositories.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumptionDTO {

    private String id;

    @NotNull(message = "El campo de inicio de fecha es obligatorio")
    @FutureOrPresent(message = "La fecha no puede ser anterior a la fecha actual")
    private LocalDate startDate;

    @PastOrPresent(message = "La fecha no puede ser superior a la actual")
    private LocalDate endDate;

    @NotNull(message = "El cilindro es obligatorio")
    private Cylinder cylinder;

    @NotNull(message = "El cliente es obligatorio")
    private Customer customer;
}

package com.umanizales.control_gas.domain;

import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String id;

    @NotNull(message = "El campo nombre no puede ser nulo")
    @Size(min = 3, max = 30, message = "El nombre tener minimo 3 caracteres y maximo 30")
    private String name;


    @NotNull(message = "El campo apellido no puede ser nulo")
    @Size(min = 3, max = 30, message = "El apellido tener minimo 3 caracteres y maximo 30")
    private String lastName;

    @NotNull(message = "El campo email no puede ser nulo")
    @Email(message = "Debe ingresar una dirección de correo electronico valida")
    @Size(min = 6, max = 50, message = "El correo electronico no puede superar los 50 caracteres")
    private String email;

    private String address;

    private String phoneNumber;

    @NotNull(message = "La contraseña no puede ser un campo nulo")
    @Size(min = 8, max = 20, message = "La contraseña debe contener como minimo 8 caracteres y maximo 20")
    private String password;

}

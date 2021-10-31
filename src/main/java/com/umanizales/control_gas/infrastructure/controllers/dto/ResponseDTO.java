package com.umanizales.control_gas.infrastructure.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDTO {

    private String message;
    private Object data;
    private List<ErrorDTO> errors;

}

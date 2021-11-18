package com.umanizales.control_gas.infrastructure.controllers;

import org.springframework.web.bind.MethodArgumentNotValidException;
import com.umanizales.control_gas.infrastructure.controllers.dto.*;
import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.postgresql.util.PSQLException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handle(MethodArgumentNotValidException ex) {
        List<ErrorDTO> listErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            listErrors.add(new ErrorDTO(HttpStatus.BAD_REQUEST.value(), fieldName + " " + errorMessage));
        });
        String message = "Algunos campos son inválidos o faltantes, por favor corrija los errores y vuelva a intentarlo";
        ResponseDTO response = new ResponseDTO(message, null, listErrors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<?> handle(DataIntegrityViolationException ex) {
        List<ErrorDTO> listErrors = new ArrayList<>();
        listErrors.add(new ErrorDTO(HttpStatus.BAD_REQUEST.value(), "La operación no se puede concretar por que hay realaciones con otros objetos"));
        ResponseDTO response = new ResponseDTO(ex.getMessage(), null, listErrors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ControlGasException.class)
    protected ResponseEntity<?> handle(ControlGasException ex) {
        ResponseDTO response = new ResponseDTO(ex.getMessage(), null, null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PSQLException.class)
    protected ResponseEntity<?> handle(PSQLException ex) {
        List<ErrorDTO> listErrors = new ArrayList<>();
        listErrors.add(new ErrorDTO(HttpStatus.BAD_REQUEST.value(), "Error de comunicación con la base de datos postgres"));
        ResponseDTO response = new ResponseDTO(ex.getMessage(), null, listErrors);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

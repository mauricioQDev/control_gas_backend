package com.umanizales.control_gas.infrastructure.controllers;

import com.umanizales.control_gas.infrastructure.controllers.dto.ResponseDTO;
import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import com.umanizales.control_gas.aplication.CustomerImpl;
import com.umanizales.control_gas.domain.CustomerDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(path = "/customer")
@CrossOrigin(origins = "https://mquinteroweb.pro2umanizales.com")
public class CustomerController {

    @Autowired
    private CustomerImpl customerImpl;

    @PostMapping

    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid CustomerDTO customerDTO) throws ControlGasException {
        return new ResponseEntity<>(new ResponseDTO("Success", customerImpl.save(customerDTO), null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> list() {
        return new ResponseEntity<>(new ResponseDTO("succes", customerImpl.list(), null), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid CustomerDTO customerDTO) throws ControlGasException {
        return new ResponseEntity<>(new ResponseDTO("succes", customerImpl.update(customerDTO), null), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public @ResponseBody
    ResponseEntity<ResponseDTO> delete(@PathVariable String id) throws ControlGasException {
        return new ResponseEntity<>(new ResponseDTO("succes", customerImpl.delete(id), null), HttpStatus.OK);
    }
}

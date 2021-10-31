package com.umanizales.control_gas.infrastructure.controllers;

import com.umanizales.control_gas.aplication.CustomerImpl;
import com.umanizales.control_gas.domain.CustomerDTO;
import com.umanizales.control_gas.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path ="/customer")
@Validated
public class CustomerController {

    @Autowired
    private CustomerImpl customerImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid CustomerDTO customerDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Success", customerImpl.save(customerDTO), null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return new ResponseEntity<>(new ResponseDTO("succes", customerImpl.list(), null), HttpStatus.OK);
    }
}

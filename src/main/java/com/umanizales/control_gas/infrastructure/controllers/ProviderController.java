package com.umanizales.control_gas.infrastructure.controllers;

import com.umanizales.control_gas.aplication.ProviderImpl;
import com.umanizales.control_gas.domain.ProviderDTO;
import com.umanizales.control_gas.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path ="/provider")
@Validated
public class ProviderController {

    @Autowired
    private ProviderImpl providerImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid ProviderDTO providerDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Success", providerImpl.save(providerDTO), null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return new ResponseEntity<>(new ResponseDTO("succes", providerImpl.list(), null), HttpStatus.OK);
    }
}

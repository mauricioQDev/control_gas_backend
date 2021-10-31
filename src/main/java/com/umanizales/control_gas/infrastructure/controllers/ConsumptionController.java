package com.umanizales.control_gas.infrastructure.controllers;

import com.umanizales.control_gas.aplication.ConsumptionImpl;
import com.umanizales.control_gas.domain.ConsumptionDTO;
import com.umanizales.control_gas.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path ="consumption")
@Validated
public class ConsumptionController {

    @Autowired
    private ConsumptionImpl consumtionImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid ConsumptionDTO consumptionDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Success", consumtionImpl.save(consumptionDTO), null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return new ResponseEntity<>(new ResponseDTO("succes", consumtionImpl.list(), null), HttpStatus.OK);
    }
}

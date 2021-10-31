package com.umanizales.control_gas.infrastructure.controllers;

import com.umanizales.control_gas.aplication.CylinderTypeImpl;
import com.umanizales.control_gas.domain.CylinderTypeDTO;
import com.umanizales.control_gas.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path ="cylinderType")
@Validated
public class CylinderTypeController {

    @Autowired
    private CylinderTypeImpl cylinderTypeImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid CylinderTypeDTO cylinderTypeDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Success", cylinderTypeImpl.save(cylinderTypeDTO), null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return new ResponseEntity<>(new ResponseDTO("succes", cylinderTypeImpl.list(), null), HttpStatus.OK);
    }
}

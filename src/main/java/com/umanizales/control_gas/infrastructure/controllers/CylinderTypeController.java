package com.umanizales.control_gas.infrastructure.controllers;

import com.umanizales.control_gas.infrastructure.controllers.dto.ResponseDTO;
import com.umanizales.control_gas.exception.ControlGasException;
import com.umanizales.control_gas.aplication.CylinderTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import com.umanizales.control_gas.domain.CylinderTypeDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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

    @PutMapping
    public @ResponseBody ResponseEntity<ResponseDTO> update(@RequestBody @Valid CylinderTypeDTO cylinderTypeDTO) throws ControlGasException{
        return new ResponseEntity<>(new ResponseDTO("succes", cylinderTypeImpl.update(cylinderTypeDTO), null), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public @ResponseBody ResponseEntity<ResponseDTO> delete(@PathVariable String id) throws ControlGasException {
        return new ResponseEntity<>(new ResponseDTO("succes", cylinderTypeImpl.delete(id), null), HttpStatus.OK);
    }
}

package com.umanizales.control_gas.infrastructure.controllers.parameters;

import com.umanizales.control_gas.domain.ProviderDTO;
import com.umanizales.control_gas.infrastructure.controllers.dto.ResponseDTO;
import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import com.umanizales.control_gas.aplication.CylinderImpl;
import com.umanizales.control_gas.domain.CylinderDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "cylinder")
@Validated
public class CylinderController {

    @Autowired
    private CylinderImpl cylinderImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid CylinderDTO cylinderDTO) {
        return new ResponseEntity<>(new ResponseDTO("Success", cylinderImpl.save(cylinderDTO), null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> list() {
        return new ResponseEntity<>(new ResponseDTO("succes", cylinderImpl.list(), null), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<ResponseDTO> update(@RequestBody @Valid CylinderDTO cylinderDTO) throws ControlGasException{
        return new ResponseEntity<>(new ResponseDTO("succes", cylinderImpl.update(cylinderDTO), null), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public @ResponseBody ResponseEntity<ResponseDTO> delete(@PathVariable String id) throws ControlGasException {
        return new ResponseEntity<>(new ResponseDTO("succes", cylinderImpl.delete(id), null), HttpStatus.OK);
    }
}

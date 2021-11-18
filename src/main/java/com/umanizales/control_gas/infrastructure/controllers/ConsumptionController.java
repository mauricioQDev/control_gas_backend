package com.umanizales.control_gas.infrastructure.controllers;

import com.umanizales.control_gas.infrastructure.controllers.dto.ResponseDTO;
import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.beans.factory.annotation.Autowired;
import com.umanizales.control_gas.aplication.ConsumptionImpl;
import org.springframework.validation.annotation.Validated;
import com.umanizales.control_gas.domain.ConsumptionDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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

    @PutMapping
    public @ResponseBody ResponseEntity<ResponseDTO> update(@RequestBody @Valid ConsumptionDTO consumptionDTO) throws ControlGasException{
        return new ResponseEntity<>(new ResponseDTO("succes", consumtionImpl.update(consumptionDTO), null), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public @ResponseBody ResponseEntity<ResponseDTO> delete(@PathVariable String id) throws ControlGasException {
        return new ResponseEntity<>(new ResponseDTO("succes", consumtionImpl.delete(id), null), HttpStatus.OK);
    }
}

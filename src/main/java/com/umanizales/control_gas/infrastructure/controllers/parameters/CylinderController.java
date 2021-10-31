package com.umanizales.control_gas.infrastructure.controllers.parameters;

import com.umanizales.control_gas.aplication.CylinderImpl;
import com.umanizales.control_gas.domain.CylinderDTO;
import com.umanizales.control_gas.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
}

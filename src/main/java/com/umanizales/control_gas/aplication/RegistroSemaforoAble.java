package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.RegistroSemaforoDTO;
import com.umanizales.control_gas.exception.ControlGasException;

import java.util.List;

public interface RegistroSemaforoAble {

    RegistroSemaforoDTO save(RegistroSemaforoDTO registroSemaforoDTO);
    List<RegistroSemaforoDTO> list();
}

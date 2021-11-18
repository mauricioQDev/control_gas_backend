package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.exception.ControlGasException;
import com.umanizales.control_gas.domain.ConsumptionDTO;
import java.util.List;

public interface ConsumptionAble {
    ConsumptionDTO save(ConsumptionDTO consumptionDTO);
    int update(ConsumptionDTO consumptionDTO) throws ControlGasException;
    boolean delete(String code) throws ControlGasException;
    List<ConsumptionDTO> list();
}

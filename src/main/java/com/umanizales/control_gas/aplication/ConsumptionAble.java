package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.ConsumptionDTO;

import java.util.List;

public interface ConsumptionAble {
    ConsumptionDTO save(ConsumptionDTO consumptionDTO);
    ConsumptionDTO update(ConsumptionDTO consumptionDTO);
    boolean delete(String code);
    List<ConsumptionDTO> list();
}

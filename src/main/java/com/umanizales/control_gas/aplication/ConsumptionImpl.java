package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.ConsumptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionImpl implements ConsumptionAble{

    @Autowired
    @Qualifier("PostgresConsumptionRepository")
    private ConsumptionAble consumptionPersistence;

    @Override
    public ConsumptionDTO save(ConsumptionDTO consumptionDTO) {
        return consumptionPersistence.save(consumptionDTO);
    }

    @Override
    public ConsumptionDTO update(ConsumptionDTO consumptionDTO) {
        return null;
    }

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public List<ConsumptionDTO> list() {
        return consumptionPersistence.list();
    }
}

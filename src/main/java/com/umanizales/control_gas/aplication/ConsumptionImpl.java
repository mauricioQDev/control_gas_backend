package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import com.umanizales.control_gas.domain.ConsumptionDTO;
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
    public int update(ConsumptionDTO consumptionDTO) throws ControlGasException{
        return consumptionPersistence.update(consumptionDTO);
    }

    @Override
    public boolean delete(String id) throws ControlGasException {
        return consumptionPersistence.delete(id);
    }

    @Override
    public List<ConsumptionDTO> list() {
        return consumptionPersistence.list();
    }
}

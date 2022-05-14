package com.umanizales.control_gas.infrastructure.adapters;

import com.umanizales.control_gas.infrastructure.repositories.*;
import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.umanizales.control_gas.aplication.ConsumptionAble;
import com.umanizales.control_gas.domain.ConsumptionDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

@Qualifier("PostgresConsumptionRepository")
@Repository("consumptionPersistence")
public class PostgresConsumptionRepository implements ConsumptionAble {

    @Autowired
    private ConsumptionRepository consumptionRepository;

    @Override
    public ConsumptionDTO save(ConsumptionDTO ConsumptionDTO) {
        return consumptionRepository.save(new Consumption(ConsumptionDTO)).toConsumptionDTO();
    }

    @Override
    public int update(ConsumptionDTO consumptionDTO) throws ControlGasException {
        if (consumptionRepository.existsById(consumptionDTO.getId())) {
            try {
                return consumptionRepository.update(new Consumption(consumptionDTO));
            } catch (DataIntegrityViolationException e) {
                throw new ControlGasException(e.getMessage());
            }
        } else throw new ControlGasException("El codigo a modificar no existe " + consumptionDTO.getId());
    }

    @Override
    public boolean delete(String id) throws ControlGasException {
        if (consumptionRepository.existsById(id)) {
            try {
                consumptionRepository.deleteById(id);
                return true;
            } catch (DataIntegrityViolationException e) {
                throw new ControlGasException(e.getMessage());
            }
        } else throw new ControlGasException("El codigo a borrar no existe " + id);

    }

    @Override
    public List<ConsumptionDTO> list() {
        //Stream y expresiones lamda
        List<Consumption> dogList = consumptionRepository.findAll();
        List ConsumptionDTOList = new ArrayList<>();
        for (Consumption consumption : dogList) {
            ConsumptionDTO toConsumptionDTO = consumption.toConsumptionDTO();
            ConsumptionDTOList.add(toConsumptionDTO);
        }
        return ConsumptionDTOList;
    }
}

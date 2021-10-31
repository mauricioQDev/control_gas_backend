package com.umanizales.control_gas.infrastructure.adapters;

import com.umanizales.control_gas.aplication.ConsumptionAble;
import com.umanizales.control_gas.domain.ConsumptionDTO;
import com.umanizales.control_gas.infrastructure.repositories.ConsumptionRepository;
import com.umanizales.control_gas.infrastructure.repositories.Consumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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
    public ConsumptionDTO update(ConsumptionDTO ConsumptionDTO) {
//        falta recibir el codigo
        return consumptionRepository.save(new Consumption(ConsumptionDTO)).toConsumptionDTO();
    }

    @Override
    public boolean delete(String code) {
        consumptionRepository.deleteById(code);
        return true;
    }

    @Override
    public List<ConsumptionDTO> list() {
        //Stream y expresiones lamda
        List<Consumption> dogList = consumptionRepository.findAll();

       List<ConsumptionDTO> ConsumptionDTOList = dogList.stream().map(Consumption::toConsumptionDTO).collect(Collectors.toList());

//        List<ConsumptionDTO> ConsumptionDTOList = new ArrayList<>();
//        for (Consumption dog:dogList) {
//            ConsumptionDTOList.add(dog.toConsumptionDTO());
//        }
        return ConsumptionDTOList;
    }
}

package com.umanizales.control_gas.infrastructure.adapters;

import com.umanizales.control_gas.aplication.RegistroSemaforoAble;
import com.umanizales.control_gas.domain.RegistroSemaforoDTO;
import com.umanizales.control_gas.exception.ControlGasException;
import com.umanizales.control_gas.infrastructure.repositories.RegistroSemaforo;
import com.umanizales.control_gas.infrastructure.repositories.RegistroSemaforoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresRegistroSemaforoRepository")
@Repository("registroSemaforoPersistence")
public class PostgresRegistroSemaforoRepository implements RegistroSemaforoAble {

    @Autowired
    private RegistroSemaforoRepository registroSemaforoRepository;


    @Override
    public RegistroSemaforoDTO save(RegistroSemaforoDTO registroSemaforoDTO) {
        return registroSemaforoRepository.save(new RegistroSemaforo(registroSemaforoDTO)).toRegistroSemaforoDTO();
    }

    @Override
    public List<RegistroSemaforoDTO> list() {
        List<RegistroSemaforo> registrosList = registroSemaforoRepository.findAll();
        List registroSemaforoList = new ArrayList<>();
        for (RegistroSemaforo registroSemaforo : registrosList) {
            RegistroSemaforoDTO toRegistroSemaforoDTO = registroSemaforo.toRegistroSemaforoDTO();
            registroSemaforoList.add(toRegistroSemaforoDTO);
        }
        return registroSemaforoList;
    }
}

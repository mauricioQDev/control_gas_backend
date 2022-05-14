package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.RegistroSemaforoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegistroSemaforoImpl implements RegistroSemaforoAble{
    @Autowired
    @Qualifier("PostgresRegistroSemaforoRepository")
    private RegistroSemaforoAble registroSemaforoPersistence;

    @Override
    public RegistroSemaforoDTO save(RegistroSemaforoDTO registroSemaforoDTO) {
        return registroSemaforoPersistence.save(registroSemaforoDTO);
    }

    @Override
    public List<RegistroSemaforoDTO> list() {
        return registroSemaforoPersistence.list();
    }
//    @Override
//    public int update(RegistroSemaforoDTO registroSemaforoDTO) throws ControlGasException {
//        return registroSemaforoPersistence.update(registroSemaforoDTO);
//    }
//
//    @Override
//    public boolean delete(String id) throws ControlGasException {
//
//        return registroSemaforoPersistence.delete(id);
//    }
//
}

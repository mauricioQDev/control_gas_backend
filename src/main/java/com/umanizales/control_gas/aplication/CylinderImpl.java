package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.umanizales.control_gas.domain.CylinderDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CylinderImpl implements CylinderAble{

    @Autowired
    @Qualifier("PostgresCylinderRepository")
    private CylinderAble cylinderPersistence;

    @Override
    public CylinderDTO save(CylinderDTO cylinderDTO) {
        return cylinderPersistence.save(cylinderDTO);
    }

    @Override
    public int update(CylinderDTO cylinderDTO)throws ControlGasException {
        return cylinderPersistence.update(cylinderDTO);
    }

    @Override
    public boolean delete(String id) throws ControlGasException {
        return cylinderPersistence.delete(id);
    }

    @Override
    public List<CylinderDTO> list() {
        return cylinderPersistence.list();
    }
}

package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.umanizales.control_gas.domain.CylinderTypeDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CylinderTypeImpl implements CylinderTypeAble{

    @Autowired
    @Qualifier("PostgresCylinderTypeRepository")
    private CylinderTypeAble cylinderTypePersistence;

    @Override
    public CylinderTypeDTO save(CylinderTypeDTO cylinderTypeDTO) {
        return cylinderTypePersistence.save(cylinderTypeDTO);
    }

    @Override
    public int update(CylinderTypeDTO cylinderTypeDTO) throws ControlGasException {
        return cylinderTypePersistence.update(cylinderTypeDTO);
    }

    @Override
    public boolean delete(String id) throws ControlGasException {
        return cylinderTypePersistence.delete(id);
    }

    @Override
    public List<CylinderTypeDTO> list() {
        return cylinderTypePersistence.list();
    }
}

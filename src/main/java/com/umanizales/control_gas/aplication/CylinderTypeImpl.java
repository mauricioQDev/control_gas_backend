package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.CylinderTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CylinderTypeImpl implements CylinderTypeAble{

    @Autowired
    @Qualifier("PostgresCylinderTypeRepository")
    private CylinderTypeAble cylinderTypeAble;

    @Override
    public CylinderTypeDTO save(CylinderTypeDTO cylinderTypeDTO) {
        return cylinderTypeAble.save(cylinderTypeDTO);
    }

    @Override
    public CylinderTypeDTO update(CylinderTypeDTO cylinderTypeDTO) {
        return null;
    }

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public List<CylinderTypeDTO> list() {
        return cylinderTypeAble.list();
    }
}

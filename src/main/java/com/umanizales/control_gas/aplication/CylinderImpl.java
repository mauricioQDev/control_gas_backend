package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.CylinderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CylinderImpl implements CylinderAble{

    @Autowired
    @Qualifier("PostgresCylinderRepository")
    private CylinderAble cylinderAble;

    @Override
    public CylinderDTO save(CylinderDTO cylinderDTO) {
        return cylinderAble.save(cylinderDTO);
    }

    @Override
    public CylinderDTO update(CylinderDTO cylinderDTO) {
        return null;
    }

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public List<CylinderDTO> list() {
        return cylinderAble.list();
    }
}

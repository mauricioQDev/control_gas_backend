package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.CylinderTypeDTO;

import java.util.List;

public interface CylinderTypeAble {
    CylinderTypeDTO save(CylinderTypeDTO cylinderTypeDTO);
    CylinderTypeDTO update(CylinderTypeDTO cylinderTypeDTO);
    boolean delete(String code);
    List<CylinderTypeDTO> list();
}

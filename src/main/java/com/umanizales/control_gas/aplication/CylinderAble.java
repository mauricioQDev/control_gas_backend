package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.CylinderDTO;

import java.util.List;

public interface CylinderAble {
    CylinderDTO save(CylinderDTO CylinderDTO);
    CylinderDTO update(CylinderDTO CylinderDTO);
    boolean delete(String code);
    List<CylinderDTO> list();
}

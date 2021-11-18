package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.exception.ControlGasException;
import com.umanizales.control_gas.domain.CylinderTypeDTO;
import java.util.List;

public interface CylinderTypeAble {
    CylinderTypeDTO save(CylinderTypeDTO cylinderTypeDTO);
    int update(CylinderTypeDTO cylinderTypeDTO) throws ControlGasException;
    boolean delete(String code) throws ControlGasException;
    List<CylinderTypeDTO> list();
}

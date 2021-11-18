package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.exception.ControlGasException;
import com.umanizales.control_gas.domain.CylinderDTO;
import java.util.List;

public interface CylinderAble {
    CylinderDTO save(CylinderDTO CylinderDTO);
    int update(CylinderDTO CylinderDTO) throws ControlGasException;
    boolean delete(String code) throws ControlGasException;
    List<CylinderDTO> list();
}

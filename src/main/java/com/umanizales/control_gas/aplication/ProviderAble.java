package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.exception.ControlGasException;
import com.umanizales.control_gas.domain.ProviderDTO;
import java.util.List;

public interface ProviderAble {
    ProviderDTO save(ProviderDTO providerDTO);
    int update(ProviderDTO providerDTO) throws ControlGasException;
    boolean delete(String code) throws ControlGasException;
    List<ProviderDTO> list();
}

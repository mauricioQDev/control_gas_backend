package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.ProviderDTO;

import java.util.List;

public interface ProviderAble {
    ProviderDTO save(ProviderDTO providerDTO);
    ProviderDTO update(ProviderDTO providerDTO);
    boolean delete(String code);
    List<ProviderDTO> list();
}

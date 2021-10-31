package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.ProviderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderImpl implements ProviderAble{

    @Autowired
    @Qualifier("PostgresProviderRepository")
    private ProviderAble providerAble;
    
    @Override
    public ProviderDTO save(ProviderDTO providerDTO) {
        return providerAble.save(providerDTO);
    }

    @Override
    public ProviderDTO update(ProviderDTO providerDTO) {
        return null;
    }

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public List<ProviderDTO> list() {
        return providerAble.list();
    }
}

package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.umanizales.control_gas.domain.ProviderDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProviderImpl implements ProviderAble{

    @Autowired
    @Qualifier("PostgresProviderRepository")
    private ProviderAble providerPersistence;
    
    @Override
    public ProviderDTO save(ProviderDTO providerDTO) {
        return providerPersistence.save(providerDTO);
    }

    @Override
    public int update(ProviderDTO providerDTO) throws ControlGasException {
        return providerPersistence.update(providerDTO);
    }

    @Override
    public boolean delete(String id) throws ControlGasException {

        return providerPersistence.delete(id);
    }

    @Override
    public List<ProviderDTO> list() {
        return providerPersistence.list();
    }
}

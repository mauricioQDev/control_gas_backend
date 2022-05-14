package com.umanizales.control_gas.infrastructure.adapters;

import com.umanizales.control_gas.infrastructure.repositories.ProviderRepository;
import com.umanizales.control_gas.infrastructure.repositories.Provider;
import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.umanizales.control_gas.aplication.ProviderAble;
import com.umanizales.control_gas.domain.ProviderDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresProviderRepository")
@Repository("providerPersistence")
public class PostgresProviderRepository implements ProviderAble {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public ProviderDTO save(ProviderDTO providerDTO) {
        return providerRepository.save(new Provider(providerDTO)).toProviderDTO();
    }

    @Override
    public int update(ProviderDTO providerDTO) throws ControlGasException {
        if (providerRepository.existsById(providerDTO.getId())){
            try {
                return providerRepository.update(new Provider(providerDTO));
            }catch(DataIntegrityViolationException e){
                throw new ControlGasException(e.getMessage());
            }
        }else throw new ControlGasException("El codigo a modificar no existe " + providerDTO.getId());
    }

    @Override
    public boolean delete(String id) throws ControlGasException {
        if (providerRepository.existsById(id)) {
            try {
                providerRepository.deleteById(id);
                return true;
            }catch(DataIntegrityViolationException e){
                throw new ControlGasException(e.getMessage());
            }
        } else throw new ControlGasException("El codigo a borrar no existe " + id);
    }

    @Override
    public List<ProviderDTO> list() {
        //Stream y expresiones lamda
        List<Provider> dogList = providerRepository.findAll();
        List ProviderDTOList = new ArrayList<>();
        for (Provider provider : dogList) {
            ProviderDTO toProviderDTO = provider.toProviderDTO();
            ProviderDTOList.add(toProviderDTO);
        }
        return ProviderDTOList;
    }
}

package com.umanizales.control_gas.infrastructure.adapters;

import com.umanizales.control_gas.aplication.ProviderAble;
import com.umanizales.control_gas.domain.ProviderDTO;
import com.umanizales.control_gas.infrastructure.repositories.Provider;
import com.umanizales.control_gas.infrastructure.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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
    public ProviderDTO update(ProviderDTO providerDTO) {
//        falta recibir el codigo
        return providerRepository.save(new Provider(providerDTO)).toProviderDTO();
    }

    @Override
    public boolean delete(String code) {
        providerRepository.deleteById(code);
        return true;
    }

    @Override
    public List<ProviderDTO> list() {
        //Stream y expresiones lamda
        List<Provider> dogList = providerRepository.findAll();

       List<ProviderDTO> ProviderDTOList = dogList.stream().map(Provider::toProviderDTO).collect(Collectors.toList());

//        List<ProviderDTO> ProviderDTOList = new ArrayList<>();
//        for (Provider dog:dogList) {
//            ProviderDTOList.add(dog.toProviderDTO());
//        }
        return ProviderDTOList;
    }
}

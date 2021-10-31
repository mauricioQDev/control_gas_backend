package com.umanizales.control_gas.infrastructure.adapters;

import com.umanizales.control_gas.aplication.CylinderTypeAble;
import com.umanizales.control_gas.domain.CylinderTypeDTO;
import com.umanizales.control_gas.infrastructure.repositories.CylinderType;
import com.umanizales.control_gas.infrastructure.repositories.CylinderTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Qualifier("PostgresCylinderTypeRepository")
@Repository("cylinderTypePersistence")
public class PostgresCylinderTypeRepository implements CylinderTypeAble {

    @Autowired
    private CylinderTypeRepository cylindertypeRepository;

    @Override
    public CylinderTypeDTO save(CylinderTypeDTO CylinderTypeDTO) {
        return cylindertypeRepository.save(new CylinderType(CylinderTypeDTO)).toCylinderTypeDTO();
    }

    @Override
    public CylinderTypeDTO update(CylinderTypeDTO CylinderTypeDTO) {
//        falta recibir el codigo
        return cylindertypeRepository.save(new CylinderType(CylinderTypeDTO)).toCylinderTypeDTO();
    }

    @Override
    public boolean delete(String code) {
        cylindertypeRepository.deleteById(code);
        return true;
    }

    @Override
    public List<CylinderTypeDTO> list() {
        //Stream y expresiones lamda
        List<CylinderType> dogList = cylindertypeRepository.findAll();

       List<CylinderTypeDTO> CylinderTypeDTOList = dogList.stream().map(CylinderType::toCylinderTypeDTO).collect(Collectors.toList());

//        List<CylinderTypeDTO> CylinderTypeDTOList = new ArrayList<>();
//        for (CylinderType dog:dogList) {
//            CylinderTypeDTOList.add(dog.toCylinderTypeDTO());
//        }
        return CylinderTypeDTOList;
    }
}

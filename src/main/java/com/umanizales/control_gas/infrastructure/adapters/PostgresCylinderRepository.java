package com.umanizales.control_gas.infrastructure.adapters;

import com.umanizales.control_gas.aplication.CylinderAble;
import com.umanizales.control_gas.aplication.CylinderAble;
import com.umanizales.control_gas.domain.CylinderDTO;
import com.umanizales.control_gas.infrastructure.repositories.Cylinder;
import com.umanizales.control_gas.infrastructure.repositories.CylinderRepository;
import com.umanizales.control_gas.infrastructure.repositories.CylinderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Qualifier("PostgresCylinderRepository")
@Repository("cylinderPersistence")
public class PostgresCylinderRepository implements CylinderAble {

    @Autowired
    private CylinderRepository cylinderRepository;

    @Override
    public CylinderDTO save(CylinderDTO cylinderDTO) {
        return cylinderRepository.save(new Cylinder(cylinderDTO)).toCylinderDTO();
    }

    @Override
    public CylinderDTO update(CylinderDTO cylinderDTO) {
//        falta recibir el codigo
        return cylinderRepository.save(new Cylinder(cylinderDTO)).toCylinderDTO();
    }

    @Override
    public boolean delete(String code) {
        cylinderRepository.deleteById(code);
        return true;
    }

    @Override
    public List<CylinderDTO> list() {
        //Stream y expresiones lamda
        List<Cylinder> customerList = cylinderRepository.findAll();

       List<CylinderDTO> cylinderDTOList = customerList.stream().map(Cylinder::toCylinderDTO).collect(Collectors.toList());

//        List<CylinderDTO> cylinderDTOList = new ArrayList<>();
//        for (Cylinder dog:customerList) {
//            cylinderDTOList.add(dog.toCylinderDTO());
//        }
        return cylinderDTOList;
    }
}

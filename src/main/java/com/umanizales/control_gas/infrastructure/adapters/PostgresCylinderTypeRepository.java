package com.umanizales.control_gas.infrastructure.adapters;

import com.umanizales.control_gas.infrastructure.repositories.*;
import com.umanizales.control_gas.exception.ControlGasException;
import com.umanizales.control_gas.aplication.CylinderTypeAble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.umanizales.control_gas.domain.CylinderTypeDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

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
    public int update(CylinderTypeDTO cylinderTypeDTO) throws ControlGasException {
        if (cylindertypeRepository.existsById(cylinderTypeDTO.getId())) {
            try {
                return cylindertypeRepository.update(new CylinderType(cylinderTypeDTO));
            } catch (DataIntegrityViolationException e) {
                throw new ControlGasException(e.getMessage());
            }
        } else throw new ControlGasException("El codigo a modificar no existe " + cylinderTypeDTO.getId());
    }

    @Override
    public boolean delete(String id) throws ControlGasException {
        if (cylindertypeRepository.existsById(id)) {
            try {
                cylindertypeRepository.deleteById(id);
                return true;
            } catch (DataIntegrityViolationException e) {
                throw new ControlGasException(e.getMessage());
            }
        } else throw new ControlGasException("El codigo a borrar no existe " + id);
    }

    @Override
    public List<CylinderTypeDTO> list() {
        //Stream y expresiones lamda
        List<CylinderType> dogList = cylindertypeRepository.findAll();
        List CylinderTypeDTOList = new ArrayList<>();
        for (CylinderType cylinderType : dogList) {
            CylinderTypeDTO toCylinderTypeDTO = cylinderType.toCylinderTypeDTO();
            CylinderTypeDTOList.add(toCylinderTypeDTO);
        }
        return CylinderTypeDTOList;
    }
}

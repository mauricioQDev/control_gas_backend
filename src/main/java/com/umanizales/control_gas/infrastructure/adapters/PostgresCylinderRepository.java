package com.umanizales.control_gas.infrastructure.adapters;

import com.umanizales.control_gas.infrastructure.repositories.*;
import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.umanizales.control_gas.aplication.CylinderAble;
import com.umanizales.control_gas.domain.CylinderDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

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
    public int update(CylinderDTO cylinderDTO) throws ControlGasException {
        if (cylinderRepository.existsById(cylinderDTO.getId())){
            try {
                return cylinderRepository.update(new Cylinder(cylinderDTO));
            } catch (DataIntegrityViolationException e) {
                throw new ControlGasException(e.getMessage());
            }
        }else throw new ControlGasException("El codigo a modificar no existe " + cylinderDTO.getId());
    }

    @Override
    public boolean delete(String id) throws ControlGasException {
        if (cylinderRepository.existsById(id)) {
            try {
                cylinderRepository.deleteById(id);
                return true;
            } catch (DataIntegrityViolationException e) {
                throw new ControlGasException(e.getMessage());
            }
        } else throw new ControlGasException("El codigo a borrar no existe " + id);
    }

    @Override
    public List<CylinderDTO> list() {
        //Stream y expresiones lamda
        List<Cylinder> customerList = cylinderRepository.findAll();
        List cylinderDTOList = new ArrayList<>();
        for (Cylinder cylinder : customerList) {
            CylinderDTO toCylinderDTO = cylinder.toCylinderDTO();
            cylinderDTOList.add(toCylinderDTO);
        }
        return cylinderDTOList;
    }
}

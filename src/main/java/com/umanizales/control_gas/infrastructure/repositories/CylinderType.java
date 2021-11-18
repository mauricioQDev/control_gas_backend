package com.umanizales.control_gas.infrastructure.repositories;

import com.umanizales.control_gas.domain.CylinderTypeDTO;
import org.springframework.beans.BeanUtils;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "cylinder_type", schema = "public", catalog = "control_gas")
public class CylinderType {

    @Id
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @Basic
    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;

    public CylinderType(CylinderTypeDTO cylinderTypeDTO) {
        BeanUtils.copyProperties(cylinderTypeDTO, this);
        if (cylinderTypeDTO.getId() == null) this.id = UUID.randomUUID().toString();
    }

    public CylinderTypeDTO toCylinderTypeDTO(){
        CylinderTypeDTO cylinderTypeDTO = new CylinderTypeDTO();
        BeanUtils.copyProperties(this, cylinderTypeDTO);
        return cylinderTypeDTO;
    }
}

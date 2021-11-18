package com.umanizales.control_gas.infrastructure.repositories;

import com.umanizales.control_gas.domain.CylinderDTO;
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
public class Cylinder {

    @Id
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @ManyToOne
    @JoinColumn(name = "provider", referencedColumnName = "id", nullable = false)
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "cylinder_type", referencedColumnName = "id", nullable = false)
    private CylinderType cylinderType;

    public Cylinder(CylinderDTO cylinderDTO) {
        BeanUtils.copyProperties(cylinderDTO, this);
        if (cylinderDTO.getId() == null) this.id = UUID.randomUUID().toString();
    }

    public CylinderDTO toCylinderDTO(){
        CylinderDTO cylinderDTO = new CylinderDTO();
        BeanUtils.copyProperties(this, cylinderDTO);
        return cylinderDTO;
    }
}

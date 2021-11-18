package com.umanizales.control_gas.infrastructure.repositories;

import com.umanizales.control_gas.domain.ConsumptionDTO;
import org.springframework.beans.BeanUtils;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Consumption {
    @Id
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @Basic
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Basic
    @Column(name = "end_date", nullable = true)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "cylinder", referencedColumnName = "id", nullable = false)
    private Cylinder cylinder;

    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "id", nullable = false)
    private Customer customer;

    public Consumption(ConsumptionDTO consumptionDTO) {
        BeanUtils.copyProperties(consumptionDTO, this);
        if (consumptionDTO.getId() == null)this.id = UUID.randomUUID().toString();
    }

    public ConsumptionDTO toConsumptionDTO(){
        ConsumptionDTO consumptionDTO = new ConsumptionDTO();
        BeanUtils.copyProperties(this, consumptionDTO);
        return consumptionDTO;
    }
}

package com.umanizales.control_gas.infrastructure.repositories;

import com.umanizales.control_gas.domain.ConsumptionDTO;
import com.umanizales.control_gas.domain.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

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
        this.id = UUID.randomUUID().toString();
    }

    public ConsumptionDTO toConsumptionDTO(){
        ConsumptionDTO consumptionDTO = new ConsumptionDTO();
        BeanUtils.copyProperties(this, consumptionDTO);
        return consumptionDTO;
    }
}

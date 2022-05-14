package com.umanizales.control_gas.infrastructure.repositories;

import com.umanizales.control_gas.domain.RegistroSemaforoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registro_semaforo", schema = "public", catalog = "control_gas")
public class RegistroSemaforo {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "registro", nullable = true)
    private String registro;

    public RegistroSemaforo(RegistroSemaforoDTO registroSemaforoDTO) {
    }

    public RegistroSemaforoDTO toRegistroSemaforoDTO(){
        RegistroSemaforoDTO registroSemaforoDTO = new RegistroSemaforoDTO();
        BeanUtils.copyProperties(this, registroSemaforoDTO);
        return registroSemaforoDTO;
    }
}

package com.umanizales.control_gas.infrastructure.repositories;

import com.umanizales.control_gas.domain.ProviderDTO;
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
public class Provider {

    @Id
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public Provider(ProviderDTO providerDTO) {
        BeanUtils.copyProperties(providerDTO, this);
        if (providerDTO.getId() == null) this.id = UUID.randomUUID().toString();
    }

    public ProviderDTO toProviderDTO(){
        ProviderDTO providerDTO = new ProviderDTO();
        BeanUtils.copyProperties(this, providerDTO);
        return providerDTO;
    }
}

package com.umanizales.control_gas.infrastructure.repositories;

import com.umanizales.control_gas.domain.CustomerDTO;
import org.springframework.beans.BeanUtils;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.Id;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    @Id
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Basic
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Basic
    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Basic
    @Column(name = "address", nullable = true, length = 70)
    private String address;

    @Basic
    @Column(name = "phone_number", nullable = true, length = 30)
    private String phoneNumber;

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    public Customer(CustomerDTO customerDTO) {
        BeanUtils.copyProperties(customerDTO, this);
        if (customerDTO.getId() == null) this.id = UUID.randomUUID().toString();
    }
    
    public CustomerDTO toCustomerDTO(){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(this, customerDTO);
        return customerDTO;
    }
}

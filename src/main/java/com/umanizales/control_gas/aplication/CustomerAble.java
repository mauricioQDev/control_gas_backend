package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.CustomerDTO;

import java.util.List;

public interface CustomerAble {

    CustomerDTO save(CustomerDTO customerDTO);
    CustomerDTO update(CustomerDTO customerDTO);
    boolean delete(String code);
    List<CustomerDTO> list();
}

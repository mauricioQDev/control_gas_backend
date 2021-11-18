package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.exception.ControlGasException;
import com.umanizales.control_gas.domain.CustomerDTO;
import java.util.List;

public interface CustomerAble {

    CustomerDTO save(CustomerDTO customerDTO) throws ControlGasException;
    int update(CustomerDTO customerDTO) throws ControlGasException;
    boolean delete(String code) throws ControlGasException;
    List<CustomerDTO> list();
    public boolean checkEmail(CustomerDTO customerDTO);
}

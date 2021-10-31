package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.domain.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerImpl implements CustomerAble {

    @Autowired
    @Qualifier("PostgresCustomerRepository")
    private CustomerAble customerAble;

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        return customerAble.save(customerDTO);
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public List<CustomerDTO> list() {
        return customerAble.list();
    }
}

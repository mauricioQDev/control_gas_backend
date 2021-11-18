package com.umanizales.control_gas.aplication;

import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.umanizales.control_gas.domain.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerImpl implements CustomerAble {

    @Autowired
    @Qualifier("PostgresCustomerRepository")
    private CustomerAble customerPersistence;

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) throws ControlGasException {
        return customerPersistence.save(customerDTO);
    }

    @Override
    public int update(CustomerDTO customerDTO) throws ControlGasException {
        return customerPersistence.update(customerDTO);
    }

    @Override
    public boolean delete(String id) throws ControlGasException {
        return customerPersistence.delete(id);
    }

    @Override
    public List<CustomerDTO> list() {
        return customerPersistence.list();
    }

    @Override
    public boolean checkEmail(CustomerDTO customerDTO) {
        customerPersistence.list();
        return true;
    }
}

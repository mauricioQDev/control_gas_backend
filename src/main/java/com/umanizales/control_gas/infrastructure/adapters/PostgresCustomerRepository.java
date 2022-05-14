package com.umanizales.control_gas.infrastructure.adapters;

import com.umanizales.control_gas.infrastructure.repositories.*;
import com.umanizales.control_gas.exception.ControlGasException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.umanizales.control_gas.aplication.CustomerAble;
import com.umanizales.control_gas.domain.CustomerDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

@Qualifier("PostgresCustomerRepository")
@Repository("customerPersistence")
public class PostgresCustomerRepository implements CustomerAble {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) throws ControlGasException{
        if (!checkEmail(customerDTO)){
            return customerRepository.save(new Customer(customerDTO)).toCustomerDTO();
        }else throw new ControlGasException("El correo electronico ya esta en uso");
    }

    @Override
    public int update(CustomerDTO customerDTO) throws ControlGasException {
        if (customerRepository.existsById(customerDTO.getId())) {
            try {
                return customerRepository.update(new Customer(customerDTO));
            } catch (DataIntegrityViolationException e) {
                throw new ControlGasException(e.getMessage());
            }
        } else throw new ControlGasException("El codigo a modificar no existe " + customerDTO.getId());
    }

    @Override
    public boolean delete(String id) throws ControlGasException {
        if (customerRepository.existsById(id)) {
            try {
                customerRepository.deleteById(id);
                return true;
            } catch (DataIntegrityViolationException e) {
                throw new ControlGasException(e.getMessage());
            }
        } else throw new ControlGasException("El codigo a borrar no existe " + id);
    }

    @Override
    public List<CustomerDTO> list() {
        //Stream y expresiones lamda
        List<Customer> customerList = customerRepository.findAll();
        List customerDTOList = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDTO toCustomerDTO = customer.toCustomerDTO();
            customerDTOList.add(toCustomerDTO);
        }
        return customerDTOList;
    }

    @Override
    public boolean checkEmail(CustomerDTO customerDTO) {
        List<CustomerDTO> customerDTOList = list();
        for (CustomerDTO c: customerDTOList) {
            if (c.getEmail().equals(customerDTO.getEmail())) return true;
        }
        return false;
    }

}

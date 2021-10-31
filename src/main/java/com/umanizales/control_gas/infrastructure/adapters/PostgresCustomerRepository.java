package com.umanizales.control_gas.infrastructure.adapters;

import com.umanizales.control_gas.aplication.CustomerAble;
import com.umanizales.control_gas.domain.CustomerDTO;
import com.umanizales.control_gas.infrastructure.repositories.Customer;
import com.umanizales.control_gas.infrastructure.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Qualifier("PostgresCustomerRepository")
@Repository("customerPersistence")
public class PostgresCustomerRepository implements CustomerAble {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        return customerRepository.save(new Customer(customerDTO)).toCustomerDTO();
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
//        falta recibir el codigo
        return customerRepository.save(new Customer(customerDTO)).toCustomerDTO();
    }

    @Override
    public boolean delete(String code) {
        customerRepository.deleteById(code);
        return true;
    }

    @Override
    public List<CustomerDTO> list() {
        //Stream y expresiones lamda
        List<Customer> customerList = customerRepository.findAll();

       List<CustomerDTO> customerDTOList = customerList.stream().map(Customer::toCustomerDTO).collect(Collectors.toList());

//        List<CustomerDTO> customerDTOList = new ArrayList<>();
//        for (Customer dog:customerList) {
//            customerDTOList.add(dog.toCustomerDTO());
//        }
        return customerDTOList;
    }
}

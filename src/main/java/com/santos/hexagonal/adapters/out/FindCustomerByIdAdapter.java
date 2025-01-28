package com.santos.hexagonal.adapters.out;

import com.santos.hexagonal.adapters.out.repository.CustomerRepository;
import com.santos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.santos.hexagonal.application.core.domain.Customer;
import com.santos.hexagonal.application.ports.out.FindCustomerBByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerBByIdOutputPort {

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);

        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }

}

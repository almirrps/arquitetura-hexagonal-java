package com.santos.hexagonal.adapters.out;

import com.santos.hexagonal.adapters.out.repository.CustomerRepository;
import com.santos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.santos.hexagonal.application.core.domain.Customer;
import com.santos.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);

        customerRepository.save(customerEntity);
    }

}

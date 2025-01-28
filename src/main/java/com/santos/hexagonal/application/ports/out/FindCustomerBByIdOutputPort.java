package com.santos.hexagonal.application.ports.out;

import com.santos.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerBByIdOutputPort {

    Optional<Customer> find(String id);

}

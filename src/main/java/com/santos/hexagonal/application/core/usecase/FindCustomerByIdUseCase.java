package com.santos.hexagonal.application.core.usecase;

import com.santos.hexagonal.application.core.domain.Customer;
import com.santos.hexagonal.application.ports.out.FindCustomerBByIdOutputPort;

public class FindCustomerByIdUseCase {

    private final FindCustomerBByIdOutputPort findCustomerBByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerBByIdOutputPort findCustomerBByIdOutputPort) {
        this.findCustomerBByIdOutputPort = findCustomerBByIdOutputPort;
    }

    public Customer find(String id) {
        return findCustomerBByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found."));
    }

}

package com.santos.hexagonal.adapters.in.controller;

import com.santos.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.santos.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.santos.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.santos.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.santos.hexagonal.application.ports.in.InsertCustomerInputPort;
import feign.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);

        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);

        return ResponseEntity.ok().body(customerResponse);
    }

}

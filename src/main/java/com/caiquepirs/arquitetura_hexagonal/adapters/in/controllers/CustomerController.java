package com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers;

import com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers.request.CustomerMapper;
import com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers.request.CustomerRequest;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.CustomerUseCaseInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerUseCaseInputPort CustomerUseCaseInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest request){
        Customer customer = customerMapper.toEntity(request);
        CustomerUseCaseInputPort.insert(customer, request.getZipCode());
        return ResponseEntity.ok().build();
    }


}

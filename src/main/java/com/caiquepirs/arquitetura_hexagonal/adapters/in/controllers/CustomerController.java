package com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers;

import com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers.request.CustomerMapper;
import com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers.request.CustomerRequest;
import com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers.response.CustomerResponse;
import com.caiquepirs.arquitetura_hexagonal.adapters.out.DeleteCustomerUseCase;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.CustomerUseCaseInputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerUseCaseInputPort CustomerUseCaseInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerInputPort deleteCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest request){
        Customer customer = customerMapper.toEntity(request);
        CustomerUseCaseInputPort.insert(customer, request.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    ResponseEntity<CustomerResponse> find(@PathVariable String id){
        Customer customer = findCustomerByIdInputPort.find(id);
        return ResponseEntity.ok(customerMapper.toResponse(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody @Valid CustomerRequest request){
        Customer customer = customerMapper.toEntity(request);
        customer.setId(id);
        updateCustomerInputPort.update(customer, request.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        deleteCustomerInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}

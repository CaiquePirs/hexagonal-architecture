package com.caiquepirs.arquitetura_hexagonal.adapters.out;

import com.caiquepirs.arquitetura_hexagonal.adapters.out.repository.CustomerRepository;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.DeleteCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}

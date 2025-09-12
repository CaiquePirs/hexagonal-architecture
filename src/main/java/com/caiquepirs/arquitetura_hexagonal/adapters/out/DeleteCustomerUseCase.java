package com.caiquepirs.arquitetura_hexagonal.adapters.out;

import com.caiquepirs.arquitetura_hexagonal.adapters.out.repository.CustomerRepository;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.DeleteCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerUseCase implements DeleteCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}

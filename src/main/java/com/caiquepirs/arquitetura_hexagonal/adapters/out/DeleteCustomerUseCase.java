package com.caiquepirs.arquitetura_hexagonal.adapters.out;

import com.caiquepirs.arquitetura_hexagonal.adapters.out.repository.CustomerRepository;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.DeleteCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerUseCase implements DeleteCustomerInputPort {

    @Autowired
    private CustomerRepository customerRepository;

    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}

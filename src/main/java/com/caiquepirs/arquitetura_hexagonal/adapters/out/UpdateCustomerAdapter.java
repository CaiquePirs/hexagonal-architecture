package com.caiquepirs.arquitetura_hexagonal.adapters.out;

import com.caiquepirs.arquitetura_hexagonal.adapters.out.repository.CustomerEntityMapper;
import com.caiquepirs.arquitetura_hexagonal.adapters.out.repository.CustomerRepository;
import com.caiquepirs.arquitetura_hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    public void update(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toEntity(customer);
        customerRepository.save(customerEntity);
    }
}

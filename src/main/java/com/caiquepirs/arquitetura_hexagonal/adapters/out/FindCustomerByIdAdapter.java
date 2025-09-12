package com.caiquepirs.arquitetura_hexagonal.adapters.out;

import com.caiquepirs.arquitetura_hexagonal.adapters.out.repository.CustomerEntityMapper;
import com.caiquepirs.arquitetura_hexagonal.adapters.out.repository.CustomerRepository;
import com.caiquepirs.arquitetura_hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerEntityMapper customerEntityMapper;

    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}

package com.caiquepirs.arquitetura_hexagonal.application.ports.out;

import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);

}

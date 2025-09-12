package com.caiquepirs.arquitetura_hexagonal.application.ports.out;

import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}

package com.caiquepirs.arquitetura_hexagonal.application.ports.in;

import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);

}

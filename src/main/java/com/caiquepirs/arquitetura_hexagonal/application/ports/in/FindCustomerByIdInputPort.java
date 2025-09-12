package com.caiquepirs.arquitetura_hexagonal.application.ports.in;

import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}

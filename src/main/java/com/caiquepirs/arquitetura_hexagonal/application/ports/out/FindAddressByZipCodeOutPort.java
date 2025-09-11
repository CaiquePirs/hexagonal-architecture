package com.caiquepirs.arquitetura_hexagonal.application.ports.out;

import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutPort {

    Address find(String zipCode);
}

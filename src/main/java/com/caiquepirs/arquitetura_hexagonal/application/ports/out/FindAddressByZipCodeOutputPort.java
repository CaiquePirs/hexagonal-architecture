package com.caiquepirs.arquitetura_hexagonal.application.ports.out;

import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}

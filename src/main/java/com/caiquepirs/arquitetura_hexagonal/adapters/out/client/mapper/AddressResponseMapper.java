package com.caiquepirs.arquitetura_hexagonal.adapters.out.client.mapper;

import com.caiquepirs.arquitetura_hexagonal.adapters.out.client.response.AddressResponse;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}

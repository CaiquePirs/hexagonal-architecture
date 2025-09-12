package com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers.request;

import com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers.response.CustomerResponse;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toEntity(CustomerRequest customerRequest);

    CustomerResponse toResponse(Customer customer);
}

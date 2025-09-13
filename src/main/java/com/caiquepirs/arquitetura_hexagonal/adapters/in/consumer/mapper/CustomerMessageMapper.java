package com.caiquepirs.arquitetura_hexagonal.adapters.in.consumer.mapper;

import com.caiquepirs.arquitetura_hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);

}

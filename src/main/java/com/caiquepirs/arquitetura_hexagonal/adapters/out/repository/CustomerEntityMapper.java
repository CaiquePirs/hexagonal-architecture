package com.caiquepirs.arquitetura_hexagonal.adapters.out.repository;

import com.caiquepirs.arquitetura_hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toEntity(Customer customer);

}

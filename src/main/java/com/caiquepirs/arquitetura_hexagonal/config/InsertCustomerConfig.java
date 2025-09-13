package com.caiquepirs.arquitetura_hexagonal.config;

import com.caiquepirs.arquitetura_hexagonal.adapters.FindAddressByZipCodeAdapter;
import com.caiquepirs.arquitetura_hexagonal.adapters.out.InsertCustomersAdapter;
import com.caiquepirs.arquitetura_hexagonal.application.core.usecases.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomersAdapter insertCustomersAdapter){

        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomersAdapter);
    }

}

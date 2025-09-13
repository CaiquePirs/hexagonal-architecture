package com.caiquepirs.arquitetura_hexagonal.config;

import com.caiquepirs.arquitetura_hexagonal.adapters.FindAddressByZipCodeAdapter;
import com.caiquepirs.arquitetura_hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.caiquepirs.arquitetura_hexagonal.adapters.out.UpdateCustomerAdapter;
import com.caiquepirs.arquitetura_hexagonal.application.core.usecases.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerByIdConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            UpdateCustomerAdapter updateCustomerAdapter,
            FindCustomerByIdAdapter findCustomerByIdAdapter,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter){

        return new UpdateCustomerUseCase(
                findCustomerByIdAdapter,
                findAddressByZipCodeAdapter,
                updateCustomerAdapter);
    }

}

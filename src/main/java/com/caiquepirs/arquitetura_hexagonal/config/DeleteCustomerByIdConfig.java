package com.caiquepirs.arquitetura_hexagonal.config;

import com.caiquepirs.arquitetura_hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.caiquepirs.arquitetura_hexagonal.application.core.usecases.DeleteCustomerByIdUseCase;
import com.caiquepirs.arquitetura_hexagonal.application.core.usecases.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase DeleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter){

        return new DeleteCustomerByIdUseCase(deleteCustomerByIdAdapter, findCustomerByIdUseCase);
    }

}

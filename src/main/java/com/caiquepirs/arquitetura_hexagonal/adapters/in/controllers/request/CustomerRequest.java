package com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank(message = "CPF is required")
    private String cpf;

    @NotBlank(message = "Name is required")
    private String nome;

    @NotBlank(message = "ZipCode is required")
    private String zipCode;
}

package com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private String name;
    private String cpf;
    private AddressResponse addressResponse;
    private boolean isValidCpf;
}

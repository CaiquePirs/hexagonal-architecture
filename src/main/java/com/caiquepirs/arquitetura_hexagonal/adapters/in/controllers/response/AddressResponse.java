package com.caiquepirs.arquitetura_hexagonal.adapters.in.controllers.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String street;
    private String city;
    private String state;
}

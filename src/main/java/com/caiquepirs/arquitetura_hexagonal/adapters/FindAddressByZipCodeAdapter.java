package com.caiquepirs.arquitetura_hexagonal.adapters;

import com.caiquepirs.arquitetura_hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.caiquepirs.arquitetura_hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.caiquepirs.arquitetura_hexagonal.adapters.out.client.response.AddressResponse;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Address;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    public Address find(String zipCode) {
        AddressResponse addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}

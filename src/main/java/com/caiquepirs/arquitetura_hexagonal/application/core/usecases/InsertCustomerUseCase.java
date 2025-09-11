package com.caiquepirs.arquitetura_hexagonal.application.core.usecases;

import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Address;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;


    public InsertCustomerUseCase(FindAddressByZipCodeOutPort findAddressByZipCodeOutPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort){
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void insert(Customer customer, String zipCode){
        Address address = findAddressByZipCodeOutPort.find(zipCode);
        customer.setAddress(address);

        insertCustomerOutputPort.insert(customer);
    }


}

package com.caiquepirs.arquitetura_hexagonal.application.core.usecases;

import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Address;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.CustomerUseCaseInputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.SendCpfValidationOutputPort;

public class InsertCustomerUseCase implements CustomerUseCaseInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfValidationOutputPort sendCpfValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfValidationOutputPort sendCpfValidationOutputPort){
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfValidationOutputPort = sendCpfValidationOutputPort;
    }

    public void insert(Customer customer, String zipCode){
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);

        insertCustomerOutputPort.insert(customer);
        sendCpfValidationOutputPort.send(customer.getCpf());
    }


}

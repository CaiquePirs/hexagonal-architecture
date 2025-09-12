package com.caiquepirs.arquitetura_hexagonal.application.core.usecases;

import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Address;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final UpdateCustomerOutputPort updateCustomerOutputPort;
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort){

        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    public void update(Customer customer, String zipCode){
        findCustomerByIdOutputPort.find(customer.getId());
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }


}

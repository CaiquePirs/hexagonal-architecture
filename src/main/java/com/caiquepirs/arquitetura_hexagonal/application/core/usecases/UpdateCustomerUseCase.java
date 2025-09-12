package com.caiquepirs.arquitetura_hexagonal.application.core.usecases;

import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final UpdateCustomerOutputPort updateCustomerOutputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipCodeOutPort findAddressByZipCodeOutPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort){

        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    public void update(Customer customer, String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        findAddressByZipCodeOutPort.find(zipCode);
        updateCustomerOutputPort.update(customer);
    }



}

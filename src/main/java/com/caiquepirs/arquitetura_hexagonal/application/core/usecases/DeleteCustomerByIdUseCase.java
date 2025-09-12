package com.caiquepirs.arquitetura_hexagonal.application.core.usecases;

import com.caiquepirs.arquitetura_hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.DeleteCustomerOutputPort;

public class DeleteCustomerByIdUseCase {

    private final DeleteCustomerOutputPort deleteCustomerOutputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public DeleteCustomerByIdUseCase(DeleteCustomerOutputPort deleteCustomerOutputPort,
                                     FindCustomerByIdInputPort findCustomerByIdInputPort){

        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerOutputPort.delete(id);
    }

}

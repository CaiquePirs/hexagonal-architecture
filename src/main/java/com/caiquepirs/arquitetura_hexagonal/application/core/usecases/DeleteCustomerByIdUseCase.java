package com.caiquepirs.arquitetura_hexagonal.application.core.usecases;

import com.caiquepirs.arquitetura_hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.caiquepirs.arquitetura_hexagonal.application.ports.out.DeleteCustomerOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerInputPort {

    private final DeleteCustomerOutputPort deleteCustomerOutputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public DeleteCustomerByIdUseCase(DeleteCustomerOutputPort deleteCustomerOutputPort,
                                     FindCustomerByIdInputPort findCustomerByIdInputPort){

        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    public void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerOutputPort.delete(id);
    }

}

package com.caiquepirs.arquitetura_hexagonal.adapters.in.consumer;

import com.caiquepirs.arquitetura_hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.caiquepirs.arquitetura_hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.caiquepirs.arquitetura_hexagonal.application.core.domain.Customer;
import com.caiquepirs.arquitetura_hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidateCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validate", groupId = "arantes")
    public void receive(CustomerMessage customerMessage){
        Customer customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }


}

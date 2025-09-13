package com.caiquepirs.arquitetura_hexagonal.adapters;

import com.caiquepirs.arquitetura_hexagonal.application.ports.out.SendCpfValidationOutputPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationPortAdapter implements SendCpfValidationOutputPort {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}

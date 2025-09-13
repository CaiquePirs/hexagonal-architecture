package com.caiquepirs.arquitetura_hexagonal.application.ports.out;

public interface SendCpfValidationOutputPort {

    void send(String cpf);
}

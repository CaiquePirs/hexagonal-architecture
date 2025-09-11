package com.caiquepirs.arquitetura_hexagonal.application.core.domain;

public class Customer {

    private String id;
    private String name;
    private String cpf;
    private Address address;
    private boolean isValidCpf;

    public Customer(String cpf, String id, String name, Address address) {
        this.cpf = cpf;
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Customer() {
        this.isValidCpf = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isValidCpf() {
        return isValidCpf;
    }

    public void setValidCpf(boolean validCpf) {
        isValidCpf = validCpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

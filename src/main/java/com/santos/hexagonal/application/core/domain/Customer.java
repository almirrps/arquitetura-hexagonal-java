package com.santos.hexagonal.application.core.domain;

public class Customer {

    private String id;
    private String name;
    private String cpf;
    private Boolean isValidCpf;
    private Address address;

    public Customer() {
        this.isValidCpf = false;  //Definindo o valor default no construtor
    }

    public Customer(String id, String name, String cpf, Boolean isValidCpf, Address address) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getIsValidCpf() {
        return isValidCpf;
    }

    public void setIsValidCpf(Boolean isValidCpf) {
        this.isValidCpf = isValidCpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}

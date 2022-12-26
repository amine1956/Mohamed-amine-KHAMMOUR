package com.example.command;

import lombok.Getter;

public class CreateCustomerCommand extends BaseCustomerCommand<String> {
    @Getter
    private String name;
    @Getter private String email;
    @Getter private String phone;
    @Getter private  String Address;

    public CreateCustomerCommand(String id, String name, String email, String phone, String address) {
        super(id);
        this.name = name;
        this.email = email;
        this.phone = phone;
        Address = address;

    }
}


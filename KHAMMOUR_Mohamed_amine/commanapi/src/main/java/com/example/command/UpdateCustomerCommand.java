package com.example.command;

import lombok.Getter;

public class UpdateCustomerCommand extends BaseCustomerCommand<String> {
    @Getter
    private String name;
    @Getter private String email;
    @Getter private String phone;
    @Getter private  String Address;

    public UpdateCustomerCommand(String id, String name, String email, String phone, String address) {
        super(id);
        this.name = name;
        this.email = email;
        this.phone = phone;
        Address = address;

    }
}


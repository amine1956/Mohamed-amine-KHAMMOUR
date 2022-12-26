package com.example.event;

import lombok.Getter;

public class CustomerCreatedEvent extends BaseEventCustomer<String> {
    @Getter
    private String name;
    @Getter private String email;
    @Getter  private String phone;
    @Getter  private String Address;


    public CustomerCreatedEvent(String id, String name, String email, String phone, String address) {
        super(id);
        this.name = name;
        this.email = email;
        this.phone = phone;
        Address = address;
    }
}


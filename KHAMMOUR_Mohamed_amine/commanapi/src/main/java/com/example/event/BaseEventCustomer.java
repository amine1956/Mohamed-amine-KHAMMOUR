package com.example.event;

public class BaseEventCustomer <T>{

    public  T id;

    public BaseEventCustomer(T id) {
        this.id = id;
    }
    public T getId() {
        return id;
    }

}

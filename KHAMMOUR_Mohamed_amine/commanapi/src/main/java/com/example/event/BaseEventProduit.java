package com.example.event;

public class BaseEventProduit <T>{
    public  T id;

    public BaseEventProduit(T id) {
        this.id = id;
    }
    public T getId() {
        return id;
    }
}

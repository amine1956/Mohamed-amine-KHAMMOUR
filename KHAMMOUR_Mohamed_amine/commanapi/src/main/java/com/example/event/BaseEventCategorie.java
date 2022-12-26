package com.example.event;

public class BaseEventCategorie <T>{

    public  T id;

    public BaseEventCategorie(T id) {
        this.id = id;
    }
    public T getId() {
        return id;
    }


}
